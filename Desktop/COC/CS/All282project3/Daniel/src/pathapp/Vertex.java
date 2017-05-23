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
class Vertex
   {
   public char label;        // label (e.g. 'A')
   public boolean isInTree;
// -------------------------------------------------------------
   public Vertex(char lab)   // constructor
      {
      label = lab;
      isInTree = false;
      }
// -------------------------------------------------------------
   }  // end class Vertex
////////////////////////////////////////////////////////////////
