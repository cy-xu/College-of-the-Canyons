/*
 * NAME: Nicole Stone
 * Date: 11/18/15
 * Project: Project 3 - Weighted Graphs
 * Description: 
 * Code from book to create vertex objects
 * 
 */
package pathapp;

/**
 *
 * @author Nicole
 */
public class Vertex implements java.io.Serializable {

    public char label;        // label (e.g. 'A')
    public boolean isInTree;
// -------------------------------------------------------------

    public Vertex(char lab) // constructor
    {
        label = lab;
        isInTree = false;
    }
// -------------------------------------------------------------
}  // end class Vertex
