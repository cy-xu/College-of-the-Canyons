//John Pinson
//December 3rd, 2015
//CS 282 advanced Data Structures
//Project Description: Project 3
//DistPar class

package ProgrammingProject3;

public class DistPar             // distance and parent
{                      // items stored in sPath array

    public int distance;   // distance from start to this vertex
    public int parentVert; // current parent of this vertex
// -------------------------------------------------------------

    public DistPar(int pv, int d)  // constructor
    {
        distance = d;
        parentVert = pv;
    }
// -------------------------------------------------------------
}  // end class DistPar
