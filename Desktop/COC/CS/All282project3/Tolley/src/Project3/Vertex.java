package Project3;
/*
 * COMP 282-17867
 * Project 3: Vertex
 * Programmer: Alexander Tolley
 * Date last edited: 12/03/2015
 * Description: This class represents a Vertex object. It contains its letter 
 *              label and a boolean to see if it is in the tree.
 */
import java.io.Serializable;
public class Vertex implements Serializable
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