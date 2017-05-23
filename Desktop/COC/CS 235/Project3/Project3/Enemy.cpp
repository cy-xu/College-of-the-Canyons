#include <iostream>
#include "Enemy.h"

using namespace std;

int Enemy::getXPosition(){
	return x_position;
}
void Enemy::setXPosition(int x) {
	x_position = x;
}
int Enemy::getYPosition(){
	return y_position;
}
void Enemy::setYPosition(int y){
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