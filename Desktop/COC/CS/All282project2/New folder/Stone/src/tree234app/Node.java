/*
 * NAME: Nicole Stone
 * Date: 10/20/15
 * Project: Project 2 - 234 Trees & B Trees
 * Description: 
 * You will need to add a static method setOrder() to the Node class and call this method BEFORE you create a new tree object. 
 * When the user enters an ORDER equal to 4 a new Tree234 object is created, when the ORDER is 5 or larger a new BTree object is created. 
 * Reuse the variable that references the tree object created at the top of the main method. DO NOT declare a new reference variable. 
 */

package tree234app;

/**
 *
 * @author Nicole
 */
public class Node {

    protected static int ORDER = 4;

    private int numItems;

    private Node parent;

    private Node childArray[] = new Node[ORDER];

    private DataItem itemArray[] = new DataItem[ORDER - 1];

// -------------------------------------------------------------
   // connect child to this node
    public void connectChild(int childNum, Node child) {

        childArray[childNum] = child;

        if (child != null) {
            child.parent = this;
        }

    }

// -------------------------------------------------------------
   // disconnect child from this node, return it
    public Node disconnectChild(int childNum) {

        Node tempNode = childArray[childNum];

        childArray[childNum] = null;

        return tempNode;

    }

// -------------------------------------------------------------
    public Node getChild(int childNum) {
        return childArray[childNum];
    }

// -------------------------------------------------------------
    public Node getParent() {
        return parent;
    }

// -------------------------------------------------------------
    public boolean isLeaf() {
        return (childArray[0] == null);
    }

// -------------------------------------------------------------
    public int getNumItems() {
        return numItems;
    }

// -------------------------------------------------------------
    public DataItem getItem(int index) // get DataItem at index
    {
        return itemArray[index];
    }

// -------------------------------------------------------------
    static int getOrder() {
        return ORDER;
    }
    
// -------------------------------------------------------------
    static void setOrder(int num) {
        if (num > 4 && num < 11) {
            ORDER = num;
        }
    }

// -------------------------------------------------------------
    public boolean isFull() {
        return (numItems == ORDER - 1) ? true : false;
    }

// -------------------------------------------------------------
    public int findItem(long key) // return index of
    {                                    // item (within node)

        for (int j = 0; j < ORDER - 1; j++) // if found,
        {                                 // otherwise,

            if (itemArray[j] == null) // return -1
            {
                break;
            } else if (itemArray[j].dData == key) {
                return j;
            }

        }

        return -1;

    }  // end findItem

// -------------------------------------------------------------
    public int insertItem(DataItem newItem) {

      // assumes node is not full
        numItems++;                          // will add new item

        long newKey = newItem.dData;         // key of new item

        for (int j = ORDER - 2; j >= 0; j--) // start on right,
        {                                 //    examine items

            if (itemArray[j] == null) // if item null,
            {
                continue;                      // go left one cell
            } else // not null,
            {                              // get its key

                long itsKey = itemArray[j].dData;

                if (newKey < itsKey) // if it's bigger
                {
                    itemArray[j + 1] = itemArray[j]; // shift it right
                } else {

                    itemArray[j + 1] = newItem;   // insert new item

                    return j + 1;                 // return index to

                }                           //    new item

            }  // end else (not null)

        }  // end for                     // shifted all items,

        itemArray[0] = newItem;              // insert new item

        return 0;

    }  // end insertItem()

// -------------------------------------------------------------
    public DataItem removeItem() // remove largest item
    {

      // assumes node not empty
        DataItem temp = itemArray[numItems - 1];  // save item

        itemArray[numItems - 1] = null;           // disconnect it

        numItems--;                             // one less item

        return temp;                            // return item

    }

// -------------------------------------------------------------
    public void displayNode() // format "/24/56/74/"
    {

        for (int j = 0; j < numItems; j++) {
            itemArray[j].displayItem();   // "/56"
        }
        System.out.println("/");         // final "/"

    }

// -------------------------------------------------------------
}  // end class Node
