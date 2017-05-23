/* 
 * Name(Author): Oganes
 * File:   Node.java
 *  Date Created: Nov 3, 2015, 11:48:23 PM
 *  Project Name: Node
 *  Description: The setOrder is where we can change the ORDER from 234-Tree to B-Tree. The defualt is set to
 * 4 ORDER, the user can go to change the ORDER.
 * The default is set to 4 thus it is a 234-Tree when the user changes the ORDER then this will be override from
 * the default 4 to anything the user chooses.
 * 
 * This code is a copy from the book.
    
    Data Structures and Algorithms in java
    By: Robert Lafore
    Used At: College of the Canyons
    Class: Computer Science 282
    Instructor: Chris Ferguson
    For: Project 2.

 * The change is the variable not being final for the ORDER.
 */
package projectproadv2;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Oganes
 */
public class Node {

    Scanner inout = new Scanner(System.in);
    //*~~----- The ORDER for 234-Tree is ORDER = 4, anything higher is a B-Tree -----~~*//
    public int orderSize;
    private int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER - 1];
// -------------------------------------------------------------
    // connect child to this node

    public void run() {
        System.out.println("Please enter in a ORDER");
        System.out.print(": ");
        setOrder(inout.nextInt());
    }

    public void setOrder(int orderSize) {
        ORDER = orderSize;
    }

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }
// -------------------------------------------------------------
    // disconnect child from this node, return it

    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }
// -------------------------------------------------------------

    public Node getChild(int childNum) {
        return childArray[childNum];
    }
// -------------------------------------------------------------

    public Node getParent() {
        return parent;
    }
// -------------------------------------------------------------

    public boolean isLeaf() {
        return (childArray[0] == null);
    }
// -------------------------------------------------------------

    public int getNumItems() {
        return numItems;
    }
// -------------------------------------------------------------

    public DataItem getItem(int index) // get DataItem at index
    {
        return itemArray[index];
    }
// -------------------------------------------------------------

    public boolean isFull() {
        return (numItems == ORDER - 1);
    }
// -------------------------------------------------------------

    public int findItem(long key) // return index of
    {                                    // item (within node)
        for (int j = 0; j < ORDER - 1; j++) // if found,
        {                                 // otherwise,
            if (itemArray[j] == null) // return -1
            {
                break;
            } else if (itemArray[j].dData == key) {
                return j;
            }
        }
        return -1;
    }  // end findItem
// -------------------------------------------------------------

    public int insertItem(DataItem newItem) {
        // assumes node is not full
        numItems++;                          // will add new item
        long newKey = newItem.dData;         // key of new item

        for (int j = ORDER - 2; j >= 0; j--) // start on right,
        {                                 //    examine items
            if (itemArray[j] == null) // if item null,
            {
                continue;                      // go left one cell
            } else // not null,
            {                              // get its key
                long itsKey = itemArray[j].dData;
                if (newKey < itsKey) // if it's bigger
                {
                    itemArray[j + 1] = itemArray[j]; // shift it right
                } else {
                    itemArray[j + 1] = newItem;   // insert new item
                    return j + 1;                 // return index to
                }                           //    new item
            }  // end else (not null)
        }  // end for                     // shifted all items,
        itemArray[0] = newItem;              // insert new item
        return 0;
    }  // end insertItem()
// -------------------------------------------------------------

    public DataItem removeItem() // remove largest item
    {
        // assumes node not empty
        DataItem temp = itemArray[numItems - 1];  // save item
        itemArray[numItems - 1] = null;           // disconnect it
        numItems--;                             // one less item
        return temp;                            // return item
    }
// -------------------------------------------------------------

    public void displayNode() // format "/24/56/74/"
    {
        for (int j = 0; j < numItems; j++) {
            itemArray[j].displayItem();   // "/56"
        }
        System.out.println("/");         // final "/"
    }
}


/*if (some_key < zero){
 some_items[some_key + 1] = some_items[some_key];
 } else {
 some_items[some_key + 1] = some_items;
 return some_key + 1;
 }*/
