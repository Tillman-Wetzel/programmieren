package main

import (
	"fmt"
	aufgabe "hello/homework/9_FactoryPatterns/4Uebung"
)

func main() {

	// Tom := Schueler{
	// 	name: "Tom"
	// 	age: 12
	// 	character: "Vibe-Coder"
	// }

	Tim, _ := aufgabe.NewNerd("Tim", 14)
	Till, _ := aufgabe.NewAthlete("Till", 13)
	Carl, _ := aufgabe.NewClassClown("Carl", 12)

	fmt.Printf(Tim.GetName(), Till.GetName(), Carl.GetName())
}
