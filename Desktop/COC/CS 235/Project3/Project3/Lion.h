#include <iostream>
#include "Enemy.h"

using namespace std;

class Lion:public Enemy{
private:
	bool direction;//true = right; false = left
public:
	Lion();
	void move_position();
	void fire_weapon();
	void update_status();
};