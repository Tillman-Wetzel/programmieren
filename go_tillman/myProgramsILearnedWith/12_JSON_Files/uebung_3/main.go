package main

import (
	"encoding/json"
	"errors"
	"fmt"
	"os"
)

type Todo struct {
	Title string `json:"title"`
	Done  bool   `json:"done"`
}

const fileName = "todos.json"

// load liest die Todos aus der Datei. Gibt es die Datei noch nicht -> leere Liste.
func load() ([]Todo, error) {
	data, err := os.ReadFile(fileName)
	if errors.Is(err, os.ErrNotExist) {
		return []Todo{}, nil
	}
	if err != nil {
		return nil, err
	}
	var todos []Todo
	err = json.Unmarshal(data, &todos)
	return todos, err
}

// save schreibt alle Todos als JSON in die Datei
func save(todos []Todo) error {
	data, err := json.MarshalIndent(todos, "", "  ")
	if err != nil {
		return err
	}
	return os.WriteFile(fileName, data, 0644)
}

func main() {
	todos, err := load()
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	// Bei jedem Start kommt ein Todo dazu -> starte das Programm mehrmals!
	todos = append(todos, Todo{Title: fmt.Sprintf("Todo number %d", len(todos)+1)})

	if err := save(todos); err != nil {
		fmt.Println("Error:", err)
		return
	}

	fmt.Printf("%d todos saved in %s:\n", len(todos), fileName)
	for _, t := range todos {
		fmt.Println(" -", t.Title)
	}
}
