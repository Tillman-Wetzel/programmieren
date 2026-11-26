package main

import (
	"errors"
	"fmt"
	"os"
)

func main() {
	// 1. Datei schreiben (wird angelegt oder überschrieben)
	//    0644 = Dateirechte: ich darf lesen+schreiben, andere nur lesen
	err := os.WriteFile("hello.txt", []byte("Hello from Go!\n"), 0644)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	// 2. Datei lesen
	data, err := os.ReadFile("hello.txt")
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Print(string(data)) // []byte -> string

	// 3. Datei, die es nicht gibt
	_, err = os.ReadFile("does_not_exist.txt")
	if errors.Is(err, os.ErrNotExist) {
		fmt.Println("File does not exist - that's ok, we start fresh")
	}

}
