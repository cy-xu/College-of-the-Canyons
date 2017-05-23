/*
Kevin Ponek
Figure213.cpp
March 17, 2016
CS 122 Lab Project 1
Description: 
*/

#include <iostream>
using namespace std;
char letter;
int main () {
	cout << "Enter four 1's and 0's followed by a '*':" << endl;
	cin >> letter;
	while (letter != '*') {
		cout << letter << " * power2 = " << endl;
		cin >> letter;
	}
	system("pause");

	return 0; 
}