/*
Kevin Ponek
May 26, 2015
CS236 Project 3
Description: Source code that contains the definitions of the Lion object
*/

#include <iostream>
#include <string>
#include "Lion.h"
using namespace std;

Lion::Lion(){
	setXPosition(400);
	setYPosition(500);
	setStatus(2);
	direction = true;
}
void Lion::move_position(){
	if ( (getXPosition() + 10) > 800 ) {
		direction = false;
	}
	else if ( (getXPosition() - 10) < 0 ) {
		direction = true;
	}

	if (direction = true)
		setXPosition(getXPosition() + 10);
	else
		setXPosition(getXPosition() - 10);
	cout << "Lion moves to " << getXPosition() << "," << getYPosition() << "     ";
}
void Lion::fire_weapon(){
	cout << "Lion uses weapon: rip" << endl;
}
void Lion::update_status(){
	cout << "Lion update status: RRAAAARRL!" << endl;
}