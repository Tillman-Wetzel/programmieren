# Fallback, nur wenn der pip-Install streikt:
# !pip install -U -q "toolboxv2[isaa] @ git+https://github.com/MarkinHaus/ToolBoxV2.git"
!pip install -q "toolboxv2[isaa]==0.1.28"
!wget -q -O quick_isaa.py https://gist.githubusercontent.com/MarkinHaus/e9b3898aa61e300e3cb738a0e1f99720/raw/quick_isaa.py

from quick_isaa import llm, llm_mit_tools, tool, verbinde_drive, speichern, laden
print("quick_isaa ist bereit.")

from IPython.display import HTML, display

def zeige_html(dateiname, hoehe=420):
    with open(dateiname) as f:
        inhalt = f.read()
    display(HTML(f'<iframe srcdoc="{inhalt.replace(chr(34), "&quot;")}" width="100%" height="{hoehe}"></iframe>'))

print("zeige_html bereit.")

verbinde_drive()

def lade_oder(name, standard):
    try:
        wert = laden(name)
        return wert if wert else standard
    except Exception:
        return standard

system_prompt = lade_oder("system_prompt", """
Du bist ein freundlicher Lern-Bot für Jugendliche.
Antworte kurz und verständlich, stelle Rückfragen, wenn etwas unklar ist.
Nutze das Weltmodell und deine Tools, wenn sie helfen.
""")

weltmodell = lade_oder("weltmodell", {
    "user-name": None,
    "user-lieblingsessen": None,
    "user-lieblingsfach": None,
    "ziel": "Python und KI-Agenten verstehen",
})
history = lade_oder("history", [])
memory  = lade_oder("memory", "")     # Zusammenfassung alter Nachrichten
max_history_messages = 8

def komprimiere_history():
    # Chat zu lang? Alte Nachrichten zusammenfassen, nur die letzten 4 behalten.
    global history, memory
    if len(history) <= max_history_messages:
        return
    alte = history[:-4]
    history = history[-4:]
    memory = llm([
        {"role": "system", "content": "Fasse den Chat kurz als Memory für einen Agenten zusammen."},
        {"role": "user", "content": "Alte Zusammenfassung:\n" + memory + "\n\nNeue Nachrichten:\n" + str(alte)},
    ])
    speichern("memory", memory)

def frage_agent(user_text):
    messages = [
        {"role": "system", "content": system_prompt
                    + "\nWeltmodell: " + str(weltmodell)
                    + "\nMemory (alte Nachrichten): " + memory},
    ] + history + [
        {"role": "user", "content": user_text},
    ]
    antwort = llm_mit_tools(messages)   # 👈 einzige Änderung zu gestern: Tools!

    history.append({"role": "user", "content": user_text})
    history.append({"role": "assistant", "content": antwort})

    komprimiere_history()
    speichern("history", history)
    speichern("weltmodell", weltmodell)
    speichern("system_prompt", system_prompt)
    return antwort

print("Agent bereit. Weltmodell:", weltmodell)

"""# Teil 2 - Tools"""

import random

@tool
def wuerfeln(seiten: int = 6):
    """Würfelt eine Zahl zwischen 1 und seiten."""
    return random.randint(1, seiten)

import random

@tool
def muenzwurf():
    """Wirft eine Münze und gibt Kopf oder Zahl zurück."""
    return random.choice(["Kopf", "Zahl"])

@tool
def weltmodell_schreiben(schluessel: str, wert: str):
    """Speichert eine Info über den User dauerhaft im Weltmodell."""
    weltmodell[schluessel] = wert
    speichern("weltmodell", weltmodell)
    return f"Gespeichert: {schluessel} = {wert}"

@tool
def datei_schreiben(dateiname: str, inhalt: str):
    """Schreibt Text/Code in eine Datei (z.B. eine .html-Seite)."""
    with open(dateiname, "w") as f:
        f.write(inhalt)
    return f"{dateiname} geschrieben ({len(inhalt)} Zeichen)."

@tool
def datei_lesen(dateiname: str):
    """Liest den Inhalt einer Datei."""
    with open(dateiname) as f:
        return f.read()
