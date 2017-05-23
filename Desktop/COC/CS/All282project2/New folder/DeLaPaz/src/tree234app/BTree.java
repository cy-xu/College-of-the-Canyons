package tree234app;


public class BTree extends Tree234 {

    public BTree(int Order) // constructor
    {
        root.setOrder(Order);
    }

    public void split(Node thisNode) // split the node
    {
        int i = thisNode.getNumItems();

        Node newRight = new Node(); // make new node

        int Order = thisNode.getNumItems();

        System.out.println("Number of Items Moved: " + Order / 2);
        System.out.println("Items moved to new child: ");

        for (int j = Order; j > ((Order / 2) + 1); j--) {

            DataItem itemj;

            itemj = thisNode.removeItem();

            newRight.insertItem(itemj);
            System.out.print(itemj + " ");
        }
        System.out.println("");

      // assumes node is full
        DataItem itemB; //, itemC

        Node parent, child2, child3;

        int itemIndex;

      //itemC = thisNode.removeItem();    // remove items from
        itemB = thisNode.removeItem();    // this node

        child2 = thisNode.disconnectChild(2); // remove children

        child3 = thisNode.disconnectChild(3); // from this node

//Node newRight = new Node();       // make new node
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
//newRight.insertItem(itemC);       // item C to newRight
        newRight.connectChild(0, child2); // connect to 0 and 1

        newRight.connectChild(1, child3); // on newRight

    }  // end split()

// -------------------------------------------------------------
   // gets appropriate child of node during search for value
    public Node getNextChild(Node theNode, long theValue) {

        int j;

      // assumes node is not empty, not full, not a leaf
        int numItems = theNode.getNumItems();

        for (j = 0; j < numItems; j++) // for each item in node
        {                               // are we less?

            if (theValue < theNode.getItem(j).dData) {
                return theNode.getChild(j);  // return left child
            }
        }  // end for                   // we're greater, so

        return theNode.getChild(j);        // return right child

    }

// -------------------------------------------------------------
    public void displayTree() {

        recDisplayTree(root, 0, 0);

    }

// -------------------------------------------------------------
    private void recDisplayTree(Node thisNode, int level,
            int childNumber) {

        System.out.print("level=" + level + " child=" + childNumber + " ");

        thisNode.displayNode();               // display this node

      // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();

        for (int j = 0; j < numItems + 1; j++) {

            Node nextNode = thisNode.getChild(j);

            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, j);
            } else {
                return;
            }

        }

    }  // end recDisplayTree()

// -------------------------------------------------------------\
}
