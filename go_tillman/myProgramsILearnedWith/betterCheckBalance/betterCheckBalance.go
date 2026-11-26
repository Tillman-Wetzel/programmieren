package main

import "fmt"

type BankAccount interface {
	GetBalance() float64
	Deposit(amount float64)
	Withdraw(amount float64) bool
	GetAccountType() string
}

type CheckingAccount struct {
	balance float64
}

type SavingsAccount struct {
	balance float64
}

func (a *CheckingAccount) GetBalance() float64 {
	return a.balance
}

func (a *CheckingAccount) Deposit(amount float64) {
	a.balance = a.balance + amount
}

func (a *CheckingAccount) Withdraw(amount float64) bool {
	var result float64 = a.balance - amount
	if result >= -500 {
		a.balance = result
		return true
	}
	return false
}

func (a *CheckingAccount) GetAccountType() string {
	return "Checking Account"
}

func (a *SavingsAccount) GetBalance() float64 {
	return a.balance
}

func (a *SavingsAccount) Deposit(amount float64) {
	a.balance = a.balance + amount
}

func (a *SavingsAccount) Withdraw(amount float64) bool {
	var result float64 = a.balance - amount
	if result >= 0 {
		a.balance = result
		return true
	}
	return false
}

func (a *SavingsAccount) GetAccountType() string {
	return "Savings Account"
}

func PrintAccountInfo(account BankAccount) {
	fmt.Printf("You have %.2f € in Your Account.\n", account.GetBalance())
	fmt.Println("Your Account Type is: " + account.GetAccountType() + ".")
}

func main() {
	checking := &CheckingAccount{balance: 1000}
	savings := &SavingsAccount{balance: 500}

	PrintAccountInfo(checking)
	PrintAccountInfo(savings)

	checking.Withdraw(200)

	PrintAccountInfo(checking)

	checking.Withdraw(1400)

	PrintAccountInfo(checking)
}
