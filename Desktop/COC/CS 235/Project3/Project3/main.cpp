//#include "stdafx.h"   // not needed by some IDE's
#include <conio.h>
#include <iostream>
#include <stdlib.h>
#include <time.h>
#include "Enemy.h"
#include "Jet.h"
#include "Lion.h"
#include "Robot.h"

using namespace std;

int main(int argc, char* argv[])
{
	const int max_enemy = 20;
	Enemy* enemy_ptr[max_enemy];
	int num_enemy;
	srand((unsigned int)time(NULL));

	// create Enemy objects, place in array
	enemy_ptr[0] = new Jet();
	enemy_ptr[1] = new Lion();
	enemy_ptr[2] = new Robot();
	// set value of num_enemy
	num_enemy = 3;
	while (true) {

		// every Enemy object should move_position 
		for (int i = 0; i < num_enemy; i++) {
			enemy_ptr[i]->move_position();
		}
		cout << endl;
		// Pick a random Enemy to fire_weapon
		int RandIndex = rand() % num_enemy;
		enemy_ptr[RandIndex]->fire_weapon();
		// Pick a random Enemy to update_status	
		RandIndex = rand() % num_enemy;
		enemy_ptr[RandIndex]->update_status();
		_getch();
		cout << endl;
	}
	return 0;
}