/*
Kevin Ponek
Link.java
April 12, 2016
CS 182 Lab Project 3
Description: This is the already created Link class that represents each
    connection between objects in the CardList.
*/

/*****************************************************************
   Class Link, the base class for a link list of playing cards
   May be placed in a file named Link.java

******************************************************************/
package project3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Link {
  protected Link next;

  public Link getNext() { return next; }
  public void setNext(Link newnext) { next = newnext; }

}  // end class Link
