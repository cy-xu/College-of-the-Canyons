
public class BTree extends Tree234{

    public void split(Node thisNode)     // split the node

    {
        // assumes node is full


        DataItem tmpItems[] = new DataItem[(Node.getORDER()-2)/ 2];
        Node parent;
        Node childrenArray[] = new Node[tmpItems.length + 1];

        for(int x = 0; x < tmpItems.length; x++){
            tmpItems[x] = thisNode.removeItem();
        }

        for(int x = 0; x < childrenArray.length; x++){
            childrenArray[x] = thisNode.disconnectChild(Node.getORDER() - 1);
        }

        DataItem itemB;

        //DataItem itemB, itemC;
        //Node parent, child2, child3;
        int itemIndex;

        //itemC = thisNode.removeItem();    // remove items from
        itemB = thisNode.removeItem();    // this node
        //child2 = thisNode.disconnectChild(2); // remove children
        //child3 = thisNode.disconnectChild(3); // from this node

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
        //newRight.insertItem(itemC);       // item C to newRight
        for(int x = tmpItems.length -1; x > 0; x--){
            newRight.insertItem(tmpItems[x]);
        }

        //newRight.connectChild(0, child2); // connect to 0 and 1
        //newRight.connectChild(1, child3); // on newRight
        for(int x = childrenArray.length -1; x > 0; x--){
            int position = 0;
            newRight.connectChild(position, childrenArray[x]);
            position++;
        }

    }  // end split()
}
