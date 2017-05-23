#include <iostream>
#include "Account.h"
#include "Checking.h"
using namespace std;


Checking::Checking() {
	name = "No name";
	taxID = -1;
	balance = -1;
}
Checking::Checking(string n, long t, double b) {
	name = n;
	taxID = t;
	balance = b;
}
void Checking::WriteCheck(int checknum, double amount) {
	balance = balance - amount;
	last10withdraws[numwithdraws % 10] = amount;
	last10checks[numwithdraws % 10] = checknum;
	numwithdraws++;
}
void Checking::display() {
	cout << "Check Number: " << checknum << ", Check Amount: " << amount << "Deposit Record: " << last10deposits << endl;
}