/*
* Enemy.cpp
* College of the Canyons
* Date: May 26, 2015
* Programmer: Kevin Ponek
* Description: Contains the definitions of the Enemy abstract class
*/

#include <iostream>
#include "Enemy.h"

using namespace std;

int Enemy::getXPosition(){
	return x_position;
}
void Enemy::setXPosition(int x) {
	//Filter to only allow x-coordinates within the grid
	if (x >= 0 && x <= 800)
		x_position = x;
}
int Enemy::getYPosition(){
	return y_position;
}
void Enemy::setYPosition(int y){
	//Filter to only allow y-coordinates within the grid
	if (y >= 0 && y <= 600)
		y_position = y;
}
int Enemy::getWidth(){
	return width;
}
void Enemy::setWidth(int w){
	width = w;
}
int Enemy::getHeight(){
	return height;
}
void Enemy::setHeight(int h){
	height = h;
}
int Enemy::getStatus(){
	return status;
}
void Enemy::setStatus(int s){
	status = s;
}