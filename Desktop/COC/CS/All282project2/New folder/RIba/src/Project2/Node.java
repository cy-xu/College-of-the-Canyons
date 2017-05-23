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

public class Node {
private static int ORDER = 4;
private int numItems;
private Node parent;
private Node childArray[] = new Node[ORDER];
private DataItem itemArray[] = new DataItem[ORDER-1];
// -------------------------------------------------------------


// set node order
public static void setOrder(int order) {
ORDER = order;
}

//get node order
public static int getOrder() {
    return ORDER;
}


// connect child to this node
public void connectChild(int childNum, Node child) {
childArray[childNum] = child;
if(child != null)
child.parent = this;
}
// -------------------------------------------------------------
// disconnect child from this node, return it
public Node disconnectChild(int childNum)
{
Node tempNode = childArray[childNum];
childArray[childNum] = null;
return tempNode;
}
// -------------------------------------------------------------
public Node getChild(int childNum)
{ return childArray[childNum]; }
// -------------------------------------------------------------
public Node getParent()
{ return parent; }
// -------------------------------------------------------------
public boolean isLeaf()
{ return (childArray[0]==null) ? true : false; }
// -------------------------------------------------------------
public int getNumItems()
{ return numItems; }
// -------------------------------------------------------------
public DataItem getItem(int index) // get DataItem at index
{ return itemArray[index]; }
// -------------------------------------------------------------
public boolean isFull()
{ return (numItems==ORDER-1) ? true : false; }
// -------------------------------------------------------------
public int findItem(long key) // return index of
{ // item (within node)
for(int j=0; j<ORDER-1; j++) // if found,
{ // otherwise,
if(itemArray[j] == null) // return -1
break;
else if(itemArray[j].dData == key)
return j;
}
return -1;
} // end findItem
// -------------------------------------------------------------
public int insertItem(DataItem newItem)
{
// assumes node is not full
numItems++; // will add new item
long newKey = newItem.dData; // key of new item
for(int j=ORDER-2; j>=0; j--) // start on right,
{ // examine items
if(itemArray[j] == null) // if item null,
continue; // go left one cell
else // not null,
{ // get its key
long itsKey = itemArray[j].dData;
if(newKey < itsKey) // if it's bigger
itemArray[j+1] = itemArray[j]; // shift it right
else
{
itemArray[j+1] = newItem; // insert new item
return j+1; // return index to
} // new item
} // end else (not null)
} // end for // shifted all items,
itemArray[0] = newItem; // insert new item
return 0;
} // end insertItem()
// -------------------------------------------------------------
public DataItem removeItem() // remove largest item
{
// assumes node not empty
DataItem temp = itemArray[numItems-1]; // save item
itemArray[numItems-1] = null; // disconnect it
numItems--; // one less item
return temp; // return item
}
// -------------------------------------------------------------
public void displayNode() // format "/24/56/74/"
{
for(int j=0; j<numItems; j++)
itemArray[j].displayItem(); // "/56"
System.out.println("/"); // final "/"
}
// -------------------------------------------------------------
} // end class Node

