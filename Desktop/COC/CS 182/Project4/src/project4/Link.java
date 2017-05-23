/*****************************************************************
   Class Link, the base class for a link list of playing cards
   May be placed in a file named Link.java

******************************************************************/
package project4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Link {
  protected Link next;

  public Link getNext() { return next; }
  public void setNext(Link newnext) { next = newnext; }

}  // end class Link
