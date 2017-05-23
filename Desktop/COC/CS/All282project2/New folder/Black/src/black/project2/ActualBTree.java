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
public class ActualBTree extends Tree234 {
    
    @Override
    public void insert(DataItem tempItem) {
        Node curNode = root;
        while (true) {
            if (curNode.isLeaf()) // if node is leaf,
            {
                break;                            // go insert
            } // node is not full, not a leaf; so go to lower level
            else {
                curNode = getNextChild(curNode, tempItem.dData);
            }
        }  // end while
        if (curNode.isFull())  // if node full,
            split(tempItem, curNode);                   // split it
        else 
            curNode.insertItem(tempItem);       // insert new DataItem
    }    

    public void split(DataItem tempItem, Node thisNode) {
        split(thisNode, tempItem, null);
    }
    
    public void split(Node thisNode, DataItem newItem, Node newChild) { // split the node
        Node parentNode, newNode, maxChild;
        newNode = new Node();       // make new node
        DataItem maxItem;
        int items = thisNode.getNumItems();
        
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
        
        int k = items - 1;
        
        // do the insert of the new item and associated new child, storing largest in spillover containers
        if (newItem.dData > thisNode.getItem(k).dData) {
            maxItem = newItem;
            maxChild = newChild;
        }
        else {
            maxItem = thisNode.removeItem();
            maxChild = thisNode.disconnectChild(items);
            
            // rely on node method to insert dataItem
            int index = thisNode.insertItem(newItem);
            
            // use returned index to insert newChild
            // make room
            for (; k > index; k--) {
                thisNode.connectChild(k + 1, thisNode.disconnectChild(k));
            }
            // then insert it
            thisNode.connectChild(index + 1, newChild);
        }
        
        // push stuff into the newNode, in order to avoid repeated insertion shifts
        int remove = 0;
        int j = items / 2 + 1;
        // attach new left child
        newNode.connectChild(0, thisNode.disconnectChild(j));
        for (; j < items; j++) {
            // move items in order, starting from right of center. move children too
            newNode.connectChild(remove + 1, thisNode.disconnectChild(j + 1));
            newNode.insertItem(thisNode.getItem(j));
            remove++;
        }
        // insert / attach separate held items
        newNode.insertItem(maxItem);
        newNode.connectChild(remove + 1, maxChild);
        
        // remove leftover items in original node
        for (j = 0; j < remove; j++) {
            thisNode.removeItem();
        }
                
        // pass the promoted dataItem and the newRight up to the parent for insertion
        if (parentNode.isFull()) {
            split(parentNode, thisNode.removeItem(), newNode);
        }
        else {
            int itemIndex = parentNode.insertItem(thisNode.removeItem());
            int n = parentNode.getNumItems();
            for (j = n - 1; j > itemIndex; j--) {
                // disconnect child at j, reconnect it to j+1 to make room for new node
                Node temp = parentNode.disconnectChild(j);
                parentNode.connectChild(j + 1, temp);
            }
            parentNode.connectChild(itemIndex + 1, newNode); // connect newRight to parent
        }
        
    }
        
}
