/* 
 * Author: Aaron Black, based on code by Robert LaFore
 * Course: CmpSci 282
 * Description: DistPar class for use in Graph class, when determining cheapest route.
 *     Unchanged from code provided by Robert LaFore except for addition of Serializable.
 * 
 * Last Modified: 19 November 2015
 */
package pathapp;

import java.io.Serializable;

public class DistPar implements Serializable // distance and parent
{                      // items stored in sPath array

    public int distance;   // distance from start to this vertex
    public int parentVert; // current parent of this vertex
// -------------------------------------------------------------

    public DistPar(int pv, int d) // constructor
    {
        distance = d;
        parentVert = pv;
    }
// -------------------------------------------------------------
}  // end class DistPar
