/*
 * COMP 282-17867 - Advanced Data Structures
 * Project 2: DataItem
 * Programmer: Alexander Tolley
 * Date last edited: 11/16/2015
 * Description: This class describes the data that is to be stored inside the nodes of the tree.
 */
public class DataItem {

    public long dData;          // one data item
    public String record;       //String to store the record.

//--------------------------------------------------------------
    public DataItem(long dd) // constructor
    {
        dData = dd;
        record = "";            //Insert blank string if no record is sent.
    }

//--------------------------------------------------------------
    public DataItem(long dd, String rec){   //Override constructer that takes a long and a String and constructs a DataItem object with them.
        dData = dd;
        record = rec;
    }
//--------------------------------------------------------------
    public void displayItem() // display item, format "/27"
    {
        System.out.print("/" + dData);
        //System.out.println(record);
    }
//--------------------------------------------------------------
    public void setRecord(String newRecord) //Method that allows the record to be set.
    {
        record = newRecord;
    }
//--------------------------------------------------------------
    public String getRecord()   //Method that returns the record.
    {
        return record;
    }
}  // end class DataItem
 
////////////////////////////////////////////////////////////////