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
		void SetName(string s);
		void SetTaxID(long l);
		void Setbalance(double d);
		string GetName();
		long GetTaxID();
		double Getbalance();
		void MakeDeposit(double amount);
		void display();
};