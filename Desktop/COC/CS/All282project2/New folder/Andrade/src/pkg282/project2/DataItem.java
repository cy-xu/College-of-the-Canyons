/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg282.project2;

/**
 *
 * @author Monica
 */



public class DataItem {
    
    String record;
    
    public long dData;          // one data item
 
//--------------------------------------------------------------
 
   public DataItem(long dd)    // constructor
 
      { dData = dd; }
 
//--------------------------------------------------------------
 
   public void displayItem()   // display item, format "/27"
 
      { System.out.print("/"+dData); }
 
//--------------------------------------------------------------

   public String getRecord(){
       
       return record;
   }

   public void setRecord(String rec){
       
       this.record = rec;
   }


   public readData(){
       return
   }
}
