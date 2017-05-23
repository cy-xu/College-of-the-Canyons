/*
Kevin Ponek
May 5, 2015
CS236 Project 1
Description: The main file that creates Checking, Savings, and CreditCard objects.  It provides options for the 
	user to decide what to do with these three objects.
*/

#include <iostream>
#include <string>
#include "Account.h"
#include "Checking.h"
#include "CreditCard.h"
#include "Savings.h"
using namespace std;

int main() {
	long taxID;//constructor tax ID input
	string name;//constructor name input
	bool whileLoop = true;//boolean for while loop to keep track of input 0
	int userInput;//user choice input
	double doubleAmount;//user input variable for double amounts
	int checkNum;//for user input 4
	string chargeName;//for user input 6

	cout << "What is your name?" << endl;
	cin >> name;
	cout << "What is your tax ID?" << endl;
	cin >> taxID;
	Checking checking(name, taxID, 100);
	Savings savings(name, taxID, 100);
	CreditCard creditCard(name, taxID, 100);

	while (whileLoop) {
		cout << "1. Savings Deposit" << endl
			<< "2. Savings Withdrawal" << endl
			<< "3. Checking Deposit" << endl
			<< "4. Write A Check" << endl
			<< "5. Credit Card Payment" << endl
			<< "6. Make A Charge" << endl
			<< "7. Display Savings" << endl
			<< "8. Display Checking" << endl
			<< "9. Display Credit Card" << endl
			<< "0. Exit" << endl;
		cin >> userInput;
		if (userInput == 1) {
			cout << "How much will you deposit into Savings?" << endl;
			cin >> doubleAmount;
			savings.MakeDeposit(doubleAmount);
		}
		else if (userInput == 2) {
			cout << "How much will you withdraw from Savings?" << endl;
			cin >> doubleAmount;
			savings.DoWithdraw(doubleAmount);
		}
		else if (userInput == 3) {
			cout << "How much will you deposit into Checking?" << endl;
			cin >> doubleAmount;
			checking.MakeDeposit(doubleAmount);
		}
		else if (userInput == 4) {
			cout << "What is the check number?" << endl;
			cin >> checkNum;
			cout << "How much will you write the check out for?" << endl;
			cin >> doubleAmount;
			checking.WriteCheck(checkNum, doubleAmount);
		}
		else if (userInput == 5) {
			cout << "How much is your credit card payment for?" << endl;
			cin >> doubleAmount;
			creditCard.MakePayment(doubleAmount);
		}
		else if (userInput == 6) {
			cout << "What is the name of the charge?" << endl;
			cin >> chargeName;
			cout << "How much is the charge for?" << endl;
			cin >> doubleAmount;
			creditCard.DoCharge(chargeName, doubleAmount);
		}
		else if (userInput == 7) {
			savings.display();
		}
		else if (userInput == 8) {
			checking.display();
		}
		else if (userInput == 9) {
			creditCard.display();
		}
		else if (userInput == 0) {
			whileLoop = false;
		}
	}

	return 0;
}