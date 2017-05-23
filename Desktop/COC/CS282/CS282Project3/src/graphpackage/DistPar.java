package graphpackage;

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
	///////////////////////////////////////////////////////////////