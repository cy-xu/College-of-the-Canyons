#include <iostream>
#include "Account.h"
#include "Savings.h"
using namespace std;

Savings::Savings() {
	name = "No name";
	taxID = -1;
	balance = -1;
}
Savings::Savings(string n, long t, double b) {
	name = n;
	taxID = t;
	balance = b;
}
void Savings::DoWithdraw(double amount) {
	balance = balance - amount;
	last10withdraws[numwithdraws % 10] = amount;
	numwithdraws++;
}
void Savings::display() {
	cout << "Withdraw Record: " << last10withdraws << ", Deposit Record: " << last10deposits << endl;
}
