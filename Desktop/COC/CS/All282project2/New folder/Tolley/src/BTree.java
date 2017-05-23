/*
 * COMP 282-17867 - Advanced Data Structures
 * Project 2: BTree
 * Programmer: Alexander Tolley
 * Date last edited: 11/16/2015
 * Description: This class describes a BTree that inherits from the Tree234 class.
                It has its own unique split method in order to move multiple DataItems during a split
 */
public class BTree extends Tree234 {

    public void split(Node thisNode) // split the node
    {
        // assumes node is full
        DataItem itemB;
        Node parent;
        int itemIndex;
        
        int numItemsToMove = ((thisNode.getORDER() / 2) - 1);
        DataItem[] itemsC = new DataItem[numItemsToMove];
        Node[] childs = new Node[numItemsToMove + 1];

        for (int i = 0; i < numItemsToMove; i++) {
            itemsC[i] = thisNode.removeItem();    // remove items from
        }
        
        itemB = thisNode.removeItem();    // this node
        
        for (int i = 0; i <= numItemsToMove; i++) {
            childs[i] = thisNode.disconnectChild((thisNode.getORDER()/2) + i);
        }

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
        
        for (int i = 0; i < numItemsToMove; i++) {
            newRight.insertItem(itemsC[i]);       // item C to newRight
        }
        for (int i = 0; i <= numItemsToMove; i++)
        {
            newRight.connectChild(i, childs[i]);
        }
    }  // end split()
}
