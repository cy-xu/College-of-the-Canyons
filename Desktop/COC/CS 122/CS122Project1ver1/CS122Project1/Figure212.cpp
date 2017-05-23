/*
Kevin Ponek
Figure212.cpp
March 17, 2016
CS 122 Lab Project 1
Description: 
*/

#include <iostream>
using namespace std;
int main7 () {
	int guess;
	cout << "Pick a number 10 ... 15: ";
	cin >> guess;
	switch (guess) {
		case 10: cout << "A"; break;
		case 11: cout << "B"; break;
		case 12: cout << "C"; break;
		case 13: cout << "D"; break;
		case 14: cout << "E"; break;
		case 15: cout << "F"; break;
	 }
	cout << endl;
	system("pause");
	return 0;
}