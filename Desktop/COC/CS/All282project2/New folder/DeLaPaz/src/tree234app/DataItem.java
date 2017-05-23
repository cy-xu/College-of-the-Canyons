
package tree234app;


public class DataItem
 
   {
   public String record; 
 
   public long dData;          // one data item
 
//--------------------------------------------------------------
 
   public DataItem(long dd)    // constructor
 
      { dData = dd; }
 
//--------------------------------------------------------------
 
   public void displayItem()   // display item, format "/27"
 
      { System.out.print("/"+dData); }
   
 public String toString()
 {
  return "" + dData;   
 }
 
 public void set(String filename)
 {
   record = filename;
 }
 
 public String get()
 {
  return record;   
 }
//--------------------------------------------------------------

 
   }  // end class DataItem
 