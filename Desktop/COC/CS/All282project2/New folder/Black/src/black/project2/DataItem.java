/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package black.project2;

/**
 *
 * @author Aaron
 */
////////////////////////////////////////////////////////////////
class DataItem {

    public long dData;          // one data item
    public String record;

//--------------------------------------------------------------
    public DataItem(long dd) // constructor
    {
        dData = dd;
    }
    
    public DataItem(long dd, String rec) {
        dData = dd;
        record = rec;
    }

//--------------------------------------------------------------
    public void displayItem() // display item, format "/27"
    {
        System.out.print("/" + dData);
    }
    
    public String getRecord() {
        return record;
    }
    
    public void setRecord(String s) {
        record = s;
    }

//--------------------------------------------------------------
}  // end class DataItem

