/*
* Robot.h
* College of the Canyons
* Date: May 26, 2015
* Programmer: Kevin Ponek
* Description: Contains the outline for the Robot class that inherits from the Enemy abstract class
*/

#include <iostream>
#include "Enemy.h"

using namespace std;

class Robot:public Enemy{
private:
	bool direction;//true = right; false = left
	int ammo;//keeps track of ammunition
public:
	Robot();
	void move_position();
	void fire_weapon();
	void update_status();
};