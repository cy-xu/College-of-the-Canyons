/*
* CircuitData.cpp
* College of the Canyons
* Date: July 3, 2014
* Programmer: Kevin Ponek
* Description: Write, compile, and run a C program that prompts users for values of 
* E, R1, and R2; calculates the voltage drop and power delivered to R2; and displays 
* the results.
*/

#include "stdafx.h"
#include <iostream>
using namespace std;


int main()
{
	double e, r1, r2;
	double i, v, p;

	cout << "Please type in number of volts: ";
	cin >> e;
	cout << "Please type in number of ohms in first resistor: ";
	cin >> r1;
	cout << "Please type in number of ohms in second resistor: ";
	cin >> r2;
	i = e / (r1 + r2);
	v = i * r2;
	p = i * v;
	cout << "The voltage drop is " << v << " volts." << endl;
	cout << "The power delivered is " << p << " watts." << endl;

	cin.ignore(2);
	return 0;
}