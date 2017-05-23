/*
 * Andriy Korsun
 * Professor Ferguson
 * Comp Sci 282, Project 2
 * 11/10/2015
 * 234 Trees --> B-Trees
 */
package tree234app;


public class BTree extends Tree234 {

    // -------------------------------------------------------------
    public void split(Node thisNode) 
    {

        
        Node parent;
       
        int dataItemsToMove = Node.getOrder() / 2;

        
        DataItem[] items = new DataItem[dataItemsToMove];

        
        int childrenToMove = dataItemsToMove;

        
        Node[] children = new Node[childrenToMove];

        int itemIndex;

       
        for (int i = dataItemsToMove - 1; i >= 0; i--) {

            items[i] = thisNode.removeItem();

        }

        int childIndex = childrenToMove - 1;

        
        for (int i = Node.getOrder() - 1; i > Node.getOrder() - 1 - childrenToMove; i--) {

            children[childIndex--] = thisNode.disconnectChild(i);

        }

        Node newRight = new Node();       

        if (thisNode == root) 
        {

            root = new Node();                

            parent = root;                    

            root.connectChild(0, thisNode);   
        } else 
        {
            parent = thisNode.getParent();    
        }

        
        itemIndex = parent.insertItem(items[0]); 

        int n = parent.getNumItems();         

        for (int j = n - 1; j > itemIndex; j--) 
        {                                      

            Node temp = parent.disconnectChild(j); 

            parent.connectChild(j + 1, temp);       

        }

       
        parent.connectChild(itemIndex + 1, newRight);

        
        for (int i = 1; i < dataItemsToMove; i++) {

            newRight.insertItem(items[i]);

        }

        
        
        for (int i = 0; i < dataItemsToMove; i++) {

            newRight.connectChild(i, children[i]);

        }

        

    }  

   public void insert(DataItem tempItem)

      {

      Node curNode = root;

      
      long dValue = tempItem.dData;


      while(true)

         {

         if( curNode.isFull() )               

            {

            split(curNode);                   

            curNode = curNode.getParent();    

                                              

            curNode = getNextChild(curNode, dValue);

            }  



         else if( curNode.isLeaf() )          

            break;                            

        

         else

            curNode = getNextChild(curNode, dValue);

         }  



      curNode.insertItem(tempItem);       

      }  


}
