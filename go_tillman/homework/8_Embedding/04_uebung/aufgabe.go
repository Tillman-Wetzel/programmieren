package main

import "fmt"

type Employee struct {
	Name       string
	BaseSalary float64
}

func (e Employee) GetName() string {
	return e.Name
}

type Manager struct {
	Employee
	Bonus float64
}

type Developer struct {
	Employee
	OvertimeHours int
}

func (e Manager) Salary() float64 {
	return e.BaseSalary + e.Bonus
}

func (e Developer) Salary() float64 {
	return e.BaseSalary + float64(e.OvertimeHours*50)
}

type Playable interface {
	GetName() string
	Salary() float64
}

func TotalSalary(staff []Playable) float64 {
	var totalSalary float64 = 0
	for i := 0; i < len(staff); i++ {
		totalSalary = totalSalary + staff[i].Salary()
	}

	return totalSalary
}

func main() {
	Anna := Manager{
		Employee: Employee{BaseSalary: 5000, Name: "Anna"},
		Bonus:    1000,
	}
	Ben := Developer{
		Employee:      Employee{BaseSalary: 4000, Name: "Ben"},
		OvertimeHours: 10,
	}
	Clara := Developer{
		Employee:      Employee{BaseSalary: 4200, Name: "Clara"},
		OvertimeHours: 0,
	}

	// staff := []Payable{
	// 	Manager{Employee{"Anna", 5000}, 1000},
	// 	Developer{Employee{"Ben", 4000}, 10},
	// 	Developer{Employee{"Clara", 4200}, 0},
	// }

	staff := []Playable{Anna, Ben, Clara}
	fmt.Println(TotalSalary(staff))

	for _, val := range staff {
		fmt.Printf("%v\t%v\n", val.Salary(), val.GetName())
	}
}
