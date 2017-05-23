/*
Brian Dimaculangan
November 17, 2015
CS282 Advanced Data Structures Project 1
Description: This class extends class Tree234 and when order > 4, it implements
    this class. Contains the new split method which differs from a 234 Tree split.
 */

/**
 *
 * @author Brainiac
 */
public class BTree extends Tree234 
{
    public int neworder;
    
    public BTree(int theorder)
    {
        neworder = theorder;
    }

    public void split(Node thisNode)     // split the node
    {                                   // assumes node is full
        int moving = (neworder / 2) - 1;
        DataItem itemB, itemC;
        Node parent, child;
        int itemIndex;
        
        Node newRight = new Node();         // make new node
        for(int i = 0; i < moving; i++)
        {
            itemC = thisNode.removeItem();
            newRight.insertItem(itemC);
        }
        
        for(int i = 0; i <= moving; i++)
        {
            child = thisNode.disconnectChild((neworder-1)-i);
            newRight.connectChild(moving-i, child);
        }

        itemB = thisNode.removeItem();    // this node

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
    }  // end split()
// -------------------------------------------------------------
    
    
    
    
    
}
