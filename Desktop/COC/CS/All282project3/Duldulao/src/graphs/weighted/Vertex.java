/*
 * Programmer: Aaron Duldulao
 * CMPSCI282 - Advanced Data Structure
 * Project 3
 * Date last modified: 11/30/2015
 * Description: This is a class for a vertex of a graph
 */
package graphs.weighted;

public class Vertex
{
   public char label;        // label (e.g. 'A')
   public boolean isInTree;

   public Vertex(char lab)   // constructor
   {
      label = lab;
      isInTree = false;
   }
}  // end class Vertex
