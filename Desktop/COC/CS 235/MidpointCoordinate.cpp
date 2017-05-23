/*
* MidpointCoordinate.cpp
* College of the Canyons
* Date: July 3, 2014
* Programmer: Kevin Ponek
* Description: Write a C program to calculate and display the midpoint coordinates 
* of the line segment connecting the two endpoints inputted.
*/
#include "stdafx.h"
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	double x1, y1, x2, y2, xMid, yMid;
	
	cout << "First Coordinate" << endl;
	cout << "x = ";
	cin >> x1;
	cout << "y = ";
	cin >> y1;
	cout << "Second Coordinate" << endl;
	cout << "x = ";
	cin >> x2;
	cout << "y = ";
	cin >> y2;

	xMid = (x1 + x2) / 2;
	yMid = (y1 + y2) / 2;

	cout << "The x coordinate of the midpoint is " << setw(6) << fixed << setprecision(2) << xMid << endl;
	cout << "The y coordinate of the midpoint is " << setw(6) << fixed << setprecision(2) << yMid << endl;

	cin.ignore(2);
	return 0;
}