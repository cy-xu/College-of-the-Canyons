/*
Kevin Ponek
Figure210.cpp
March 17, 2016
CS 122 Lab Project 1
Description: 
*/

#include <math.h>
#include <iostream>
using namespace std;

int main () {
	 const int base2 = 2;
	 const int base3 = 3;
	 const int base8 = 8;
	 const int base10 = 10;
	 const int base16 = 16;
	// const int limit = 100;
	 int num;
	 cout << "Enter a number base:" << endl;
	 cin >> num;
	 if (num == base2)
		 cout << pow(base2,0) << pow(base2,1) << pow(base2,2) << pow(base2,3) << endl;
	 else if (num == base3)
		 cout << pow(base3,0) << pow(base3,1) << pow(base3,2) << pow(base3,3) << endl;
	 else if (num == base8)
		 cout << pow(base8,0) << pow(base8,1) << pow(base8,2) << pow(base8,3) << endl;
	 else if (num == base10)
		 cout << pow(base10,0) << pow(base10,1) << pow(base10,2) << pow(base10,3) << endl;
	 else if (num == base16)
		 cout << pow(base16,0) << pow(base16,1) << pow(base16,2) << pow(base16,3) << endl;
	 else 
		 cout << "Input is NOT 2,3,8,10, or 16" << endl;
	 system("pause");

	 return 0; 
}