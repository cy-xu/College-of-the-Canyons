/*
Kevin Ponek
Figure210.cpp
March 17, 2016
CS 122 Lab Project 1
Description: 
*/

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
		 cout << "Binary 0..1" << endl;
	 else if (num == base3)
		 cout << "Trinary 0..2" << endl;
	 else if (num == base8)
		 cout << "Octal 0..7" << endl;
	 else if (num == base10)
		 cout << "Decimal 0..9" << endl;
	 else if (num == base16)
		 cout << "Hexidecimal 0..F" << endl;
	 else 
		 cout << "Input is NOT 2,3,8,10, or 16" << endl;
	 system("pause");

	 return 0; 
}