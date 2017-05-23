/*
 * Programmer: Aaron Duldulao
 * CMPSCI282 - Advanced Data Structure
 * Project 3
 * Date last modified: 11/30/2015
 * Description: This is a class for distance and parent of a vertex
 */
package graphs.weighted;

public class DistPar           // distance and parent
{                      // items stored in sPath array
    public int distance;   // distance from start to this vertex
    public int parentVert; // current parent of this vertex

    public DistPar(int pv, int d)  // constructor
    {
        distance = d;
        parentVert = pv;
    }
}  // end class DistPar
