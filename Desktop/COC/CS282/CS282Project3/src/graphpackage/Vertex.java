package graphpackage;

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