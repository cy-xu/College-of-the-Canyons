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