/* 
Computer Science 282: Advanced Data Structures.
Fall:2015
Professor: Chris Ferguson
Programmer: Luis Riba 
Project : Project2
Description: 
Programming Project #2 – 234 Trees and B Trees (10 Points)
For this project, we are going to start with code from the textbook and build on top of it.
In chapter 10 there is a fully functional 234 Tree program example, but it has several limitations. 
It does not store the tree to a disk drive and it does not support building B-Trees. 
For this project, you will add the disk storage capability, use Inheritance and code to support B-Trees.
Keep in mind, one very important goal of this project. 
Change the existing code from the book as little as possible! Do not rewrite the code. 
Develop the code as a new 'layer' of code. Use OOP Inheritance to build new classes from the existing classes. 
For example, when you add BTree support, write a new split() method in the new derived class, DO NOT modify the old one. 
In fact, keep it as part of the code so the program will support BOTH a BTree and a 234 Tree.

*/






package Project2;

/**
 *
 * @author luisriba
 */
////////////////////////////////////////////////////////////////
public class DataItem
{
public long dData; // one data item
public String record="";

public DataItem(long dd){ // constructor 
dData = dd;
}

//--------------------------------------------------------------
public DataItem(long dd, String rec) {// constructor 
dData = dd;
record = rec;
}
//--------------------------------------------------------------
public void displayItem() {// display item, format "/27"
System.out.print("/"+dData); 
}

 // return the record
public String getRecord() {
	return record;
}

 // the record to set
public void setRecord(String record) {
	this.record = record;
}


//--------------------------------------------------------------
} // end class DataItem
////////////////////////////////////////////////////////////////
