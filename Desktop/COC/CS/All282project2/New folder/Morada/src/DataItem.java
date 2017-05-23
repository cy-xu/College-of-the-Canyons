//DataItem code from book.

public class DataItem {

    public String record;
    public long dData; // one data item

	// --------------------------------------------------------------
    public DataItem(long dd, String s) // constructor
    {
        dData = dd;
        record = s;
    }

	// --------------------------------------------------------------
    public void displayItem() // display item, format "/27"
    {
        System.out.print("/" + dData);
    }

	// --------------------------------------------------------------
    public String getRecord() {
        return this.record;
    }

    public void setRecord(String s) {
        this.record = s;
    }

}
