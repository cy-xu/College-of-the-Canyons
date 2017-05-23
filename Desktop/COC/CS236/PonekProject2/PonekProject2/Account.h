/*
Kevin Ponek
May 5, 2015
CS236 Project 2
Description: Source code that contains the outline for the Account object
*/

#pragma once
#include <iostream>
using namespace std;

class Account {
	private:
		string name;
		long taxID;
		double balance;

	protected:
		double last10withdraws[10];
		double last10deposits[10];
		int numdeposits;
		int numwithdraws;

	public:
		Account();
		Account(string n, long t, double b);
		void setName(string s);
		void setTaxID(long l);
		void setBalance(double d);
		string getName();
		long getTaxID();
		double getBalance();
		void MakeDeposit(double amount);
		virtual void display();
};