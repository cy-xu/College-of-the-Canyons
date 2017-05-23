/*
* Lion.cpp
* College of the Canyons
* Date: May 26, 2015
* Programmer: Kevin Ponek
* Description: Contains the definitions of the Lion class that inherits from the Enemy abstract class
*/

#include <iostream>
#include <string>
#include <stdlib.h>
#include <time.h>
#include "Enemy.h"
#include "Lion.h"

using namespace std;

Lion::Lion(){
	setXPosition(400);
	setYPosition(500);
	setStatus(2);
	direction = true;
}
void Lion::move_position(){
	//check if object is not dead
	if (getStatus() != 0) {
		//check to make sure it won't move past 2D space boundary
		//object will change direction if it would go past boundary
		if ( (direction) && (getXPosition() + 10) > 800) {
			direction = false;
		}
		else if ( !(direction) && (getXPosition() - 10) < 0) {
			direction = true;
		}
		//move to right
		if (direction) {
			setXPosition(getXPosition() + 10);
		}
		//move to left
		else
			setXPosition(getXPosition() - 10);
		cout << "Lion moves to " << getXPosition() << "," << getYPosition() << "     ";
	}
	//object is dead
	else
		cout << "Lion's dead body remains at " << getXPosition() << "," << getYPosition() << "     ";
}
void Lion::fire_weapon(){
	string attacks[8] = {"rip head", "bite head", "rip chest", "bite chest", "rip arm", "bite arm", "rip leg", "bite leg"};
	int randAttack;
	srand((unsigned int)time(NULL));
	cout << "Lion uses weapon: ";
	//check if object is not dead
	if (getStatus() != 0) {
		randAttack = rand() % 8;
		cout << attacks[randAttack] << endl;
	}
	//object is dead
	else
		cout << "dead" << endl;
}
void Lion::update_status(){
	//check if object is not dead or about to die
	if (getStatus() > 1) {
		setStatus(getStatus() - 1);
		cout << "Lion update status: hit by bullet, status points: " << getStatus() << " (RRAAAARRLLL!!!)" << endl;
	}
	//object is dead
	else
		cout << "Lion update status: hit by bullet, status points: 0 (dead)" << endl;
}