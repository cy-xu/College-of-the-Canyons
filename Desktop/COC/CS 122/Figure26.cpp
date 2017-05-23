/*
Kevin Ponek
Figure26.cpp
March 17, 2016
CS 122 Lab Project 1
Description: 
*/

#include <iostream>
using namespace std;

int main () {
 const int bonus = 5;
 int exam1;
 int exam2;
 int div;
 int rem;
 cout << "Please enter two integer exam scores:" << endl;
 cin >> exam1 >> exam2;
 div = (exam1 / exam2);
 rem = exam1 % exam2;
 cout << "Divide = " << div << "   Remainder = " << rem << endl;
 system("pause");
 return 0;
}