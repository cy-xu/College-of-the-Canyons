/*Megan Meyers
//11/15/15
//class 282 project 2
//This Overridden split method extended by inheritence from Tree234 handles any tree of Order 5 or greater. 
*/

public class BTree extends Tree234 {

    @Override //override to modify the implementation of a method defined in the superclass
    public void split(Node thisNode) // split the node
    {
        // assumes node is full
        Node parent;
        DataItem itemB;  // mid node that always moves into the parent node

        if (thisNode == root) // if this is the root,
        {
            root = new Node();                // make new root
            parent = root;                    // root is our parent
            root.connectChild(0, thisNode);   // connect to parent
        } else // this node not the root
        {
            parent = thisNode.getParent();    // get parent
        }

        int n = thisNode.getNumItems();
        int mid = (n / 2); //gives approx midpoint that translates to what will stay in thisNode 

        Node newRight = new Node();  //create a new node to go to the right of the old node
        int move = n - mid;   
        System.out.println("Move "+move+" items out of the full node.");
        for (int i = mid + 1; i < n; i++) { // skip over (keep) A's and B and send all the C values to the new R node

            DataItem temp = thisNode.removeItem();
            newRight.insertItem(temp);
            System.out.println("Move: " + temp.dData + " to new right node");
        }

        itemB = thisNode.removeItem(); //C items are gone, now B is the largest item so remove it and just leave the A's
        System.out.println("Move: " + itemB.dData + " to parent.");
        int itemIndex = parent.insertItem(itemB);  //insert itemB into the parent and save the index where it went 

        // dataItems are now moved. Now deal with the parent/child links:
        int newRCL = 0;
        for (int j = mid + 1; j <= n; j++) {  //move child references from thisNode to newRight        
            newRight.connectChild(newRCL++, thisNode.disconnectChild(j));
        }
        n = parent.getNumItems();         //update n to parent's numItems
        for (int j = n - 1; j > itemIndex; j--) // move parent's
        {                                                    // connections
            Node temp = parent.disconnectChild(j);           // one child
            parent.connectChild(j + 1, temp);                 // to the right
        }
        parent.connectChild(itemIndex + 1, newRight);   // connect newRight to parent

    }  // end split()

}//end class BTree

