/* 
 * Name(Author): Oganes
 * File:   DataItem.java
 *  Date Created: Nov 3, 2015, 11:48:14 PM
 *  Project Name: DataItem
 *  Description: The dDate variable is for the data2.txt file and its for the first part in the DB, the
 * data2.txt has a field for user ID and that is what is passed to the dDataItem constructor.
 */
package projectproadv2;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Oganes
 */
public class DataItem {

    public long dData;          // one data item
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
}
