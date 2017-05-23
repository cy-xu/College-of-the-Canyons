/*
Computer Science 282: Advanced Data Structures.
Fall:2015
Professor: Chris Ferguson
Programmer: Luis Riba 
Project : Project2
Description: 
Programming Project #2 – 234 Trees and B Trees (10 Points)
For this project, we are going to start with code from the textbook and build on top of it.
In chapter 10 there is a fully functional 234 Tree program example, but it has several limitations. 
It does not store the tree to a disk drive and it does not support building B-Trees. 
For this project, you will add the disk storage capability, use Inheritance and code to support B-Trees.
Keep in mind, one very important goal of this project. 
Change the existing code from the book as little as possible! Do not rewrite the code. 
Develop the code as a new 'layer' of code. Use OOP Inheritance to build new classes from the existing classes. 
For example, when you add BTree support, write a new split() method in the new derived class, DO NOT modify the old one. 
In fact, keep it as part of the code so the program will support BOTH a BTree and a 234 Tree.

*/

package Project2;
public class BTree extends Tree234 {
	
public void split(Node thisNode) {// split the node
// assumes node is full
Node parent = null;
int itemIndex=0;
// items to move
int order = Node.getOrder();
int m = order/2;
DataItem[] items = new DataItem[m];
Node[] childs = new Node[m];
// remove last items from this node
for(int i=m-1;i>=0;i--) {
items[i] = thisNode.removeItem(); 
}
// remove children from this node
int k = order-m;
for(int i=0;i<m;i++,k++) {
childs[i] = thisNode.disconnectChild(k); 
}
Node newRight = new Node(); // make new node
if(thisNode==root) {// if this is the root,
root = new Node(); // make new root
parent = root; // root is our parent
root.connectChild(0, thisNode); // connect to parent
}
else // this node not the root
parent = thisNode.getParent(); // get parent	
// deal with parent
int n = 0;
itemIndex = parent.insertItem(items[0]); // item B to parent
n = parent.getNumItems(); // total items?
// move parent's connections
for(int j=n-1; j>itemIndex; j--) {
Node temp = parent.disconnectChild(j); // one child
parent.connectChild(j+1, temp); // to the right
}
// connect newRight to parent
parent.connectChild(itemIndex+1, newRight);
// deal with newRight
for(int i=1;i<m;i++) {
newRight.insertItem(items[i]); // item C to newRight
}
	
//  connect to 0 to m on newRight 
for(int i=0;i<m;i++) {
newRight.connectChild(i, childs[i]);
}
} // end split()

}

