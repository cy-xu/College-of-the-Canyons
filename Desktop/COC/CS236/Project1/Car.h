#include <iostream>
#include <string>

using namespace std;

class Car {
private:
	int year;
	string make;
	string model;

public:
	Car();
	Car(int ye, string ma, string mo);
	int getYear();
	string getMake();
	string getModel();
	void setYear(int ye);
	void setMake(int ma);
	void setModel(string mo);
	string toString();
};