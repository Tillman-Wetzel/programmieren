package aufgabe

import "errors"

type Schueler struct {
	name      string
	age       int
	character string
}

func (s Schueler) GetName() string {
	return s.name
}
func (s Schueler) GetAge() int {
	return s.age
}
func (s Schueler) GetCharacter() string {
	return s.character
}

func newSchueler(name string, age int, character string) (*Schueler, error) {
	if name == "" {
		return nil, errors.New("name must not be empty")
	}
	if age < 0 {
		return nil, errors.New("age must not be negative")
	}
	if age < 6 {
		return nil, errors.New("age is too small")
	}
	if age > 19 {
		return nil, errors.New("age is too high")
	}

	return &Schueler{name: name, age: age, character: character}, nil
}

func NewClassClown(name string, age int) (*Schueler, error) {
	return newSchueler(name, age, "Class Clown")
}
func NewNerd(name string, age int) (*Schueler, error) {
	return newSchueler(name, age, "Nerd")
}
func NewAthlete(name string, age int) (*Schueler, error) {
	return newSchueler(name, age, "Athlete")
}
