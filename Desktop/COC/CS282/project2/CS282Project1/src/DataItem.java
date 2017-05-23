/*
 * Kevin Ponek
 * November 10, 2015
 * CS 282 Advanced Data Structures Project 2
 * Description: DataItem.java represents each item within the tree.  It has been revised to include the 'record' variable to
 * 	keep track of the file data that each DataItem is composed of.
 */
import java.io.*;

public class DataItem
 
   {
	private String record;
   public long dData;          // one data item
 
//--------------------------------------------------------------
 
   public DataItem(long dd)    // constructor
 
      { dData = dd; }
 
//--------------------------------------------------------------
 
   public void displayItem()   // display item, format "/27"
 
      { System.out.print("/"+dData); }
   
   public void setRecord(String r){
	   record = r;
   }
   public String getRecord(){
	   return record;
   }
   
//--------------------------------------------------------------
 
   }  // end class DataItem