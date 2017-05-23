#include <iostream>
#include <sstream>
#include "Car.h"
#include <string>

using namespace std;

Car::Car()
{
	year = 2004;
	make = "Acura";
	model = "RSX";
}
Car::Car(int ye, string ma, string mo)
{
	if (ye >= 1886 || ye <= 2099)
		year = ye;
	else
		cout << "Year is not a reasonable input between 1886 and 2099" << endl;

	make = ma;
	model = mo;
}
int Car::getYear()
{
	return year;
}
string Car::getMake()
{
	return make;
}
string Car::getModel()
{
	return model;
}
void Car::setYear(int ye)
{
	if (ye >= 1886 || ye <= 2099)
		year = ye;
	else
		cout << "Year is not a reasonable input between 1886 and 2099" << endl;
}
void Car::setMake(int ma)
{
	make = ma;
}
void Car::setModel(string mo)
{
	model = mo;
}
string Car::toString()
{
	stringstream ssYear;
	ssYear << year;
	string yearString = ssYear.str();

	return (yearString + " " + make + " " + model);
}