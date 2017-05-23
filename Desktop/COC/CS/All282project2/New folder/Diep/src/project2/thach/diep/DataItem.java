/*Name: Thach Diep
 *Date: November 16, 2015
 *Description: DataItem class for formating how data items are display
 */
package project2.thach.diep;

import java.io.*;

class DataItem {

    public long dData; // one data item
    public String record;

    public DataItem(long dd) { // constructor
        dData = dd;
    }
    
    public void setRecord(String record){
        this.record = record;
    }
    
    public String getRecord(){
        return record;
    }
    
    public void displayItem() { // display item, format "/27"
        System.out.print("/" + dData);
    }
}  // end class DataItem
