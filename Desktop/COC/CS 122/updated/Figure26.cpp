/*
Kevin Ponek
Figure26.cpp
March 17, 2016
CS 122 Lab Project 1
Description: This is the updated Figure 2.6 from the book that converts from base10 decimal to
	another base.
*/

#include <iostream>
using namespace std;

int main1 () {
 const int bonus = 5;
 int exam1;
 int exam2;
 int rem;
 cout << "Please enter two numbers (decimal and a base 0 to 9):" << endl;
 cin >> exam1 >> exam2;
 while (exam1 > 0){
	 rem = exam1 % exam2;
	 cout << rem << endl;
	 exam1 = exam1 / exam2;
 }

 system("pause");
 return 0;
}