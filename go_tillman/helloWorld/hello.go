package main

import (
	"fmt"
)

func main() {
	treasures := []int{15, 42, 7, 88, 23, 42, 91, 5, 67, 42}

	var smallTreasures int = 0
	var mediumTreasures int = 0
	var largeTreasures int = 0
	var magic42s int = 0

	var biggestTreasureValue int = 0
	var biggestTreasureIndex int = 0

	for idx, treasure := range treasures {
		if treasure <= 30 {
			smallTreasures++
		} else if treasure <= 70 {
			mediumTreasures++
		} else if treasure > 70 {
			largeTreasures++
		}

		if treasure == 42 {
			magic42s++
		}

		if treasure > biggestTreasureValue {
			biggestTreasureValue = treasure
			biggestTreasureIndex = idx
		}

	}

	smallTreasuresDoubled := []int{}

	for _, treasure := range treasures {
		if treasure <= 30 {
			smallTreasuresDoubled = append(smallTreasuresDoubled, treasure*2)
		} else {
			smallTreasuresDoubled = append(smallTreasuresDoubled, treasure*2)
		}

	}

	fmt.Println("Your treasures: ", treasures)

	fmt.Println("Statistics:")
	fmt.Println("Small treasures:", smallTreasures)
	fmt.Println("Medium treasures:", mediumTreasures)
	fmt.Println("Large treasures:", largeTreasures)
	fmt.Println("Magic 42s:", magic42s)

	fmt.Println("Most valuable treasure: ", biggestTreasureValue, " at position: ", biggestTreasureIndex)

	fmt.Println("After doubling of small treasures: ")

}
