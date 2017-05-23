/*
 * Kevin Ponek
 * November 10, 2015
 * CS 282 Advanced Data Structures Project 2
 * Description: BTree.java is a child of Tree234.  It implements an overridden split(Node thisNode) method that, for the most part, 
 * 	implements the split of a B-Tree.  It carries over multiple items to the new node and carries up the true middle node for higher order trees. 
 * 	As opposed to the Tree234, BTree can have orders that exceed 3.
 */
import java.io.*;

public class BTree extends Tree234{
     public void split(Node thisNode)     // split the node
 
      {
 
      // assumes node is full
 
      DataItem itemB;//data item to move up to parent
      Node parent;
      DataItem[] newNodeItems = new DataItem[(thisNode.getNumItems() - 1)/2];//newNodeItems that will move to a new node on the right
      Node[] newNodeChildren = new Node[(thisNode.getNumItems() + 1)/2];//newNodeChildren that will move over with new node items
      int itemIndex;
      int childDisconnectIndex = (thisNode.getNumItems() + 2)/2;//variable that stores the index to move children over from old node to new node
      for (int i = 0; i < newNodeItems.length; i++){//remove items from node and store in newNodeItems to move to new node later
    	  newNodeItems[i] = thisNode.removeItem();
      }
 
 
      itemB = thisNode.removeItem();    // remove item from node and store in itemB for later storage in parent
 
      for (int i = 0; i < newNodeChildren.length; i++) {
    	  newNodeChildren[i] = thisNode.disconnectChild(childDisconnectIndex + i);//thisNode.getNumItems()+2/2 is the index that the child (and parent) indexes start
      }

 
      Node newRight = new Node();       // make new node
 

 
      if(thisNode==root)                // if this is the root,
 
         {
 
         root = new Node();                // make new root
 
         parent = root;                    // root is our parent
 
         root.connectChild(0, thisNode);   // connect to parent
 
         }
 
      else                              // this node not the root
 
         parent = thisNode.getParent();    // get parent
 

 
      // deal with parent
 
      itemIndex = parent.insertItem(itemB); // item B to parent
 
      int n = parent.getNumItems();         // total items?
 

 
      for(int j=n-1; j>itemIndex; j--)          // move parent's
 
         {                                      // connections
 
         Node temp = parent.disconnectChild(j); // one child
 
         parent.connectChild(j+1, temp);        // to the right
 
         }
 
                                   // connect newRight to parent
 
      parent.connectChild(itemIndex+1, newRight);
 

 
      // deal with newRight
 
      for (int i = 0; i < newNodeItems.length; i++){//place newNodeItems into newRight node
    	  newRight.insertItem(newNodeItems[i]);
      }
      
      for (int i = 0; i < newNodeChildren.length; i++){//connect children that follow over with newNodeItems into newRight node
    	  newRight.connectChild(i, newNodeChildren[i]);
      }
      
      } // end split()
}
