package project2_282;
public class BTree extends Tree234 {
    public void split(Node thisNode) {              // split the node
        // assumes node is full
//        DataItem itemB, itemC;
        DataItem itemArray[] = new DataItem[Node.getOrder()/2];
        Node parent/*, child2, child3*/, childArray[] = new Node[Node.getOrder()/2];
        int itemIndex, count = itemArray.length-1;
        int middleItem = (thisNode.getNumItems()/2)-1;
        for (int i = middleItem+1; i < Node.getOrder()-1; i++) {
            itemArray[count] = thisNode.removeItem();
            count--;
        }
        //itemC = thisNode.removeItem();              // remove items from
        //itemB = thisNode.removeItem();              // this node
        count = 0;
        for (int i = middleItem+2; i < Node.getOrder(); i++) {
            childArray[count] = thisNode.disconnectChild(i);       // remove children
            count++;
        }
//        child2 = thisNode.disconnectChild(2);       // remove children
//        child3 = thisNode.disconnectChild(3);       // from this node
        Node newRight = new Node();                 // make new node
        if(thisNode==root) {
            root = new Node();                      // make new root
            parent = root;                          // root is our parent
            root.connectChild(0, thisNode);         // connect to parent
        }
        else                                        // this node not the root
            parent = thisNode.getParent();          // get parent
                                                    // deal with parent
        itemIndex = parent.insertItem(itemArray[0]);       // item B to parent
        int n = parent.getNumItems();               // total items?
        for(int j=n-1; j>itemIndex; j--) {          // move parent's
            Node temp = parent.disconnectChild(j);  // one child
            parent.connectChild(j+1, temp);         // to the right
        }
           // connect newRight to parent
        parent.connectChild(itemIndex+1, newRight);
        // deal with newRight
        for (int i = 1; i < itemArray.length; i++) {
            newRight.insertItem(itemArray[i]);                 // item C to newRight
        }
//        newRight.insertItem(itemC);                 // item C to newRight
        for (int i = 1; i < childArray.length; i++) {
            newRight.connectChild(i-1, childArray[i]);           // connect to 0 and 1
        }
//        newRight.connectChild(0, child2);           // connect to 0 and 1
//        newRight.connectChild(1, child3);           // on newRight
    }  // end split()
    // -------------------------------------------------------------
}
