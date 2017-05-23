/*
Kevin Ponek
May 5, 2015
CS236 Project 2
Description: Source code that contains the definitions of the CreditCard object that inherits from the Account parent object
*/

#include <iostream>
#include <string>
#include "Account.h"
#include "CreditCard.h"
using namespace std;

CreditCard::CreditCard() {
	setName("No name");
	setTaxID(-1);
	setBalance(-1);
}
CreditCard::CreditCard(string n, long t, double b) {
	setName(n);
	setTaxID(t);
	setBalance(b);
}
void CreditCard::DoCharge(string name, double amount) {
	setBalance(getBalance() - amount);
	last10withdraws[numwithdraws % 10] = amount;
	last10charges[numwithdraws % 10] = name;
	numwithdraws++;
}
void CreditCard::MakePayment(double amount) {
	setBalance(getBalance() + amount);
	last10deposits[numdeposits % 10] = amount;
	numdeposits++;
}
void CreditCard::display() {
	Account::display();
	cout << "Name: " << getName() << ", Amount: " << getBalance() << ", Deposit Record: ";
	for (int i = 0; i < numdeposits % 10; i++) {
		cout << "[$" << last10deposits[i] << "] ";
	}
	cout << endl;
}
