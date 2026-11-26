package main

import "fmt"

type WithdrawalError struct {
	balance int
	amount  int
	Reason  string
}

func (e WithdrawalError) Error() string {
	return fmt.Sprintf("Cannot withdraw €%d. Balance is €%d. Reason: %s", e.amount, e.balance, e.Reason)
}

func withdraw(balance int, amount int) error {
	if amount <= 0 {
		return WithdrawalError{
			balance: balance,
			amount:  amount,
			Reason:  "amount must be positive"}
	}
	if amount > balance {
		return WithdrawalError{
			balance: balance,
			amount:  amount,
			Reason:  "insufficient funds"}
	}
	if amount > 1000 {
		return WithdrawalError{
			balance: balance,
			amount:  amount,
			Reason:  "daily limit exceeded"}
	}

	return nil
}

func main() {
	err := withdraw(100, 50)
	if err != nil {
		fmt.Println("Fehler:", err)
	} else {
		fmt.Println("Erfolgreich!")
	}

	err = withdraw(100, -20)
	if err != nil {
		fmt.Println("Fehler:", err)
	} else {
		fmt.Println("Erfolgreich!")
	}

	err = withdraw(100, 150)
	if err != nil {
		fmt.Println("Fehler:", err)
	} else {
		fmt.Println("Erfolgreich!")
	}
	err = withdraw(2000, 1500)
	if err != nil {
		fmt.Println("Fehler:", err)
	} else {
		fmt.Println("Erfolgreich!")
	}
}
