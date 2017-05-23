/*
 * Kevin Ponek
 * December 3, 2015
 * CS 282 Advanced Data Structures Project 3
 * Description: Vertex.java is designed to hold data for each vertex (aka node) of the graph.
 * It stores data for the labal (A through E) and a boolean to store if the vertex has been visited.
 * 	
 */
import java.io.*;

public class Vertex implements Serializable{
	public char label; // label (e.g. ‘A’)
	public boolean isInTree;

	// -------------------------------------------------------------
	public Vertex(char lab) // constructor
	{
		label = lab;
		isInTree = false;
	}
	// -------------------------------------------------------------
} // end class Vertex
////////////////////////////////////////////////////////////////