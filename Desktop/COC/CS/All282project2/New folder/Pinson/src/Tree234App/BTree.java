package Tree234App;

public class BTree extends Tree234
{
    public void split(Node thisNode)     // split the node
    {
        // Order --> num to move
        // 5 --> 3
        // 6 --> 3
        // 7 --> 4
        // 8 --> 4
        int numOfItemsToMove = (Node.ORDER / 2) + (Node.ORDER % 2);        
        DataItem[] di = new DataItem[numOfItemsToMove];
        
        for(int i = di.length-1; i >= 0; i--){
            DataItem removed = thisNode.removeItem();
            di[i] = removed;
        }
        
        int numOfNodesToMove = Node.ORDER - 2;
        Node[] nodes = new Node[numOfNodesToMove];
        
        for(int i = nodes.length-1; i >= numOfNodesToMove; i--){
            Node moving = thisNode.disconnectChild(i);
            nodes[i] = moving;
        }
        
        // assumes node is full
        Node parent;
        int itemIndex;

        Node newRight = new Node();       // make new node

        if (thisNode == root)                 // if this is the root,
        {
            root = new Node();                // make new root
            parent = root;                    // root is our parent
            root.connectChild(0, thisNode);   // connect to parent
        } else                                // this node not the root
        {
            parent = thisNode.getParent();    // get parent
        }

        // deal with parent
        itemIndex = parent.insertItem(di[0]); // item B to parent

        int n = parent.getNumItems();         // total items?

        for (int j = n - 1; j > itemIndex; j--)          // move parent's
        {                                      // connections
            Node temp = parent.disconnectChild(j); // one child
            parent.connectChild(j + 1, temp);        // to the right
        }
        // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);

        // deal with newRight
        for(int i = 1; i < di.length; i++){
            newRight.insertItem(di[i]);// item C to newRight 
        }
        for(int i = 0; i < di.length; i++){
            Node child = nodes[i];
            if (child != null)
                newRight.connectChild(i, child); // connect to newRight
        }
    }  // end split()
}
