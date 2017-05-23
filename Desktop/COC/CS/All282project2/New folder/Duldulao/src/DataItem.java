/*
 * Programmer: Aaron Duldulao
 * CMPSCI282 - Advanced Data Structure
 * Project 2
 * Date last modified: 11/16/2015
 * Description: This is a class for a data item of a tree data structure
 */

public class DataItem {
    
   public long dData;          // one data item
   public String record;
 
   public DataItem(long dd)    // constructor
   { 
       dData = dd; 
   }
   
   public DataItem(long dd, String rec)
   {
       dData = dd;
       record = rec;
   }
 
   public void displayItem()   // display item, format "/27"
   { 
       System.out.print("/"+dData); 
   }
   
   public void setRecord(String rec)
   {
       record = rec;
   }
   
   public String getRecord()
   {
       return record;
   }
}
