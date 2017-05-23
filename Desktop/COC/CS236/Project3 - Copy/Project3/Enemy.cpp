/*
Kevin Ponek
May 26, 2015
CS236 Project 3
Description: Source code that contains the definitions of the Enemy abstract class
*/

#include <iostream>
#include <string>
#include "Enemy.h"
using namespace std;

int Enemy::getXPosition() {
	return x_position;
}
void Enemy::setXPosition(int x){
	x_position = x;
}
int Enemy::getYPosition() {
	return y_position;
}
void Enemy::setYPosition(int y){
	y_position = y;
}
int Enemy::getWidth() {
	return width;
}
void Enemy::setWidth(int w){
	width = w;
}
int Enemy::getHeight() {
	return height;
}
void Enemy::setHeight(int h){
	height = h;
}
string Enemy::getStatus(){
	return status;
}
void Enemy::setStatus(string s){
	status = s;
}