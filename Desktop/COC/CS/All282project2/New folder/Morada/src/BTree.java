//Btree Code. Inherits Tree234 code, but overrides its split() method.

public class BTree extends Tree234 {

    public void split(Node thisNode) // split the node
    {

        // assumes node is full
        int movingItems;

        if ((Node.getOrder() % 2) == 0) {
            movingItems = (Node.getOrder() / 2) - 2;
        } else {
            movingItems = (Node.getOrder() / 2) - 1;
        }

        DataItem[] itemSet = new DataItem[movingItems];

        DataItem promotedItem;

        Node[] childSet = new Node[movingItems + 1];

        Node parent;

        int itemIndex;

        for (int i = movingItems - 1; i >= 0; i--) {
            itemSet[i] = thisNode.removeItem();
        }
        promotedItem = thisNode.removeItem();

        int tempA = childSet.length - 1;
        for (int i = Node.getOrder() - 1; i > Node.getOrder() - childSet.length; i--) {
            childSet[tempA] = thisNode.disconnectChild(i);
            tempA--;
        }

        Node newRight = new Node(); // make new node

        if (thisNode == root) // if this is the root,
        {

            root = new Node(); // make new root

            parent = root; // root is our parent

            root.connectChild(0, thisNode); // connect to parent

        } else // this node not the root
        {
            parent = thisNode.getParent(); // get parent
        }
        // deal with parent

        itemIndex = parent.insertItem(promotedItem); // item B to parent

        int n = parent.getNumItems(); // total items?

        for (int j = n - 1; j > itemIndex; j--) // move parent's
        { // connections

            Node temp = parent.disconnectChild(j); // one child

            parent.connectChild(j + 1, temp); // to the right

        }

        // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);

        // deal with newRight
        for (int i = 0; i < itemSet.length; i++) {
            newRight.insertItem(itemSet[i]);
        }

        for (int i = 0; i < childSet.length; i++) {
            newRight.connectChild(i, childSet[i]);
        }
    }
}
