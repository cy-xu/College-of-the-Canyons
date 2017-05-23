/*
 * Andriy Korsun
 * Professor Ferguson
 * Comp Sci 282, Project 2
 * 11/10/2015
 * 234 Trees --> B-Trees
 */
package tree234app;

////////////////////////////////////////////////////////////////

class DataItem

   {

   public long dData;          
   String record;                
   public DataItem(long dd)    

      { dData = dd; }



   public void displayItem()   

      { System.out.print("/"+dData); }

//--------------------------------------------------------------
   
   public void setRecord(String rec)  
   {
       record = rec;
   }

//--------------------------------------------------------------
   
   
   public String getRecord() // get the record
   {
   
       return record;
   
   }
   
//--------------------------------------------------------------

   }  
