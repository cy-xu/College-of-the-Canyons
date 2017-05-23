/*
Kevin Ponek
May 5, 2015
CS236 Project 1
Description: Source code that contains the definitions of the Savings object that inherits from the Account parent object
*/

#include <iostream>
#include <string>
#include "Account.h"
#include "Savings.h"
using namespace std;

Savings::Savings() {
	setName("No name");
	setTaxID(-1);
	setBalance(-1);
}
Savings::Savings(string n, long t, double b) {
	setName(n);
	setTaxID(t);
	setBalance(b);
}
void Savings::DoWithdraw(double amount) {
	setBalance(getBalance() - amount);
	last10withdraws[numwithdraws % 10] = amount;
	numwithdraws++;
}
void Savings::display() {
	//cout << "Balance: $" << getBalance() << endl;
	Account::display();
	cout << "Withdraw Record: ";
	for (int i = 0; i < numwithdraws % 10; i++){
		cout << "[$" << last10withdraws[i] << "] ";
	}
	cout << ", Deposit Record: ";
	for (int i = 0; i < numdeposits % 10; i++) {
		cout << "[$" << last10deposits[i] << "] ";
	}
	cout << endl;

}
