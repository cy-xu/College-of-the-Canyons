package tree234app;

/*
 * @author Nicole Garcia
 * November 11, 2015
 * CS 282 Lab Project #2 
 */

public class DataItem {
    public long dData;          // one data item
//--------------------------------------------------------------

    public DataItem(long dd) { // constructor
        dData = dd;
    }
//--------------------------------------------------------------

    public void displayItem() { // display item, format "/27"
        System.out.print("/" + dData);
    }
//--------------------------------------------------------------
}  // end class DataItem
