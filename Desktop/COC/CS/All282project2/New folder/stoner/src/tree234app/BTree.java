/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree234app;

/**
 *
 * @author justinstoner
 */
public class BTree extends Tree234{
      @Override public void split(Node thisNode){
 
      // assumes node is full
 
      DataItem itemB, itemC;
 
      Node parent, child2, child3;
      int i = 0;
      int itemIndex;
      int order = Node.getOrder();
      int dataItems = order -1;
      int num;
      Node [] childNodes = new Node[order];
      DataItem [] data;
      data = new DataItem[dataItems];
      if(dataItems % 2 == 0){
          num = (dataItems / 2) - 1;
      }else{
          num = dataItems / 2;
      }
      while(num>0){ // removes items from tree
          data[i]=thisNode.removeItem();
          i++;
          num--;
      }
      i=0;
//if dataitems even subtract 1 to get number of children to move, if odd divide by 2
 
      itemB = thisNode.removeItem();    // this node
 
 // from this node
      if(order % 2 == 0){
          num = (order / 2) - 1;
      }else{
          num = order / 2;
      }
      while(num>0){
          childNodes[i]=thisNode.disconnectChild(num);
          i++;
          num--;
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
 
      //newRight.insertItem(itemC);       item C to newRight
      
      for(int x = 0; x < data.length; x++){
          System.out.println(x);
          if(data[x] != null){
            DataItem newData = data[x];
            newRight.insertItem(newData);}
      }
 
      
      for(int y = 0; y < data.length; y++){
          Node child = childNodes[y];
          if(child != null){
              newRight.connectChild(y, child);
          }
      }
 
      }  // end split()
    
}
