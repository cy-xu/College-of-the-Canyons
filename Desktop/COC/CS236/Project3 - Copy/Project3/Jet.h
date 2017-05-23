/*
Kevin Ponek
May 26, 2015
CS236 Project 3
Description: Source code that contains the outline of the Jet object that inherits from the Enemy parent object
*/

#include <iostream>
#include "Enemy.h"
using namespace std;

class Jet : public Enemy {
public:
	void move_position();
	void fire_weapon();
	void update_status();
};