package main

import (
	"fmt"
)

// Nutze Pointer

func checkBalance(balance int) {
	fmt.Println("Your Balance is: ", balance)
}

func deposit(balancePointer *int, depositAmount int) {
	*balancePointer = *balancePointer + depositAmount
	fmt.Println("Sie haben ", depositAmount, "€ Eingezahlt")
}

func withdraw(balancePointer *int, withdrawAmount int) {
	if withdrawAmount <= *balancePointer {
		*balancePointer = *balancePointer - withdrawAmount
		fmt.Println("Sie haben ", withdrawAmount, "€ von Ihrem Account abgehoben.")
	} else {
		fmt.Println("Sie haben nicht genug Geld um ", withdrawAmount, "€ abzuheben.")
	}
}

func main() {
	myBalance := 100

	checkBalance(myBalance)

	deposit(&myBalance, 50)

	checkBalance(myBalance)

	withdraw(&myBalance, 30)

	checkBalance(myBalance)

	withdraw(&myBalance, 200)

	checkBalance(myBalance)
}
