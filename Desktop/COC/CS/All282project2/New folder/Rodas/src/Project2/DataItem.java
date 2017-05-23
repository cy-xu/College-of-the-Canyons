/*
 * Christian Rodas
 * Project 2
 * CompSci 282
 * 11/16/15
 * Description: DataItem class that constructs the data item and display it.
 */
package Project2;

/**
 *
 * @author Student-HSLH133
 */

public class DataItem {

 
    
    public long dData;          // one data item
 
//--------------------------------------------------------------
 
   public DataItem(long dd)    // constructor
 
      { dData = dd; }
 
//--------------------------------------------------------------
 
   public void displayItem()   // display item, format "/27"
 
      { System.out.print("/"+dData); }
 
//--------------------------------------------------------------
 
   }  // end class DataItem
