/*
Brian Dimaculangan
November 17, 2015
CS282 Advanced Data Structures Project 1
Description: This class contains the key held within the Node.
 */

public class DataItem 
{
 
    public long dData;          // one data item
   
    public DataItem(long dd)    // constructor
    { 
        dData = dd; 
    }

    public void displayItem()   // display item, format "/27"
    { 
        System.out.print("/"+dData); 
    }
}
