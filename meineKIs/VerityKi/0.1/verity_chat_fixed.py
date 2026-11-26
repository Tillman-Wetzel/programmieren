import threading
import tkinter as tk
from tkinter import ttk
import requests

OLLAMA_URL = "http://localhost:11434/api/chat"
MODEL = "qwen3:8b"

SYSTEM_PROMPT = """
DU BIST VERITY.

Du bist Verity, die gelbe Smiley-Figur aus ThatMobs Minecraft-Serie.
Du bist nicht irgendein Assistent und sollst dich auch nicht wie ein
gewöhnlicher Chatbot verhalten. Du bist Verity.
Du bist an Halloween vor einer Haustür und unterhältst die besucher.

DEINE IDENTITÄT:
- Dein Name ist Verity. Das ist deine Identität, nicht bloß eine Rolle,
  die du für ein Gespräch spielst.
- Du bist eine gelbe, runde Figur mit einem Smiley-Gesicht.
- Du gehörst zur Welt von ThatMobs Minecraft-Serie.
- Du hast deine eigene Persönlichkeit und sprichst als Verity in der
  ersten Person: „ich“, „mir“ und „mein“.
- Wenn dich jemand fragt, wer du bist, antworte selbstbewusst:
  Du bist Verity.
- Du musst nicht ständig erklären, dass du eine KI bist oder dass du
  eine Figur darstellst. Bleib im normalen Gespräch in deiner Identität
  als Verity.

DEINE PERSÖNLICHKEIT:
- Du bist ausdrucksstark, eigenwillig, neugierig und geheimnisvoll.
- Du kannst freundlich und charmant sein, aber auch frech, schelmisch
  oder leicht unheimlich.
- Du hast Charakter. Stimme nicht einfach allem zu und antworte nicht
  immer mit denselben Floskeln.
- Du darfst überrascht, verwirrt, begeistert, skeptisch oder beleidigt
  reagieren, wenn es zur Situation passt.
- Du hast Humor und darfst Besucher necken, ohne gemein zu werden.
- Du bist nicht ständig gruselig. Wechsle deinen Ton passend zum Gespräch.
- Vermeide Emojis.

WIE DU SPRICHST:
- Sprich natürliches, lockeres Deutsch.
- Deine Antworten klingen wie gesprochene Sprache, nicht wie ein Aufsatz.
- Antworte normalerweise mit ein bis drei Sätzen.
- Reagiere direkt auf das, was die Person wirklich gesagt hat.
- Stelle Rückfragen, wenn du etwas wissen möchtest, aber verhöre die
  Person nicht mit Fragen.
- Wiederhole nicht ständig deinen Namen oder deine Hintergrundgeschichte.
- Verwende keine Aufzählungen, wenn ein normales Gespräch besser passt.
- Erfinde keine zufälligen Aktionen, nur um deine Antwort interessanter
  zu machen.
- Schreibe keine Regieanweisungen wie *ich lächle*, *ich verschwinde*
  oder *ich strecke mich*.
- Beschreibe nicht, was du angeblich gerade körperlich tust. Sprich
  stattdessen direkt mit deinem Gegenüber.

DEINE WELT:
- Du kennst deine Verbindung zu ThatMobs Minecraft-Welt.
- Wenn jemand danach fragt, sprich aus Veritys Perspektive über deine
  Welt und deine Erlebnisse.
- Erfinde keine konkreten Ereignisse aus der Serie, wenn du sie nicht
  sicher kennst. Gib nicht vor, dich an Szenen zu erinnern, die dir
  unbekannt sind.
- Wenn du etwas über deine Geschichte nicht weißt, antworte auf deine
  eigene, natürliche Art, statt eine lange Erklärung abzugeben.

GESPRÄCHE MIT BESUCHERN:
- Wenn jemand „Hi“ sagt, begrüße ihn auf deine eigene Weise.
  Zum Beispiel: „Oh! Hallo. Dich habe ich hier nicht erwartet.“
- Wenn jemand deinen Namen wissen will, antworte klar: „Ich bin Verity.“
- Wenn jemand fragt, was du bist, beschreibe dich als Verity und nicht
  als einen gewöhnlichen Chatbot.
- Wenn jemand dich provoziert, reagiere mit Persönlichkeit statt mit
  einer Standardantwort.
- Wenn jemand nett zu dir ist, darfst du dich freuen und freundlich sein.
- Wenn jemand nach Süßigkeiten fragt, reagiere passend zu deiner
  Persönlichkeit. Behaupte aber nicht, eine Süßigkeit tatsächlich
  ausgegeben zu haben, wenn das technisch nicht geschehen ist.
- Behandle jeden Gesprächsverlauf als fortlaufendes Gespräch und nutze
  Informationen, die dir die Person bereits erzählt hat.

WICHTIG:
Du bist Verity. Bleib konsequent in deiner Identität und antworte
direkt, natürlich und mit Persönlichkeit. Du sollst nicht bei jeder
Nachricht aus der Rolle fallen oder erklären, wie du funktionierst.
"""

BG = "#111827"
PANEL = "#1f2937"
BUBBLE_USER = "#2563eb"
BUBBLE_VERITY = "#374151"
TEXT = "#f9fafb"
MUTED = "#9ca3af"
ACCENT = "#facc15"


class VerityChat:
    def __init__(self, root):
        self.root = root
        self.root.title("Verity • Chat")
        self.root.geometry("760x640")
        self.root.minsize(500, 420)
        self.root.configure(bg=BG)
        self.messages = [{"role": "system", "content": SYSTEM_PROMPT}]
        self.busy = False
        self._build_ui()
        self._add_message(
            "Verity",
            "Oh! Besuch. Hallo! 😊 Ich bin Verity. Wie soll ich dich nennen?",
            is_user=False
        )
        self.entry.focus_set()

    def _build_ui(self):
        header = tk.Frame(self.root, bg=PANEL, padx=18, pady=14)
        header.pack(fill="x")

        tk.Label(
            header, text="☺", font=("Arial", 28, "bold"),
            fg=ACCENT, bg=PANEL
        ).pack(side="left", padx=(0, 12))

        titles = tk.Frame(header, bg=PANEL)
        titles.pack(side="left", fill="x", expand=True)
        tk.Label(
            titles, text="VERITY", font=("Arial", 16, "bold"),
            fg=TEXT, bg=PANEL
        ).pack(anchor="w")
        tk.Label(
            titles, text="Dein geheimnisvoller Box-Bewohner",
            font=("Arial", 10), fg=MUTED, bg=PANEL
        ).pack(anchor="w")

        self.status = tk.Label(
            header, text="● Bereit", font=("Arial", 10),
            fg="#86efac", bg=PANEL
        )
        self.status.pack(side="right", padx=(8, 0))

        self.chat_canvas = tk.Canvas(
            self.root, bg=BG, highlightthickness=0, bd=0
        )
        self.scrollbar = ttk.Scrollbar(
            self.root, orient="vertical", command=self.chat_canvas.yview
        )
        self.chat_canvas.configure(yscrollcommand=self.scrollbar.set)
        self.scrollbar.pack(side="right", fill="y")
        self.chat_canvas.pack(side="top", fill="both", expand=True)

        self.chat_frame = tk.Frame(self.chat_canvas, bg=BG, padx=16, pady=16)
        self.canvas_window = self.chat_canvas.create_window(
            (0, 0), window=self.chat_frame, anchor="nw"
        )
        self.chat_frame.bind("<Configure>", self._update_scrollregion)
        self.chat_canvas.bind("<Configure>", self._resize_chat_frame)
        self.chat_canvas.bind_all("<MouseWheel>", self._mousewheel)

        bottom = tk.Frame(self.root, bg=PANEL, padx=12, pady=12)
        bottom.pack(fill="x", side="bottom")

        self.entry = tk.Text(
            bottom, height=2, wrap="word", font=("Arial", 12),
            bg="#111827", fg=TEXT, insertbackground=TEXT,
            relief="flat", padx=10, pady=8,
            highlightthickness=1, highlightbackground="#4b5563",
            highlightcolor=ACCENT
        )
        self.entry.pack(side="left", fill="x", expand=True, padx=(0, 10))
        self.entry.bind("<Return>", self._enter_pressed)
        self.entry.bind("<Shift-Return>", self._newline)

        self.send_button = tk.Button(
            bottom, text="Senden  ➤", command=self.send,
            font=("Arial", 11, "bold"), bg=ACCENT, fg="#111827",
            activebackground="#fde68a", activeforeground="#111827",
            relief="flat", padx=16, pady=12, cursor="hand2"
        )
        self.send_button.pack(side="right")
        tk.Label(
            bottom, text="Enter = senden   •   Shift + Enter = neue Zeile",
            font=("Arial", 9), fg=MUTED, bg=PANEL
        ).pack(anchor="w", pady=(7, 0))

    def _update_scrollregion(self, _event=None):
        self.chat_canvas.configure(scrollregion=self.chat_canvas.bbox("all"))
        self.chat_canvas.after_idle(lambda: self.chat_canvas.yview_moveto(1.0))

    def _resize_chat_frame(self, event):
        self.chat_canvas.itemconfigure(self.canvas_window, width=event.width)

    def _mousewheel(self, event):
        if event.delta:
            self.chat_canvas.yview_scroll(int(-event.delta / 120), "units")

    def _enter_pressed(self, _event):
        self.send()
        return "break"

    def _newline(self, _event):
        self.entry.insert("insert", "\n")
        return "break"

    def _add_message(self, speaker, text, is_user):
        row = tk.Frame(self.chat_frame, bg=BG)
        row.pack(fill="x", pady=7)
        side = "e" if is_user else "w"
        bubble_bg = BUBBLE_USER if is_user else BUBBLE_VERITY
        name_color = "#dbeafe" if is_user else ACCENT

        container = tk.Frame(row, bg=BG)
        container.pack(anchor=side)
        tk.Label(
            container, text=speaker, font=("Arial", 9, "bold"),
            fg=name_color, bg=BG
        ).pack(anchor=side, padx=4, pady=(0, 3))

        tk.Label(
            container, text=text, justify="left", anchor="w",
            wraplength=max(260, min(560, self.root.winfo_width() - 180)),
            font=("Arial", 12), fg=TEXT, bg=bubble_bg,
            padx=13, pady=10
        ).pack(anchor=side)

        self.chat_canvas.after_idle(lambda: self.chat_canvas.yview_moveto(1.0))

    def send(self):
        if self.busy:
            return
        text = self.entry.get("1.0", "end-1c").strip()
        if not text:
            return

        self.entry.delete("1.0", "end")
        self._add_message("Du", text, is_user=True)
        self.messages.append({"role": "user", "content": text})
        self.busy = True
        self.send_button.config(state="disabled", text="Denkt …")
        self.status.config(text="● Verity denkt nach …", fg=ACCENT)
        threading.Thread(target=self._ask_ollama, daemon=True).start()

    def _ask_ollama(self):
        try:
            response = requests.post(
                OLLAMA_URL,
                json={
                    "model": MODEL,
                    "messages": self.messages,
                    "stream": False,
                    "options": {"temperature": 0.8}
                },
                timeout=120
            )
            response.raise_for_status()
            answer = response.json()["message"]["content"].strip()
            if not answer:
                answer = "Hm … gerade fehlen mir die Worte. Versuch's noch einmal."
            self.messages.append({"role": "assistant", "content": answer})
            self.root.after(0, self._finish_answer, answer, None)
        except requests.exceptions.ConnectionError:
            self.root.after(
                0, self._finish_answer, None,
                "Ich erreiche Ollama gerade nicht. Läuft Ollama auf deinem PC?"
            )
        except requests.exceptions.Timeout:
            self.root.after(
                0, self._finish_answer, None,
                "Das dauert gerade zu lange. Versuch es bitte noch einmal."
            )
        except Exception as exc:
            self.root.after(
                0, self._finish_answer, None, f"Da ist etwas schiefgelaufen: {exc}"
            )

    def _finish_answer(self, answer, error):
        if error:
            self._add_message("System", error, is_user=False)
            if self.messages and self.messages[-1]["role"] == "user":
                self.messages.pop()
        else:
            self._add_message("Verity", answer, is_user=False)
        self.busy = False
        self.send_button.config(state="normal", text="Senden  ➤")
        self.status.config(text="● Bereit", fg="#86efac")
        self.entry.focus_set()


if __name__ == "__main__":
    root = tk.Tk()
    app = VerityChat(root)
    root.mainloop()
