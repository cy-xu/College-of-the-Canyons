/*Gianni Lane
 * Dec 2, 2015 
 * CS 282 Lab Project
 * stores the character reperesenting the vertex and whether or not it is in the tree
 */
package graph;


public class Vertex
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