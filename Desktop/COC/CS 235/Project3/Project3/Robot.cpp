#include <iostream>
#include "Enemy.h"
#include "Robot.h"

using namespace std;

Robot::Robot(){
	setXPosition(0);
	setYPosition(500);
	setStatus(4);
	direction = true;
	ammo = 20;
}
void Robot::move_position(){
	//check if object is not dead
	if (getStatus() != 0) {
		//check to make sure it won't move past 2D space boundary
		//object will change direction if it would go past boundary
		if ( (direction) && (getXPosition() + 5) > 800) {
			direction = false;
		}
		else if ( !(direction) && (getXPosition() - 5) < 0) {
			direction = true;
		}
		//move to right
		if (direction) {
			setXPosition(getXPosition() + 5);
		}
		//move to left
		else
			setXPosition(getXPosition() - 5);
		cout << "Robot move to " << getXPosition() << "," << getYPosition() << "     ";
	}
	//object is dead
	else
		cout << "Robot's dead body remains at " << getXPosition() << "," << getYPosition() << "     ";
}
void Robot::fire_weapon(){
	cout << "Robot fires weapon: ";
	//check if object is not dead
	if (getStatus() != 0) {
		//check if has ammo
		if (ammo != 0) {
			ammo--;
			cout << "arm cannon (" << ammo << " left)" << endl;
		}
		//does not have ammo
		else
			cout << "none (no ammo available)" << endl;
	}
	//object is dead
	else
		cout << "dead" << endl;
}
void Robot::update_status(){
	//check if object is not dead or about to die
	if (getStatus() > 1) {
		setStatus(getStatus() - 1);
		cout << "Robot update status: hit by bullet, status points: " << getStatus() << " (tzk-chtktktktktktkt!!!)" << endl;
	}
	//object is dead
	else
		cout << "Robot update status: hit by bullet, status points: 0 (dead)" << endl;
}