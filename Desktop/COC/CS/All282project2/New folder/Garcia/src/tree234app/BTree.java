package tree234app;

/*
 * @author Nicole Garcia
 * November 17, 2015
 * CS 282 Lab Project #2 
 */

public class BTree extends Tree234 {

    public void split(Node thisNode) { // split the node
        // assumes node is full
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();    // remove items from
        itemB = thisNode.removeItem();    // this node
        child2 = thisNode.disconnectChild(2); // remove children
        child3 = thisNode.disconnectChild(3); // from this node

        Node newRight = new Node();       // make new node

        if (thisNode == root) {// if this is the root,
        
            root = new Node();                // make new root
            parent = root;                    // root is our parent
            root.connectChild(0, thisNode);   // connect to parent
        } else {// this node not the root
            parent = thisNode.getParent();    // get parent
        }
        // deal with parent
        itemIndex = parent.insertItem(itemB); // item B to parent
        int n = parent.getNumItems();         // total items?

        for (int j = n - 1; j > itemIndex; j--) { // move parent's
                                      
            Node temp = parent.disconnectChild(j); // one child
            parent.connectChild(j + 1, temp);        // to the right
        }
        // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);

        // deal with newRight
        newRight.insertItem(itemC);       // item C to newRight
        newRight.connectChild(0, child2); // connect to 0 and 1
        newRight.connectChild(1, child3); // on newRight
    }  // end split()

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
