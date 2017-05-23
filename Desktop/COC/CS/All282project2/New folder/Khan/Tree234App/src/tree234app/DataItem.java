/*
 * Israr Khan
 * project 2
 * 11/17/15
 */
package tree234app;

/**
 *
 * @author Student-HSLH133
 */
import java.io.*;
public class DataItem {
     public long dData;          // one data item
 
//--------------------------------------------------------------
 
   public DataItem(long dd)    // constructor
 
      { dData = dd; }
 
//--------------------------------------------------------------
 
   public void displayItem()   // display item, format "/27"
 
      { System.out.print("/"+dData); }
 
}
