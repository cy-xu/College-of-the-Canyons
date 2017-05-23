/* 
 * Author: Aaron Black, based on code by Robert LaFore
 * Course: CmpSci 282
 * Description: Vertex class for use in Graph class. Unchanged from code provided by
 *     Robert LaFore except for addition of Serializable.
 * 
 * Last Modified: 19 November 2015
 */
package pathapp;

import java.io.Serializable;

public class Vertex implements Serializable {

    public char label;        // label (e.g. 'A')
    public boolean isInTree;
// -------------------------------------------------------------

    public Vertex(char lab) // constructor
    {
        label = lab;
        isInTree = false;
    }
// -------------------------------------------------------------
}  // end class Vertex
