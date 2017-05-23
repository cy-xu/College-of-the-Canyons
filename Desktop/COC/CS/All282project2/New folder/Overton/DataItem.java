
public class DataItem{
	
   public long dData;          		   // one data item
   public String record;			   // record
   
   public DataItem(long dd){
	   dData = dd;
   }
 
   public void displayItem(){  		   // display item, format "/27"
	   System.out.print("/"+dData);
   }
   
   public void setRecord(String record){
	   this.record = record;
   }
   
   public String getRecord(){
	   return this.record;
   }
} 
 