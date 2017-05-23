#include <iostream>
#include <sstream>
#include "Date.h"
#include <string>

using namespace std;

Date::Date()
{
	day = 1;
	year = 1970;
	month = "January";
}
Date::Date(int da, int ye, string mo)
{
	if (da >= 1 && da <= 31)
		day = da;
	else
		cout << "Day is not a reasonable input between 1 and 31" << endl;
	if (ye >= 1970 && ye <= 2099)
		year = ye;
	else 
		cout << "Year is not a reasonable input between 1970 and 2099" << endl;
	month = mo;
}

int Date::getDay()
{
	return day;
}
int Date::getYear()
{
	return year;
}
string Date::getMonth()
{
	return month;
}

void Date::setDay(int da)
{
	if (da >= 1 && da <= 31)
		day = da;
	else
		cout << "Day is not a reasonable input between 1 and 31" << endl;
}
void Date::setYear(int ye)
{
	if (ye >= 1970 && ye <= 2099)
		year = ye;
	else
		cout << "Year is not a reasonable input between 1970 and 2099" << endl;
}
void Date::setMonth(string mo)
{
	month = mo;
}

string Date::toString()
{
	stringstream ssDay;
	ssDay << day;
	string dayString = ssDay.str();

	stringstream ssYear;
	ssYear << year;
	string yearString = ssYear.str();

	 return (month + " " + dayString + ", " + yearString);
}

int Date::getMonthNumber()
{
	const string monthArrayFull[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	const string monthArrayAbbrev[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	for (int i = 0; i < 12; i++)
	{
		if (monthArrayFull[i] == month || monthArrayAbbrev[i] == month)
		{
			return i + 1;
		}
	}
	return -1;

	/*if (month == "January" || month == "Jan")
	{
		return 1;
	}
	else if (month == "February" || month == "Feb")
	{
		return 2;
	}
	else if (month == "March" || month == "Mar")
	{
		return 3;
	}
	else if (month == "April" || month == "Apr")
	{
		return 4;
	}
	else if (month == "May")
	{
		return 5;
	}
	else if (month == "June" || month == "Jun")
	{
		return 6;
	}
	else if (month == "July" || month == "Jul")
	{
		return 7;
	}
	else if (month == "August" || month == "Aug")
	{
		return 8;
	}
	else if (month == "September" || month == "Sep")
	{
		return 9;
	}
	else if (month == "October" || month == "Oct")
	{
		return 10;
	}
	else if (month == "November" || month == "Nov")
	{
		return 11;
	}
	else if (month == "December" || month == "Dec")
	{
		return 12;
	}
	else
		return -1;*/
}
void Date::printDate(int format)
{
	if (format == 0)
	{
		cout << month << " " << day << ", " << year << endl;
	}
	else if (format == 1)
	{
		cout << day << " " << month << " " << year << endl;
	}
	else if (format == 2)
	{
		cout << getMonthNumber() << "-" << day << "-" << year << endl;
	}
	else if (format == 3)
	{
		cout << getMonthNumber() << "/" << day << "/" << year % 100 << endl;
	}
}