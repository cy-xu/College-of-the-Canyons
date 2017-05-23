/*Gianni Lane
 * Nov 5, 2015 
 * CS 282 Lab Project
 * Splits nodes when using a B-tree
 */
package javaapplication1;

public class BTree extends Tree234{
    
    public void split(Node thisNode){     // split the node
      // assumes node is full
 
      DataItem itemB, itemC;
      Node parent, child2, child3;
      
      int itemIndex;
      
      int itemsMoved = (thisNode.getOrder()-2)/2;//number of items moved to the new node
      
      DataItem[] darray= new DataItem[itemsMoved]; //array for removed items
      
      itemC = thisNode.removeItem();    // remove items from child being split
      
      darray[0]=itemC;  //places removed item into array
      
        for(int i=0; i<itemsMoved-1;i++){ // removes a specific number of items from child being split
           itemC =thisNode.removeItem();    
           darray[i+1]=itemC; //places removed item into array
        }
      
 
      itemB = thisNode.removeItem();    // this node
 
      child2 = thisNode.disconnectChild(2); // remove children
 
      child3 = thisNode.disconnectChild(3); // from this node
 

 
      Node newRight = new Node();       // make new node
 

 
      if(thisNode==root) {               // if this is the root,
 
         root = new Node();                // make new root
 
         parent = root;                    // root is our parent
 
         root.connectChild(0, thisNode);   // connect to parent
 
         }
 
      else                              // this node not the root
 
         parent = thisNode.getParent();    // get parent
 

 
      // deal with parent
 
      itemIndex = parent.insertItem(itemB); // item B to parent
 
      int n = parent.getNumItems();         // total items?
 

 
        for(int j=n-1; j>itemIndex; j--) {         // move parent's
 
            Node temp = parent.disconnectChild(j); // one child
 
            parent.connectChild(j+1, temp);        // to the right
 
        }
 
      parent.connectChild(itemIndex+1, newRight);// connect newRight to parent
 
      // deal with newRight
        for(int i=0; i<darray.length;i++){ // places all item C's into newRight
            newRight.insertItem(darray[i]);       
        }
      //newRight.insertItem(itemD);
      newRight.connectChild(0, child2); // connect to 0 and 1
 
      newRight.connectChild(1, child3); // on newRight
 
      }  // end split()
 
// -------------------------------------------------------------
 
   // gets appropriate child of node during search for value
}
