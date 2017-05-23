/*
Kevin Ponek
May 26, 2015
CS236 Project 3
Description: Source code that contains the outline of the Lion object that inherits from the Enemy parent object
*/

#include <iostream>
#include "Enemy.h"
using namespace std;

class Lion : public Enemy {
private:
	bool direction;//Right is True
public:
	Lion();
	void move_position();
	void fire_weapon();
	void update_status();
};