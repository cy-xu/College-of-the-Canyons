/*
 Jason Daniel
 compsci 282 Project#3
 11-27-2015
 demonstrates shortest path with weighted, directed graphs of a computer network
 */
package pathapp;

/**
 *
 * @author Jason
 */
class DistPar             // distance and parent
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
///////////////////////////////////////////////////////////////