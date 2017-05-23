/*
Kevin Ponek
May 5, 2015
CS236 Project 1
Description: Source code that contains the definitions of the Checking object that inherits from the Account parent object
*/

#include <iostream>
#include <string>
#include "Account.h"
#include "Checking.h"
using namespace std;


Checking::Checking() {
	setName("No name");
	setTaxID(-1);
	setBalance(-1);
}
Checking::Checking(string n, long t, double b) {
	setName(n);
	setTaxID(t);
	setBalance(b);
}
void Checking::WriteCheck(int checknum, double amount) {
	setBalance(getBalance() - amount);
	last10withdraws[numwithdraws % 10] = amount;
	last10checks[numwithdraws % 10] = checknum;
	numwithdraws++;
}

void Checking::display() {
	Account::display();
	cout << "Check Numbers: ";
	for (int i = 0; i < numwithdraws % 10; i++){
		cout << "[" << last10checks[i] << "] ";
	}
	cout << ", Deposit Record: ";
	for (int i = 0; i < numdeposits % 10; i++) {
		cout << "[$" << last10deposits[i] << "] ";
	}
	cout << endl;
}