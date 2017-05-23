/*
Kevin Ponek
May 26, 2015
CS236 Project 3
Description: Source code that contains the definitions of the Jet object
*/

#include <iostream>
#include <string>
#include "Jet.h"
using namespace std;

Jet::Jet(){
	setXPosition(800);
	setYPosition(100);
	setStatus(8);
	direction = false;
}
void Jet::move_position(){
	if ( (getXPosition() + 30) > 800 ) {
		direction = false;
	}
	else if ( (getXPosition() - 30) < 0 ) {
		direction = true;
	}

	if (direction = true)
		setXPosition(getXPosition() + 30);
	else
		setXPosition(getXPosition() - 30);
	cout << "Jet moves to " << getXPosition() << "," << getYPosition() << "     ";
}
void Jet::fire_weapon(){
	cout << "Jet fire weapon: missile" << endl;
}
void Jet::update_status(){
	cout << "Jet update status: PING-A-TATATATATAT..." << endl;
}