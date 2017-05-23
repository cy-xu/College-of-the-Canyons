import java.io.*;

public class BTree extends Tree234{
     public void split(Node thisNode)     // split the node
 
      {
 
      // assumes node is full
 
      DataItem itemB;
      Node parent;
      DataItem[] newNodeItems = new DataItem[(thisNode.getNumItems() - 1)/2];
      Node[] children = new Node[(thisNode.getNumItems() + 1)/2];
 
      int itemIndex;
 
      for (int i = 0; i < newNodeItems.length; i++){
    	  newNodeItems[i] = thisNode.removeItem();
      }
 
 
      itemB = thisNode.removeItem();    // this node
 
      for (int i = 0; i < children.length; i++) {
    	  System.out.println(children.length);
    	  System.out.println("Child number: " + i + ", Index number: " + (thisNode.getNumItems() + i) );
    	  children[i] = thisNode.disconnectChild(thisNode.getNumItems() + i);
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
 
      for (int i = 0; i < newNodeItems.length; i++){
    	  System.out.println("newRight insert new node: loop " + i);
    	  newRight.insertItem(newNodeItems[i]);
      }
      
      for (int i = 0; i < children.length; i++){
    	  newRight.connectChild(i, children[i]);
      }
      
      } // end split()
}
