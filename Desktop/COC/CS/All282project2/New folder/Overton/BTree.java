
public class BTree extends Tree234 {

	@Override
	public void split(Node thisNode) { // split the node
		// assumes node is full
		DataItem itemRoot = null;
		DataItem item;
		DataItem [] tempItems = new DataItem[Node.getOrder() / 2];
		Node parent;
		Node children = null;
		int itemIndex = 0;
		
		for(int i = Node.getOrder() - 1; i > Node.getOrder() / 2; i--){			// index items to newright 
			if(i == (Node.getOrder() / 2) + 1)									// if middle item
				itemRoot = thisNode.removeItem(); 								// make root and move to parent
			else{
				item = thisNode.removeItem();									// remove item
				children = thisNode.disconnectChild(i);
				tempItems[itemIndex++] = item;									// store in temp items
			}
		}

		Node newRight = new Node(); 											// make new node
		if (thisNode == root) {													// if this is the root,
			root = new Node(); 													// make new root
			parent = root; 														// root is our parent
			root.connectChild(0, thisNode); 									// connect to parent
		} else 																	// this node not the root
			parent = thisNode.getParent(); 										// get parent
		// deal with parent
		itemIndex = parent.insertItem(itemRoot); 								// item B to parent
		int n = parent.getNumItems(); 											// total items?

		for (int j = n - 1; j > itemIndex; j--) { 								// move parent's connections
			Node temp = parent.disconnectChild(j); 								// one child
			parent.connectChild(j + 1, temp); 									// to the right
		}
		parent.connectChild(itemIndex + 1, newRight); 							// connect newRight to parent; deal with newRight
		for(int k = 0; k < tempItems.length && tempItems[k] != null; k++){		// move items to newRight
			newRight.insertItem(tempItems[k]); 									// items to newRight
			newRight.connectChild(k, children);
		}
	}
}