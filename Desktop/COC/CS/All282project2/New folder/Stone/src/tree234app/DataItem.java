/*
 * NAME: Nicole Stone
 * Date: 10/20/15
 * Project: Project 2 - 234 Trees & B Trees
 * Description: 
 * Class is used to congregate data for a single node. 
 * Each DataItem will contain 2 variables, dData and a string with the enitire record. 
 * When you read the file and create each DataItem object, both values must be set.
 */
package tree234app;

/**
 *
 * @author Nicole
 */
public class DataItem {

    public long dData;  // one data item
    private String record;

    public String getRecord() {
        return this.record;
    }
//-------------------------------------------------------------
    public void setRecord(String newRecord) {
        this.record = newRecord;
    }
//--------------------------------------------------------------
    public DataItem(long dd) // constructor
    {
        dData = dd;
    }

//--------------------------------------------------------------
    public void displayItem() // display item, format "/27"
    {
        System.out.print("/" + dData);
    }

//--------------------------------------------------------------
}  // end class DataItem

