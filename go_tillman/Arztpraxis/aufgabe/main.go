package main

import (
	"fmt"
	"hello/Arztpraxis/aufgabe/praxis"
)

func main() {
	myPraxis := praxis.NewPraxis("Praxis Wetzelhausen")

	myPraxis.AddPatient(praxis.NewPatient("A12345", "Mustermann", "Max"))
	myPraxis.AddPatient(praxis.NewPatient("B67890", "Mustermann", "Erika"))
	myPraxis.AddPatient(praxis.NewPatient("C11111", "Müller", "Max"))

	myPraxis.AddBehandlung(praxis.NewPhysioBehandlung("A12345", "Chiropraktik", 12.87))
	myPraxis.AddBehandlung(praxis.NewPhysioBehandlung("A12345", "Wärmeanwendung", 4.23))
	myPraxis.AddBehandlung(praxis.NewStandertBehandlung("A12345", "Arthrose", 45.12))
	myPraxis.AddBehandlung(praxis.NewStandertBehandlung("A12345", "Ultraschall", 26.80))

	fmt.Println(myPraxis.GetPatient("Mustermann"))
	fmt.Println(myPraxis.GetBehandlung("A12345"))
	fmt.Println(myPraxis.ErmittleKosten())
}
