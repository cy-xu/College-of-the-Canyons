#include <iostream>
#include "Date.h"
#include "Car.h"
#include <string>

using namespace std;

int main()
{
	int yr;
	string make;
	string model;
	int day;
	int year;
	string month;

	//creating the Car object with user inputs
	cout << "What is the year (Car)?" << endl;
	cin >> yr;
	cout << "What is the make (Car)?" << endl;
	cin >> make;
	cout << "What is the model (Car)?" << endl;
	cin >> model;
	Car car(yr, make, model);
	cout << car.toString() << endl;

	//creating the Date object with user inputs
	cout << "What is the day (Date)?" << endl;
	cin >> day;
	cout << "What is the year (Date)?" << endl;
	cin >> year;
	cout << "What is the month (Date)?" << endl;
	cin >> month;
	Date date(day, year, month);
	cout << date.toString() << endl;

	//Changing Date variables with mutator functions
	cout << "New day (Date):" << endl;
	cin >> day;
	date.setDay(day);
	cout << "New year (Date):" << endl;
	cin >> year;
	date.setYear(year);
	cout << "New month (Date):" << endl;
	cin >> month;
	date.setMonth(month);

	//Printing the Date object by pulling out the data stored
	cout << "The Date object is: " << date.getMonth() << " " << date.getDay() << ", " << date.getYear() << endl;

	//Printing the Date object with different formats
	date.printDate(0);
	date.printDate(1);
	date.printDate(2);
	date.printDate(3);

	system("pause");
	return 0;
}
