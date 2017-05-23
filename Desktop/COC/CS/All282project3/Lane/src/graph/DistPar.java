/*Gianni Lane
 * Dec 2, 2015 
 * CS 282 Lab Project
 * stores distance to vertex, and the parent pertex
 */
package graph;

////////////////////////////////////////////////////////////////
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