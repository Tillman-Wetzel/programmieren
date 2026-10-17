package main

import (
	"fmt"
	"time"
)

func worker(id int) {
	fmt.Println("Worker ", id, " starting")
	time.Sleep(2 * time.Second)
	fmt.Println("Worker ", id, " stopping")
}

func main() {
	go worker(1)
	go worker(2)
	go worker(3)
	fmt.Println("All workers started")
	time.Sleep(3 * time.Second)
	fmt.Println("All workers done")
}
