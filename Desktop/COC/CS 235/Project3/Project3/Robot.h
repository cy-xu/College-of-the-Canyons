#include <iostream>
#include "Enemy.h"

using namespace std;

class Robot:public Enemy{
private:
	bool direction;//true = right; false = left
	int ammo;
public:
	Robot();
	void move_position();
	void fire_weapon();
	void update_status();
};