package Tree234App;

public class DataItem
{

    public long dData;          // one data item
    private String record;
    
    //--------------------------------------------------------------
    public DataItem(long dd)    // constructor
    {
        dData = dd;
    }
    
    public void setRecord(String record) {
        this.record = record;
    }
    
    public String getRecord() {
        return record;
    }

//--------------------------------------------------------------
    public void displayItem()   // display item, format "/27"

    {
        System.out.print("/" + dData);
    }

//--------------------------------------------------------------
}  // end class DataItem