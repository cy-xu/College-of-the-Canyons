/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package black.project2;

/**
 *
 * @author Aaron
 */
public class BTree extends Tree234{
    
    @Override
    public void split(Node thisNode) { // split the node
        Node parentNode, newNode;
        newNode = new Node();       // make new node
        int order = thisNode.getNumItems() + 1;
        
        // get parent, or split root if no parent
        if (thisNode == root) {
            // if there is no parent (because root), make one and attach thisNode to it
            root = new Node();
            parentNode = root;
            root.connectChild(0, thisNode);
        } else { // this node not the root
            // else get parent
            parentNode = thisNode.getParent();
        }
        
        // deal with data items
        // doing this before attaching new node, because we're using the DataItem insert location later
        for (int j = 0; j < order / 2 - 1; j++) {
            // remove order / 2 (rounded down) data items from current node, add to new node
            DataItem temp = thisNode.removeItem();
            newNode.insertItem(temp);
        }
        // previous removal leaves us at the middle item, the one to be promoted
        // so promote middle (rounded up) data item to parent, and remember where we put it
        int itemIndex;
        itemIndex = parentNode.insertItem(thisNode.removeItem());
        
        // deal with parent child connections
        int n = parentNode.getNumItems();
        for (int j = n - 1; j > itemIndex; j--) {
            // disconnect child at j, reconnect it to j+1 to make room for new node
            Node temp = parentNode.disconnectChild(j);
            parentNode.connectChild(j + 1, temp);
        }
        parentNode.connectChild(itemIndex + 1, newNode); // connect newRight to parent
        
        // deal with child connections to new node
        for (int k = 0; k < order / 2; k++) {
            // disconnect child at (order + 1) / 2 + k, reconnect it to new node at k
            Node temp = thisNode.disconnectChild((order + 1) / 2 + k);
            newNode.connectChild(k, temp);
        }
        
        
    }  // end split()

}
