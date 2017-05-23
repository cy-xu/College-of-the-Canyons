/*
Kevin Ponek
May 26, 2015
CS236 Project 3
Description: Source code that contains the definitions of the Robot object
*/

#include <iostream>
#include <string>
#include "Robot.h"
using namespace std;

Robot::Robot(){
	setXPosition(0);
	setYPosition(500);
	setStatus(5);
	direction = true;
}
void Robot::move_position(){
	if ( (getXPosition() + 3) > 800 ) {
		direction = false;
	}
	else if ( (getXPosition() - 3) < 0 ) {
		direction = true;
	}

	if (direction = true)
		setXPosition(getXPosition() + 3);
	else
		setXPosition(getXPosition() - 3);
	cout << "Robot moves to " << getXPosition() << "," << getYPosition() << "     ";
}
void Robot::fire_weapon(){
	cout << "Robot fires weapon: arm gun" << endl;
}
void Robot::update_status(){
	cout << "Robot updates status: whrr-tschzz-tschzz-tschzz-chk" << endl;
}