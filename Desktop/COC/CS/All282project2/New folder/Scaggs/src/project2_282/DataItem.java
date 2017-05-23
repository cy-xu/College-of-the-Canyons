package project2_282;
class DataItem{
    public long dData;            // one data item
    public String record;
    //--------------------------------------------------------------
    public DataItem(long dd) {    // constructor
        dData = dd; 
    }
    //--------------------------------------------------------------
    public void displayItem() {   // display item, format "/27"
        System.out.print("/"+dData);
    }
    //--------------------------------------------------------------
    public void setRecord(String r) {
        record = r;
    }
    //--------------------------------------------------------------
    public String getRecord() {
        return record;
    }
    //--------------------------------------------------------------
}  // end class DataItem
////////////////////////////////////////////////////////////////