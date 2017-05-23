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