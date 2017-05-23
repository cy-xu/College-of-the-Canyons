/*
 * Kevin Ponek
 * December 3, 2015
 * CS 282 Advanced Data Structures Project 3
 * Description: PathApp.java is designed to act as the user interface to access/change data in the graph.
 * It has working options to change the edge weight (if it is existing), add an edge (if it does not exist),
 * delete an edge (if it is existing), find the path from A to the chosen vertex, write a graph to memory,
 * read the graph from memory, and quit the interface.
 * 	
 */
import java.io.*;

public class PathApp{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1, 50); // AB 50
		theGraph.addEdge(0, 3, 80); // AD 80
		theGraph.addEdge(1, 2, 60); // BC 60
		theGraph.addEdge(1, 3, 90); // BD 90
		theGraph.addEdge(2, 4, 40); // CE 40
		theGraph.addEdge(3, 2, 20); // DC 20
		theGraph.addEdge(3, 4, 70); // DE 70
		theGraph.addEdge(4, 1, 50); // EB 50
		System.out.println("Shortest paths");
		theGraph.path(); // shortest paths
		System.out.println();

		// menu for user to navigate
		whileloop: // tracks the 'q'uit command break
		while (true) {
			System.out.print("Enter first letter of ");

			System.out.print("['c']hange edge weight, ['a']dd edge, ['d']elete edge, ['f']ind path(s), ['w']rite graph, ['r']ead graph, or ['q']uit: ");

			char choice = getChar();

			switch (choice)

			{
			// change an edge weight
			case 'c':
				System.out.println("Please enter \"from\" vertex:");
				char fromVertex = getChar();// starting point in character
				int fromIntVertex = vertexCharToInt(fromVertex);//starting point in integer
				System.out.println("Please enter \"to\" vertex:");
				char toVertex = getChar();// ending point in character
				int toIntVertex = vertexCharToInt(toVertex);//ending point in integer
				System.out.println("Please enter new weight:");
				int newWeight = getInt();// new weight value
				//if vertices are valid values and the edge exists (not equal to INFINITY)
				if ( (fromIntVertex <= 4 && fromIntVertex >= 0) && 
						(toIntVertex <= 4 && toIntVertex >= 0) && 
						(theGraph.getWeight(fromIntVertex, toIntVertex) != 1000000) ){
					theGraph.addEdge(fromIntVertex, toIntVertex, newWeight);
				}
				else System.out.println("Error changing weight: not a valid vertex or edge does not exist");
				theGraph.path();
				break;
			// add an edge
			case 'a':
				System.out.println("Please enter \"from\" vertex:");
				char fromVertx = getChar();// starting point in character
				int fromIntVertx = vertexCharToInt(fromVertx);//starting point in integer
				System.out.println("Please enter \"to\" vertex:");
				char toVertx = getChar();// ending point in character
				int toIntVertx = vertexCharToInt(toVertx);//ending point in integer
				System.out.println("Please enter a weight:");
				int newWeigh = getInt();// weight value
				//if vertices are valid values and the edge does NOT exist
				if ( (fromIntVertx <= 4 && fromIntVertx >= 0) && 
						(toIntVertx <= 4 && toIntVertx >= 0) && 
						(theGraph.getWeight(fromIntVertx, toIntVertx) == 1000000) ){
					theGraph.addEdge(fromIntVertx, toIntVertx, newWeigh);
				}
				else System.out.println("Error changing weight: not a valid vertex or edge already exists");
				theGraph.path();
				break;
			// delete an edge
			case 'd':
				System.out.println("Please enter \"from\" vertex:");
				char fromVertd = getChar();// starting point in character
				int fromIntVertd = vertexCharToInt(fromVertd);//starting point in integer
				System.out.println("Please enter \"to\" vertex:");
				char toVertd = getChar();// ending point in character
				int toIntVertd = vertexCharToInt(toVertd);//ending point in integer
				if ( (fromIntVertd <= 4 && fromIntVertd >= 0) && 
						(toIntVertd <= 4 && toIntVertd >= 0) && 
						(theGraph.getWeight(fromIntVertd, toIntVertd) != 1000000) ){
					theGraph.addEdge(fromIntVertd, toIntVertd, 1000000);
				}
				else System.out.println("Error changing weight: not a valid vertex or edge does not exist");
				theGraph.path();
				break;
			// find the path from the chosen vertex
			case 'f':
				System.out.println("Which vertex do you wish to find?");
				char charVert = getChar();
				int intVert = vertexCharToInt(charVert);
				DistPar[] shortestPaths = theGraph.getSPath();
				int index = 0;//index to navigate path array. Slot 0 will be intVert.
				char[] path = {' ',' ',' ',' ',' '};//order of the path
				path[index] = vertexIntToChar(intVert);
				index++;
				//store values for the path array in order visited
				findloop:
				while (true){
					intVert = shortestPaths[intVert].parentVert;
					path[index] = vertexIntToChar(intVert);
					index++;
					if(intVert == 0) break findloop;
				}
				for (int i = path.length - 1; i >= 0; i--){
					if (path[i] != ' '){
						System.out.print(path[i]);
					}
					if (path[i] != ' ' && i != 0)
						System.out.print(" to ");
				}
				System.out.println();//adds space to make menu appear on next line after
				break;
				//write the graph to memory
			case 'w':
				System.out.println("What is the name of the file to write to?");
				String writeName = getString();
				File f = new File(writeName);
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(theGraph);
				break;
				//read a graph from memory
			case 'r':
				System.out.println("What is the name of the file to read from?");
				String readName = getString();
				File fi = new File(readName);
				FileInputStream fis = new FileInputStream(fi);
				ObjectInputStream ois = new ObjectInputStream(fis);
				theGraph = (Graph) ois.readObject();
				theGraph.path();
				break;
			// quit the menu and exit loop
			case 'q':

				System.out.println("Exiting program.");
				break whileloop;
			// catch for input that does not match
			default:
				System.out.print("Invalid entry\n");
			}
		}
	} // end main()
		// --------------------------------------------------------------

	public static String getString() throws IOException

	{

		InputStreamReader isr = new InputStreamReader(System.in);

		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();

		return s;

	}

	// --------------------------------------------------------------

	public static char getChar() throws IOException

	{

		String s = getString();

		return s.charAt(0);

	}

	// -------------------------------------------------------------

	public static int getInt() throws IOException

	{

		String s = getString();

		return Integer.parseInt(s);

	}
	//change character vertex value to integer
	public static int vertexCharToInt(char c){
		char ch = Character.toUpperCase(c);
		char[] charValues = {'A','B','C','D','E'};
		for (int i = 0; i < charValues.length;i++){
			if (ch==charValues[i]) return (i);
		}
		return -1;
	}
	//change integer vertex value to character
	public static char vertexIntToChar(int i){
		char[] charValues = {'A','B','C','D','E'};
		if (i >= 0 && i < 5) return charValues[i];
		else return 'z';//not a valid value
	}
} // end class PathApp
	////////////////////////////////////////////////////////////////