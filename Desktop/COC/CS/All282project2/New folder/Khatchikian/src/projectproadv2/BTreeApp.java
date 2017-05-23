/* 
 * Name(Author): Oganes
 * File:   BTreeApp.java
 *  Date Created: Nov 3, 2015, 11:48:00 PM
 *  Project Name: BTreeApp
 *  Description: This is a override to the main program perant is Tree234App and the child is BTreeApp.
 * This class is call when the user changes the ORDER of the prgram.
 * 
 * 
 * 
 * This class is for spliting the BTree on the way to split a node is its reached it full ORDER, the
 * code is the same from its perant class however here is a example of what this is changed to:
 * For example, when ORDER = 4, there will be 3 items in the node when a split occurs: A B C
 * In this case, Tree234 split must move one item ( C ) to the new node
 * For example, when ORDER = 6, there will be 5 items in the node when a split occurs: A A B C C
 * In this case, Btree split must move two items ( C C ) to the new node
 * For example, when ORDER = 7, there will be 6 items in the node when a split occurs: A A A B C C
 * In this case, Btree split must move two items ( C C ) to the new node
 * For example, when ORDER = 8, there will be 7 items in the node when a split occurs: A A A B C C C
 * In this case, Btree split must move three items ( C C C ) to the new node
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
public class BTreeApp {

    private Node root = new Node();            // make root node

// -------------------------------------------------------------
    public void split(Node thisNode) // split the node
    {
        // assumes node is full
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();    // remove items from
        itemB = thisNode.removeItem();    // this node
        child2 = thisNode.disconnectChild(2); // remove children
        child3 = thisNode.disconnectChild(3); // from this node

        Node newRight = new Node();       // make new node

        if (thisNode == root) // if this is the root,
        {
            root = new Node();                // make new root
            parent = root;                    // root is our parent
            root.connectChild(0, thisNode);   // connect to parent
        } else // this node not the root
        {
            parent = thisNode.getParent();    // get parent
        }
        // deal with parent
        itemIndex = parent.insertItem(itemB); // item B to parent
        int n = parent.getNumItems();         // total items?

        for (int j = n - 1; j > itemIndex; j--) // move parent's
        {                                      // connections
            Node temp = parent.disconnectChild(j); // one child
            parent.connectChild(j + 1, temp);        // to the right
        }
        // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);

        // deal with newRight
        newRight.insertItem(itemC);       // item C to newRight
        newRight.connectChild(0, child2); // connect to 0 and 1
        newRight.connectChild(1, child3); // on newRight
    }  // end split()
// -------------------------------------------------------------

}
