/* 
Computer Science 282: Advanced Data Structures.
Fall:2015
Professor: Chris Ferguson
Programmer: Luis Riba 
Project : Project3
Description: 


*/

package Project3;
import java.io.Serializable;
public class Vertex implements Serializable {
public char label;        // label (e.g. 'A')
public boolean isInTree;
// -------------------------------------------------------------
public Vertex(char lab)  { // constructor
label = lab;
isInTree = false;
}
// -------------------------------------------------------------
}  // end class Vertex
