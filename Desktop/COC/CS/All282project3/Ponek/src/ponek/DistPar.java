/*
 * Kevin Ponek
 * December 3, 2015
 * CS 282 Advanced Data Structures Project 3
 * Description: DistPar.java is designed to hold data for a link in the graph.  It holds the data for
 * the distance from the start and the parent vertex.
 * 	
 */
import java.io.*;

public class DistPar implements Serializable// distance and parent
{ // items stored in sPath array
	public int distance; // distance from start to this vertex
	public int parentVert; // current parent of this vertex
	// -------------------------------------------------------------

	public DistPar(int pv, int d) // constructor
	{
		distance = d;
		parentVert = pv;
	}
	//returns a string for DistPar - for testing purposes
	public String toString(){
		return "Distance from start: " + distance +"; Parent vert: " + parentVert;
	}
} // end class DistPar
	///////////////////////