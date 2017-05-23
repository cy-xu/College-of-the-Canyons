class DataItem {

    public long dData; // one data item

    public String getdString() {
        return dString;
    }

    public void setdString(String dString) {
        this.dString = dString;
    }

    public String dString; // one string item to store an entire record

    // --------------------------------------------------------------
    public DataItem(long dd) // constructor
    {
        dData = dd;
    }

    // --------------------------------------------------------------
    public void displayItem() // display item, format “/27”
    {
        System.out.print(" / " + dData);
    }
    // --------------------------------------------------------------
} // end class DataItem
// //////////////////////////////////////////////////////////////