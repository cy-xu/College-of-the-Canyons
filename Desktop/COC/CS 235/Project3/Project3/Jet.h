#include <iostream>
#include "Enemy.h"

using namespace std;

class Jet:public Enemy{
private:
	bool direction;//true 8= right; false = left
	int ammo;
public:
	Jet();
	void move_position();
	void fire_weapon();
	void update_status();
};