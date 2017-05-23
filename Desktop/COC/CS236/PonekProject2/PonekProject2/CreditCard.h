/*
Kevin Ponek
May 5, 2015
CS236 Project 2
Description: Source code that contains the outline for the CreditCard object that inherits from the Account parent object
*/

#include <iostream>
#include "Account.h"
using namespace std;

class CreditCard: public Account {
	private:
		long cardnumber;
		string last10charges[10];
	public:
		CreditCard();
		CreditCard(string n, long t, double b);
		void DoCharge(string name, double amount);
		void MakePayment(double amount);
		void display();
};