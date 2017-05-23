/*
Kevin Ponek
Figure212.cpp
March 17, 2016
CS 122 Lab Project 1
Description: This is the updated Figure 2.12 from the book that uses a switch statement to output the hex
	form of the decimal number from 0 - 15.
*/

#include <iostream>
using namespace std;
int main3 () {
	int guess;
	cout << "Enter a number 0 ... 15: ";
	cin >> guess;
	switch (guess) {
		case 0: cout << "0 decimal is 0 in Hex"; break;
		case 1: cout << "1 decimal is 1 in Hex"; break;
		case 2: cout << "2 decimal is 2 in Hex"; break;
		case 3: cout << "3 decimal is 3 in Hex"; break;
		case 4: cout << "4 decimal is 4 in Hex"; break;
		case 5: cout << "5 decimal is 5 in Hex"; break;
		case 6: cout << "6 decimal is 6 in Hex"; break;
		case 7: cout << "7 decimal is 7 in Hex"; break;
		case 8: cout << "8 decimal is 8 in Hex"; break;
		case 9: cout << "9 decimal is 9 in Hex"; break;
		case 10: cout << "10 decimal is A in Hex"; break;
		case 11: cout << "11 decimal is B in Hex"; break;
		case 12: cout << "12 decimal is C in Hex"; break;
		case 13: cout << "13 decimal is D in Hex"; break;
		case 14: cout << "14 decimal is E in Hex"; break;
		case 15: cout << "15 decimal is F in Hex"; break;
	 }
	cout << endl;
	system("pause");
	return 0;
}