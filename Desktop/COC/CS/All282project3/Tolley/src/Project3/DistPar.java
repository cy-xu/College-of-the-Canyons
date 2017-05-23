package Project3;
/*
 * COMP 282-17867
 * Project 3: DistPar
 * Programmer: Alexander Tolley
 * Date last edited: 12/03/2015
 * Description: This class represent the DistPar object. It contains the data 
 *              for the shortest path through the graph, with the distance from 
 *              the starting vertex to the end vertex and the parent of the 
 *              current vertex.
 */
import java.io.Serializable;
public class DistPar implements Serializable            // distance and parent
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