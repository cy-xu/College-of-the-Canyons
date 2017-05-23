/*
Kevin Ponek
Figure213Week3.cpp
March 17, 2016
CS 122 Lab Project 1
Description:
*/

#include <iostream>
using namespace std;
char letter;

int main4() {
	int power2 = 8;
	int result = 0;
	cout << "Enter four 1's and 0's followed by a '*':" << endl;
	cin >> letter;
	while (letter != '*') {
		if (letter == '1'){
			result = result + power2;
			power2 = power2 / 2;
		}
		cin >> letter;
	}
	cout << "That is " << result << " in decimal" << endl;
	system("pause");

	return 0;
}