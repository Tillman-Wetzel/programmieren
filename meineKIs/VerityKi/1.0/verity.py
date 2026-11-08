import os
import re
import time
import tempfile
import subprocess
import sys
from collections import deque
from pathlib import Path

import requests
import numpy as np
import sounddevice as sd
from scipy.io import wavfile
from faster_whisper import WhisperModel


# ============================================================
# VERITY - KONFIGURATION
# ============================================================

OLLAMA_URL = "http://localhost:11434/api/chat"
OLLAMA_MODEL = "qwen3:4b"

VOICE_MODEL = os.path.abspath(
    "voices/de_DE-thorsten-medium.onnx"
)

VOICE_CONFIG = os.path.abspath(
    "voices/de_DE-thorsten-medium.onnx.json"
)

SAMPLE_RATE = 16000
BLOCK_SIZE = 1024

# Mikrofonempfindlichkeit:
# Bei zu vielen Fehlaktivierungen erhöhen.
# Wenn Verity dich nicht hört, vorsichtig verringern.
SPEECH_THRESHOLD = 0.015

# Wie lange Stille bis zum Ende eines Satzes erlaubt ist.
SILENCE_SECONDS = 2.4

# Maximale Länge einer einzelnen Äußerung.
MAX_RECORD_SECONDS = 15

# Wie lange Verity auf den Anfang einer Äußerung wartet.
PRE_ROLL_BLOCKS = 5


# ============================================================
# VERITYS PERSÖNLICHKEIT
# ============================================================

# System-Prompt aus einer externen Textdatei laden
PROMPT_FILE = Path(__file__).resolve().parent / "system_prompt.txt"

try:
    SYSTEM_PROMPT = PROMPT_FILE.read_text(encoding="utf-8").strip()
except FileNotFoundError:
    raise FileNotFoundError(
        f"Die Prompt-Datei wurde nicht gefunden: {PROMPT_FILE}"
    )


# ============================================================
# SPRACHERKENNUNG LADEN
# ============================================================

print("Verity lädt die Spracherkennung ...")

# Zuverlässiger Start im CPU-Modus.
# GPU-Beschleunigung können wir später ergänzen.
whisper = WhisperModel(
    "small",
    device="cpu",
    compute_type="int8"
)

print("Spracherkennung bereit.")


# ============================================================
# GESPRÄCHSVERLAUF
# ============================================================

messages = [
    {
        "role": "system",
        "content": SYSTEM_PROMPT
    }
]


# ============================================================
# MIKROFON: AUF SPRACHE WARTEN
# ============================================================

def listen_for_speech():
    """
    Wartet auf eine hörbare Äußerung und nimmt sie bis zu einer
    Sprechpause auf.

    Die Aufnahme wird nur vorübergehend für die Erkennung
    verwendet und nicht als dauerhafte Audiodatei gespeichert.
    """

    print("\n🎙️ Verity hört zu ...")

    pre_roll = deque(maxlen=PRE_ROLL_BLOCKS)
    audio_chunks = []

    speech_started = False
    silent_blocks = 0

    silence_limit = int(
        SILENCE_SECONDS * SAMPLE_RATE / BLOCK_SIZE
    )

    max_blocks = int(
        MAX_RECORD_SECONDS * SAMPLE_RATE / BLOCK_SIZE
    )

    with sd.InputStream(
        samplerate=SAMPLE_RATE,
        channels=1,
        dtype="float32",
        blocksize=BLOCK_SIZE
    ) as stream:

        while True:
            audio, overflowed = stream.read(BLOCK_SIZE)

            if overflowed:
                print("Hinweis: Mikrofonpuffer war kurz überlastet.")

            audio = audio.flatten()
            volume = float(np.sqrt(np.mean(audio ** 2)))

            if not speech_started:
                pre_roll.append(audio.copy())

                if volume >= SPEECH_THRESHOLD:
                    speech_started = True

                    audio_chunks.extend(
                        chunk.copy() for chunk in pre_roll
                    )

                    print("🗣️ Sprache erkannt ...")

            else:
                audio_chunks.append(audio.copy())

                if volume < SPEECH_THRESHOLD:
                    silent_blocks += 1
                else:
                    silent_blocks = 0

                # Genug Stille: Die Äußerung ist wahrscheinlich fertig.
                if silent_blocks >= silence_limit:
                    break

                # Sicherheit: Aufnahme nicht unbegrenzt fortsetzen.
                if len(audio_chunks) >= max_blocks:
                    break

    if not audio_chunks:
        return None

    audio_data = np.concatenate(audio_chunks)

    # Leise Aufnahme vermeiden.
    if np.max(np.abs(audio_data)) < 0.005:
        return None

    return audio_data


# ============================================================
# SPRACHE IN TEXT UMWANDELN
# ============================================================

def transcribe_audio(audio_data):
    """
    Wandelt die aufgenommene Sprache in deutschen Text um.
    Die temporäre WAV-Datei wird anschließend gelöscht.
    """

    filename = None

    try:
        # Whisper erwartet hier eine WAV-Datei.
        pcm = np.clip(audio_data, -1.0, 1.0)
        pcm = (pcm * 32767).astype(np.int16)

        with tempfile.NamedTemporaryFile(
            suffix=".wav",
            delete=False
        ) as temp:
            filename = temp.name

        wavfile.write(
            filename,
            SAMPLE_RATE,
            pcm
        )

        segments, info = whisper.transcribe(
            filename,
            language="de",
            beam_size=3,
            vad_filter=True
        )

        text = " ".join(
            segment.text.strip()
            for segment in segments
        ).strip()

        return text

    finally:
        if filename and os.path.exists(filename):
            os.remove(filename)


# ============================================================
# MIT OLLAMA SPRECHEN
# ============================================================

def ask_verity(user_text):
    """
    Sendet den erkannten Text an Ollama und liefert Veritys
    Antwort zurück.
    """

    messages.append({
        "role": "user",
        "content": user_text
    })

    # Gesprächsverlauf begrenzen, damit er nicht unbegrenzt wächst.
    # Die Systemanweisung bleibt immer erhalten.
    if len(messages) > 21:
        del messages[1:3]

    payload = {
        "model": OLLAMA_MODEL,
        "messages": messages,
        "stream": False,
        "options": {
            "temperature": 0.8
        }
    }

    try:
        response = requests.post(
            OLLAMA_URL,
            json=payload,
            timeout=180
        )

        response.raise_for_status()

        data = response.json()
        answer = data["message"]["content"].strip()

        # Verhindert, dass mögliche Denk-Markierungen vorgelesen
        # werden, falls das Modell solche ausgibt.
        answer = re.sub(
            r"<think>.*?</think>",
            "",
            answer,
            flags=re.DOTALL
        ).strip()

        if not answer:
            answer = "Ähm ... mein Kopf ist gerade voller Kürbisse!"

        messages.append({
            "role": "assistant",
            "content": answer
        })

        return answer

    except requests.RequestException as error:
        print(f"Ollama-Fehler: {error}")

        # Die nicht beantwortete Eingabe aus dem Verlauf entfernen.
        if messages and messages[-1]["role"] == "user":
            messages.pop()

        return (
            "Moment mal! Mein Gehirn scheint gerade "
            "nicht erreichbar zu sein."
        )


# ============================================================
# ANTWORT LAUT AUSGEBEN
# ============================================================

def speak(text):
    """
    Erzeugt eine deutsche Sprachausgabe mit Piper und spielt
    sie über den Standardlautsprecher ab.
    """

    print(f"\n👻 Verity: {text}")

    if not os.path.isfile(VOICE_MODEL):
        print("Fehler: Das Piper-Stimmenmodell fehlt.")
        print("Bitte prüfe den Ordner voices.")
        return

    output_file = None

    try:
        with tempfile.NamedTemporaryFile(
            suffix=".wav",
            delete=False
        ) as temp:
            output_file = temp.name

        command = [
            sys.executable,
            "-m",
            "piper",
            "-m",
            VOICE_MODEL,
            "-f",
            output_file,
            "--",
            text
        ]

        subprocess.run(
            command,
            check=True,
            stdout=subprocess.DEVNULL,
            stderr=subprocess.PIPE,
            text=True,
            timeout=120
        )

        sample_rate, audio = wavfile.read(output_file)

        if audio.dtype == np.int16:
            audio = audio.astype(np.float32) / 32768.0
        elif audio.dtype == np.int32:
            audio = audio.astype(np.float32) / 2147483648.0
        else:
            audio = audio.astype(np.float32)

        sd.play(audio, sample_rate)
        sd.wait()

    except Exception as error:
        print(f"Sprachausgabe fehlgeschlagen: {error}")

    finally:
        if output_file and os.path.exists(output_file):
            os.remove(output_file)


# ============================================================
# HAUPTPROGRAMM
# ============================================================

def main():
    print()
    print("=" * 48)
    print("       VERITY - HALLOWEEN VOICE AI")
    print("=" * 48)
    print("Verity ist bereit.")
    print("Sprich einfach mit Verity.")
    print('Sage "Verity aus", um das Programm zu beenden.')
    print()
    print("Mikrofon aktiv: Die Spracherkennung läuft lokal.")
    print("Zum Beenden jederzeit Strg+C drücken.")

    while True:
        try:
            audio = listen_for_speech()

            if audio is None:
                continue

            user_text = transcribe_audio(audio)

            if not user_text:
                print("Keine verständliche Sprache erkannt.")
                continue

            print(f"📝 Du: {user_text}")

            normalized = user_text.lower().strip()
            normalized = re.sub(r"[.!?,]+$", "", normalized)

            # Sprachbefehl zum Beenden.
            if normalized in {
                "verity aus",
                "verity beenden",
                "beende verity",
                "tschüss verity"
            }:
                speak("Na schön! Bis später, Sterblicher!")
                break

            # Mit Ollama antworten.
            answer = ask_verity(user_text)

            # Antwort sprechen.
            speak(answer)

        except KeyboardInterrupt:
            print("\nVerity wird beendet.")
            break

        except Exception as error:
            print(f"Fehler: {error}")
            print("Verity versucht es erneut.")
            time.sleep(1)


if __name__ == "__main__":
    main()