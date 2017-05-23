/*
Kevin Ponek
May 5, 2015
CS236 Project 1
Description: Source code that contains the outline of the Checking object that inherits from the Account parent object
*/

#include <iostream>
#include "Account.h"
using namespace std;

class Checking: public Account {
	private:
		int last10checks[10];
	public:
		Checking();
		Checking(string n, long t, double b);
		void WriteCheck(int checknum, double amount);
		void display();
};