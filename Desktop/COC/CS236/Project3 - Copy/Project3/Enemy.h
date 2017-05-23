/*
Kevin Ponek
May 26, 2015
CS236 Project 3
Description: Source code that contains the outline for the Enemy abstract class
*/

#pragma once
#include <iostream>
using namespace std;

class Enemy {
private:
	int x_position;
	int y_position;
	int width;
	int height;
	string status;
protected:
	int getXPosition();
	void setXPosition(int x);
	int getYPosition();
	void setYPosition(int y);
	int getWidth();
	void setWidth(int w);
	int getHeight();
	void setHeight(int h);
	string getStatus();
	void setStatus(string s);
public:
	virtual void move_position() = 0;
	virtual void fire_weapon() = 0;
	virtual void update_status() = 0;
};