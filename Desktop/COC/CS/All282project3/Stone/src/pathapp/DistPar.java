/*
 * NAME: Nicole Stone
 * Date: 11/18/15
 * Project: Project 3 - Weighted Graphs
 * Description: 
 * Code from book to create objects that contain the distance between two vertices
 * 
 */
package pathapp;

/**
 *
 * @author Nicole
 */
public class DistPar implements java.io.Serializable { // distance and parent
    // items stored in sPath array

    public int distance;   // distance from start to this vertex
    public int parentVert; // current parent of this vertex
// -------------------------------------------------------------

    public DistPar(int pv, int d) // constructor
    {
        distance = d;
        parentVert = pv;
    }
// -------------------------------------------------------------
    public int getParent() {
        return this.parentVert;
    }
}  // end class DistPar
