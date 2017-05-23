#include <iostream>
#include <string>

using namespace std;

class Date {
private:
	int day;
	int year;
	string month;

public:
	Date();
	Date(int da, int ye, string mo);
	int getDay();
	int getYear();
	string getMonth();
	void setDay(int da);
	void setYear(int ye);
	void setMonth(string mo);
	string toString();
	int Date::getMonthNumber();
	void Date::printDate(int format);
};