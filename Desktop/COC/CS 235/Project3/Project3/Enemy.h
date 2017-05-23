#include <iostream>
#pragma once
using namespace std;

class Enemy{
private:
	int x_position;
	int y_position;
	int width;
	int height;
	int status;
protected:
	int getXPosition();
	void setXPosition(int x);
	int getYPosition();
	void setYPosition(int y);
	int getWidth();
	void setWidth(int w);
	int getHeight();
	void setHeight(int h);
	int getStatus();
	void setStatus(int s);
public:
	virtual void move_position() = 0;
	virtual void fire_weapon() = 0;
	virtual void update_status() = 0;
};