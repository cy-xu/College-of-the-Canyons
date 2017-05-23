/*
 *
 *
 *
 * Programmer: Kevin Ponek
 */

#include "stdafx.h"
#include <iostream>
using namespace std;


int main()
{
	double e, r1, r2;
	double i,v,p;

	cout << "Volts: " << endl;
	cin >> e;
	cout << "Ohms in first resistor: " << endl;
	cin >> r1;
	cout << "Ohms in second resistor: " << endl;
	cin >> r2;
	
	i = e / (r1 + r2);
	v = i * r2;
	p = i * v;

	cout << "Voltage Drop = " << v << "volts" << endl;
	cout << "Power Delivered = " << p << "watts" << endl;

	cin.ignore();
	return 0;
}

