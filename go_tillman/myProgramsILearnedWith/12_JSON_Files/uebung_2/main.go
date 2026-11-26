package main

import (
	"encoding/json"
	"fmt"
)

// Struct-Tags `json:"..."` sagen, wie das Feld im JSON heißt
type Patient struct {
	KVNummer  string   `json:"kv_nummer"`
	Name      string   `json:"name"`
	Age       int      `json:"age"`
	Allergies []string `json:"allergies"`
	secret    string   // klein geschrieben -> wird NICHT ins JSON geschrieben!
}

func main() {
	p := Patient{KVNummer: "A12345", Name: "Max", Age: 34,
		Allergies: []string{"pollen", "nuts"}, secret: "top secret"}

	// Struct -> JSON (Marshal)
	data, err := json.Marshal(p)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Println(string(data))

	// Schön formatiert
	pretty, _ := json.MarshalIndent(p, "", "  ")
	fmt.Println(string(pretty))

	// JSON -> Struct (Unmarshal)
	input := `{"kv_nummer":"B67890","name":"Erika","age":29,"allergies":[]}`
	var p2 Patient
	err = json.Unmarshal([]byte(input), &p2) // & = Pointer, damit p2 befüllt wird
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Println(p2.Name, p2.Age) // Erika 29
}
