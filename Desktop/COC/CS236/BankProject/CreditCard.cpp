#include <iostream>
#include "Account.h"
#include "CreditCard.h"
using namespace std;

CreditCard::CreditCard() {
	name = "No name";
	taxID = -1;
	balance = -1;
}
CreditCard::CreditCard(string n, long t, double b) {
	name = n;
	taxID = t;
	balance = b;
}
void CreditCard::DoCharge(string name, double amount) {
	balance = balance - amount;
	last10withdraws[numwithdraws % 10] = amount;
	last10charges[numwithdraws % 10] = name;
	numwithdraws++;
}
void CreditCard::MakePayment(double amount) {
	balance = balance - amount;
	last10deposits[numdeposits % 10] = amount;
	numdeposits++;
}
void CreditCard::display() {
	cout << "Name: " << name << ", Amount: " << amount << ", Deposit Record: " << last10deposits << endl;
}
