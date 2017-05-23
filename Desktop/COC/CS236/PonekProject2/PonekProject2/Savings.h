/*
Kevin Ponek
May 5, 2015
CS236 Project 2
Description: Source code that contains the outline for the Savings object that inherits from the Account parent object
*/

#include <iostream>
#include "Account.h"
using namespace std;

class Savings: public Account {
	public:
		Savings();
		Savings(string n, long t, double b);
		void DoWithdraw(double amount);
		void display();
};