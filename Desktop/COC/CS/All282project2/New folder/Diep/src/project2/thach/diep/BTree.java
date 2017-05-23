/*Name: Thach Diep
 *Date: November 16, 2015
 *Description: BTreeProject main class for user interfaces 
 */
package project2.thach.diep;

public class BTree extends Tree234 {

    @Override
    public void split(Node thisNode) { // split the node
        DataItem[] item = new DataItem[(root.getOrder() / 2)]; //dataItem to be moved, determined by Order Size
        Node[] child = new Node[(root.getOrder() / 2)]; //new node to be moved, determined by Order Size
        Node parent; //parent node 
        int itemIndex; //determine number of items within each node

        for (int i = item.length - 1; i >= 0; i--) { //remove items from current node
            item[i] = thisNode.removeItem();
        }

        for (int i = 0; i < child.length; i++) { //disconnect items from current child node 
            child[i] = thisNode.disconnectChild((root.getOrder() - (root.getOrder() / 2)) + i);
        }

        Node newRight = new Node(); // make new node

        if (thisNode == root) {                   // if this is the root,
            root = new Node();                    // make new root
            parent = root;                        // root is our parent
            root.connectChild(0, thisNode);       // connect to parent

        } else {                                  // this node not the root
            parent = thisNode.getParent();        // get parent
        }

        itemIndex = parent.insertItem(item[0]);   //move middle item, determined by Order size, up
        int n = parent.getNumItems();             //total item within parent

        for (int j = n - 1; j > itemIndex; j--) { //move parent's connections
            Node temp = parent.disconnectChild(j);//move children connections
            parent.connectChild(j + 1, temp);
        }

        // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);

        for (int i = 1; i < item.length; i++) { //move items to new node
            newRight.insertItem(item[i]);
        }

        for (int i = 0; i < child.length; i++) { //reconnect node to parent node
            newRight.connectChild(i, child[i]);
        }
    }
}// end split()
