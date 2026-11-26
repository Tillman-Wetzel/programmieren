package main

import "fmt"

type Person struct {
	Name string
	age  int
}

type Person2 struct{}

// Methode für Person (mit Pointer Receiver)
func (p *Person) Greet() {
	fmt.Printf("Hallo, ich bin %s und bin %d Jahre alt", p.Name, p.age)
}

// Methode mit Rückgabewert
func (p *Person) IsAdult() bool {
	return p.age >= 18
}

// Mit Pointer:
func (p *Person) SetAge(age int) {
	p.age = age // Ändert das ORIGINAL!
}

//Ohne Pointer (Value Receiver):
// func (p Person) SetAge(age int) {
// 	p.Age = age  // Ändert nur die KOPIE, nicht das Original!
// }

func (p *Person) GetAge() int {
	return p.age
}

func main() {
	// Person erstellen
	person := &Person{
		Name: "Sascha",
		age:  30,
	}

	// Varianten der Erstellung
	// person2 := Person2{}
	// person3 := new(Person2)
	// var person4 Person2 = Person2

	// Methoden aufrufen
	person.Greet()

	if person.IsAdult() {
		fmt.Println("Diese Person ist volljährig")
	}

	person.SetAge(40)
	fmt.Println(person.age) // Ausgabe: 40 (geändert!)
}
