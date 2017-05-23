//Megan Meyers
//11/15/15
//class 282 project 2
//Data item class. methods for creating and working with data item objects. 



class DataItem
   {
   public long dData;          // one data item
   public String record;       // entire record
//--------------------------------------------------------------
   
   public DataItem(long dd)    // constructor
      { dData = dd; }
//--------------------------------------------------------------
   public void displayItem()   // display item, format "/27"
      { System.out.print("/"+dData); }
//--------------------------------------------------------------
   public void setRecord(String record)  {
      this.record = record;           
   }
//--------------------------------------------------------------   
   public String getRecord(){
       return record;
   }
//--------------------------------------------------------------
   
   
   }  // end class DataItem
////////////////////////////////////////////////////////////////