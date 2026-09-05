import json
import re
import ollama

MODEL = "llama3.2"
JSON_DATEI = "diedPlayers.json"


def lade_vergebene_namen():
    try:
        with open(JSON_DATEI, "r", encoding="utf-8") as datei:
            daten = json.load(datei)

        return {
            name.lower()
            for name in daten.get("namen", [])
            if isinstance(name, str)
        }

    except FileNotFoundError:
        return set()


def ist_gueltiger_minecraft_name(name):
    """
    Prüft:
    - 3 bis 16 Zeichen
    - nur A-Z, a-z, 0-9 und _
    """
    return (
        3 <= len(name) <= 16
        and re.fullmatch(r"[A-Za-z0-9_]+", name) is not None
    )


def generiere_namen():
    vergebene_namen = lade_vergebene_namen()

    while True:
        response = ollama.chat(
            model=MODEL,
            messages=[
                {
                    "role": "system",
                    "content": """
Du bist ein Generator für Minecraft Java Spielernamen.

Erstelle genau 3 unterschiedliche Spielernamen.

Regeln für jeden Namen:
- mindestens 3 Zeichen
- maximal 16 Zeichen
- nur A-Z, a-z, 0-9 und _
- keine Leerzeichen
- keine Sonderzeichen
- keine Erklärungen

Antworte ausschließlich mit diesem JSON-Format:

{
    "namen": [
        "Name1",
        "Name2",
        "Name3"
    ]
}
"""
                },
                {
                    "role": "user",
                    "content": f"""
Generiere 3 neue Minecraft Spielernamen.

Diese Namen sind bereits in meiner Datenbank und dürfen NICHT
verwendet werden:

{", ".join(vergebene_namen)}
"""
                }
            ],
            format="json"
        )

        try:
            daten = json.loads(response["message"]["content"])
        except json.JSONDecodeError:
            print("Die KI hat kein gültiges JSON zurückgegeben. Neuer Versuch...")
            continue

        kandidaten = daten.get("namen", [])

        if not isinstance(kandidaten, list):
            continue

        ergebnis = []

        for name in kandidaten:
            if not isinstance(name, str):
                continue

            name = name.strip()

            # Minecraft-Regeln prüfen
            if not ist_gueltiger_minecraft_name(name):
                continue

            # Bereits verwendete Namen prüfen
            if name.lower() in vergebene_namen:
                continue

            # Doppelte Namen verhindern
            if name.lower() in {x.lower() for x in ergebnis}:
                continue

            ergebnis.append(name)

        # Nur akzeptieren, wenn wirklich genau 3 gültige Namen vorhanden sind
        if len(ergebnis) == 3:
            return ergebnis


namen = generiere_namen()

print("Generierte Minecraft-Namen:")

for name in namen:
    print("-", name)