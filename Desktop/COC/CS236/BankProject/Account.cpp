#include <iostream>
#include "Account.h"
using namespace std;

//public methods
Account::Account() {
	name = "No name";
	taxID = -1;
	balance = -1;
}
Account::Account(string n, long t, double b) {
	name = n;
	taxID = t;
	balance = b;
}
void Account::SetName(string s) {
	name = s;
}
void Account::SetTaxID(long l) {
	if (l >= 100000000 && l < 1000000000)
		taxID = l;
}
void Account::Setbalance(double d) {
	balance = d;
}
string Account::GetName() {
	return name;
}
long Account::GetTaxID() {
	return taxID;
}
double Account::Getbalance() {
	return balance;
}
void Account::MakeDeposit(double amount) {
	balance = balance + amount;
	last10deposits[numdeposits%10] = amount;
	numdeposits++;
}
void Account::display() {
	cout << "Name: " << name << ", Tax ID: " << taxID << ", Balance: " << balance << endl;
}