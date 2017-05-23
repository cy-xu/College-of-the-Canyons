/*
 * Programmer: Aaron Duldulao
 * CMPSCI282 - Advanced Data Structure
 * Project 2
 * Date last modified: 11/16/2015
 * Description: This is a class for manipulating the data items of a B-tree
 */

public class BTree extends Tree234
{
    @Override
    public void split(Node thisNode) // split the node
    {
      // assumes node is full
        int order = Node.getOrder();
        DataItem [] item = new DataItem[order-1];
        Node parent;
        Node [] child = new Node[order];
        int itemIndex;
        int moveUpIndex = thisNode.getNumItems()/2;
        int newChildIndex = 0;
        
        for(int x = thisNode.getNumItems()-1; x >= moveUpIndex; x--)
        {
            item[x] = thisNode.removeItem(); // remove items from this node
        }
        for(int x = Node.getOrder()-1; x > moveUpIndex; x--)
        {
            child[x] = thisNode.disconnectChild(x); // remove children from this node
        }

        Node newRight = new Node();       // make new node

        if (thisNode == root) // if this is the root,
        {
            root = new Node();                // make new root
            parent = root;                    // root is our parent
            root.connectChild(0, thisNode);   // connect to parent
        } 
        else // this node not the root
        {
            parent = thisNode.getParent();    // get parent
        }

      // deal with parent
        itemIndex = parent.insertItem(item[moveUpIndex]); // middle item to parent
        int n = parent.getNumItems();         // total items?
        for (int j = n - 1; j > itemIndex; j--) // move parent's
        {                                      // connections
            Node temp = parent.disconnectChild(j); // one child
            parent.connectChild(j + 1, temp);        // to the right
        }
                                   // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);
      // deal with newRight
        for(int x = moveUpIndex+1; x < order - 1; x++)
        {
            newRight.insertItem(item[x]);       // right items to newRight
        }
        for(int x = moveUpIndex+1; x < order; x++)
        {
            newRight.connectChild(newChildIndex, child[x]); // connect children to new right
            newChildIndex++;
        }
    }
}
