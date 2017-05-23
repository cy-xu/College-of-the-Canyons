/* 
Computer Science 282: Advanced Data Structures.
Fall:2015
Professor: Chris Ferguson
Programmer: Luis Riba 
Project : Project3
Description: Diskstra, weighted graph

*/


package Project3;
import java.io.Serializable;
public class DistPar implements Serializable {         // distance and parent
                          // items stored in sPath array
   public int distance;   // distance from start to this vertex
   public int parentVert; // current parent of this vertex
// -------------------------------------------------------------
   public DistPar(int pv, int d){  // constructor
   distance = d;
   parentVert = pv;
      }
// -------------------------------------------------------------
   }  // end class DistPar

