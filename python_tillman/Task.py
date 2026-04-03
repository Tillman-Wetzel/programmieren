# class MeineKlasse:
#     x = 5


# myClassObjekt = MeineKlasse()

# print(myClassObjekt.x)



# class Person:
#     personen = []

    

#     def __init__(self, name, age = 10):
#         self.name = name
#         self.age = age
#         gamemaster.personen.add(self)
# gamemaster = Person("MAIN")

# ich = Person("Tillman", 13)

# bruder = Person("Laurenz")

# print(ich.age)

# for i in gamemaster.personen:
#     print(i.name)
#     pass


#Objektmethoden

class Auto:
    ps = 1200 # <-- Klassenvariable

    def __init__(self, marke, alter):
        self.marke = marke
        self.alter = alter # <-- Objektvariable

    def begruese(self):
        print("Hallo, ich fahre einen " + self.marke + ".")

    def printeAlterUndBegruessung(self):
        self.begruese()
        print("Ich bin " + self.alter + "Jahre alt.")

    def __str__(self):
        return f"{self.marke} ({self.alter})"
    
meins = Auto("BMW", 1)
meins.autofarbe = "BLAU"

print(Auto.ps)
print(meins)