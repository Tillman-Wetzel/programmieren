from sklearn.tree import DecisionTreeClassifier

model = DecisionTreeClassifier()


def trainAi():
    data1 = [int(input("Wie viele Stunden schlaf hattest du? ")), int(input("Wie viele Kaffes hattest du heute? "))]
    data2 = int(input("Bist du müde(0 = Nein, 1 = Ja)? "))

    
    model.fit([data1], [data2])

def askAi():
    data1 = [int(input("Wie viele Stunden schlaf hattest du? ")), int(input("Wie viele Kaffes hattest du heute? "))]

    print(model.predict([data1]))

while True:
    match int(input("""Was möchtest du machen?
    Optionen:
    1. KI trainieren
    2. KI fragen
    3. Programm beenden
    """)):

        case 1:
            trainAi()
        case 2:
            askAi()
        case 3:
            break