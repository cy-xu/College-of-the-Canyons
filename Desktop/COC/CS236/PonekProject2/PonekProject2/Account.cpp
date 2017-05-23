/*
Kevin Ponek
May 5, 2015
CS236 Project 2
Description: Source code that contains the definitions of the Account object
*/

#include <iostream>
#include <string>
#include "Account.h"
using namespace std;

//public methods
Account::Account() {
	name = "No name";
	taxID = -1;
	balance = -1;
	numdeposits = 0;
	numwithdraws = 0;
}
Account::Account(string n, long t, double b) {
	name = n;
	taxID = t;
	balance = b;
	numdeposits = 0;
	numwithdraws = 0;
}
void Account::setName(string s) {
	name = s;
}
void Account::setTaxID(long l) {
	if (l >= 100000000 && l < 1000000000)
		taxID = l;
}
void Account::setBalance(double d) {
	balance = d;
}
string Account::getName() {
	return name;
}
long Account::getTaxID() {
	return taxID;
}
double Account::getBalance() {
	return balance;
}
void Account::MakeDeposit(double amount) {
	balance = balance + amount;
	last10deposits[numdeposits%10] = amount;
	numdeposits++;
}
void Account::display() {
	cout << "Name: " << name << ", Tax ID: " <<taxID << ", Balance: $" << balance << endl;
}