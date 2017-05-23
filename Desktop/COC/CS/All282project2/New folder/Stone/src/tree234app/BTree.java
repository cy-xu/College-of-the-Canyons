/*
 * NAME: Nicole Stone
 * Date: 10/20/15
 * Project: Project 2 - BTree Class
 * Description: 
 Since the BTree class inherits from Tree234 you can assign a BTree object to a variable of type Tree234.

 After you test your code with the 'old' split() method it is time to modify the 'new' split() method in the class BTree to behave more like a BTree split. 
 It is enough, to make the Btree split() move multiple items (and their child references) to the new node. 
 The larger the ORDER, the more items need to move.

 You do not need to change the split node algorithm to go 'bottom' up. Go ahead and split the nodes on the way down just like with a 234 tree.

 You do not need to insert the item BEFORE the spilt. Go ahead and insert the item AFTER the split just like with a 234 tree.
 Of the three major differences between the 234 and BTree split(), 
 the only one you need to implement is moving multiple items (and their child references) to the new node.

 For example, when ORDER = 4, there will be 3 items in the node when a split occurs: A B C
 In this case, Tree234 split must move one item ( C ) to the new node

 For example, when ORDER = 6, there will be 5 items in the node when a split occurs: A A B C C
 In this case, Btree split must move two items ( C C ) to the new node

 For example, when ORDER = 7, there will be 6 items in the node when a split occurs: A A A B C C
 In this case, Btree split must move two items ( C C ) to the new node

 For example, when ORDER = 8, there will be 7 items in the node when a split occurs: A A A B C C C
 In this case, Btree split must move three items ( C C C ) to the new node

 You will need to calculate the number of items to MOVE, based on the ORDER of the tree. 
 Do not hard code values like 8 or 7 or 3 in your code, do the simple math. Be sure to TEST! 
 Populate the tree with items so it is just before or just after the split. 
 You do NOT want to have to insert a bunch of items to get to the split. 

 Add print statements so it displays the number of item and values it will move. 
 Obviously, when you move items to the new Node, plus one child references should move with the items. 
 If you move three items ( C C C ) to the new Node, four child references move with those three items.
 */
package tree234app;

/**
 *
 * @author Nicole
 */
public class BTree extends Tree234 {
    /*Add a new '.java' file to your project, in that file create a new class named 'BTree' using inheritance to create it from the class 'Tree234'. 
     Copy and paste the split() method from the parent class to the child class. Got that? There will be two split() methods! 
     You may change the 'root' access permission to protected, but DO NOT change it to public. */

    @Override
    public void split(Node thisNode) // split the node
    {

        // assumes node is full
        DataItem itemB, itemC;

        Node parent, child2, child3;
        Node newRight = new Node();

        int itemIndex;

        for (int j = 0; (j < Node.ORDER / 2 - 1); j++)
        {
            newRight.insertItem(thisNode.removeItem());  // remove items from
        }
        itemB = thisNode.removeItem();    // this node


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

        for (int i = 0; i < Node.ORDER/2; i++) {
            newRight.connectChild(i, thisNode.disconnectChild((Node.ORDER +1)/2 + i));
        }
    }  // end split()
}
