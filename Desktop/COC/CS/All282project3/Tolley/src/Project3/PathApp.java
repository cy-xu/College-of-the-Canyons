package Project3;
/*
 * COMP 282-17867
 * Project 3: PathApp
 * Programmer: Alexander Tolley
 * Date last edited: 12/03/2015
 * Description: This is the main class for project 3. It created a graph, 
                adds vertices and edgeds to it, and create a menu-style 
                interface waiting for the user's input. From that menu, the user 
                can change the weight of an edge, add an egde, delete an edge, 
                find the shortest path to a vertex, write the graph to disk, 
                read a graph from disk, and quit the program.
 */

import java.io.*;

public class PathApp {

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');     // 0  (start)
        theGraph.addVertex('B');     // 1
        theGraph.addVertex('C');     // 2
        theGraph.addVertex('D');     // 3
        theGraph.addVertex('E');     // 4

        theGraph.addEdge(0, 1, 50);  // AB 50
        theGraph.addEdge(0, 3, 80);  // AD 80
        theGraph.addEdge(1, 2, 60);  // BC 60
        theGraph.addEdge(1, 3, 90);  // BD 90
        theGraph.addEdge(2, 4, 40);  // CE 40
        theGraph.addEdge(3, 2, 20);  // DC 20
        theGraph.addEdge(3, 4, 70);  // DE 70
        theGraph.addEdge(4, 1, 50);  // EB 50

        char fromVertex, toVertex;
        int fromVertexNum = 0, toVertexNum = 0, newWeight;
        boolean check, loop = true;
        String fileName;

        System.out.println("Shortest Paths:");
        theGraph.path();
        System.out.println("Entries are case sensitive.");
        System.out.println("(C)hange the weight of an edge.");
        System.out.println("(A)dd an edge.");
        System.out.println("(D)elete an edge.");
        System.out.println("(F)ind path(s) from a vertex.");
        System.out.println("(W)rite the graph to a disk file.");
        System.out.println("(R)ead the graph from a disk file");
        System.out.println("(Q)uit the program.");
        while (loop == true) {
            theGraph.pathSansDisplay();
            System.out.print("Command: ");
            switch (UserInput.getChar()) {
                case 'C':
                    System.out.println("Changing weight.");
                    System.out.print("Enter starting vertex: ");
                    fromVertex = UserInput.getChar('A', 'E');
                    fromVertexNum = (int) fromVertex - 65;
                    System.out.println("Enter end vertex: ");
                    toVertex = UserInput.getChar('A', 'E');
                    toVertexNum = (int) toVertex - 65;
                    check = theGraph.checkEdge(fromVertexNum, toVertexNum);
                    if (check == false) {
                        System.out.println("Edge does not exist.");
                        break;
                    }
                    System.out.print("Enter in new weight: ");
                    newWeight = UserInput.getInt();
                    theGraph.addEdge(fromVertexNum, toVertexNum, newWeight);
                    break;
                    
                case 'A':
                    System.out.println("Adding edge.");                    
                    System.out.println("Enter starting vertex: ");
                    fromVertex = UserInput.getChar('A', 'E');
                    fromVertexNum = (int) fromVertex - 65;
                    System.out.println("Enter end vertex: ");
                    toVertex = UserInput.getChar('A', 'E');
                    toVertexNum = (int) toVertex - 65;
                    check = theGraph.checkEdge(fromVertexNum, toVertexNum);
                    if (check == true) {
                        System.out.println("Edge already exists");
                        break;
                    }
                    System.out.println("Enter in weight: ");
                    newWeight = UserInput.getInt();
                    theGraph.addEdge(fromVertexNum, toVertexNum, newWeight);
                    break;
                    
                case 'D':
                    System.out.println("Deleting edge.");
                    System.out.println("Enter starting vertex: ");
                    fromVertex = UserInput.getChar('A', 'E');
                    fromVertexNum = (int) fromVertex - 65;
                    System.out.println("Enter end vertex: ");
                    toVertex = UserInput.getChar('A', 'E');
                    toVertexNum = (int) toVertex - 65;
                    check = theGraph.checkEdge(fromVertexNum, toVertexNum);
                    if (check == false) {
                        System.out.println("Edge does not exist");
                    }
                    theGraph.addEdge(fromVertexNum, toVertexNum, theGraph.INFINITY);
                    System.out.println("Edge Deleted.");
                    break;
                    
                case 'F':
                    System.out.println("Finding path.");
                    System.out.println("Enter in vertex to find path to: ");
                    toVertex = UserInput.getChar('A', 'E');
                    toVertexNum = (int) toVertex - 65;
                    theGraph.findPath(toVertexNum);
                    break;
                    
                case 'W':
                    System.out.print("Enter name of file to save to disk: ");
                    fileName = UserInput.getString();
                    try {
                        serialize(theGraph, fileName);
                    } catch (IOException e) {
                        System.out.println("Unable to Save.");
                    }
                    break;
                    
                case 'R':
                    System.out.print("Enter name of file to open from disk: ");
                    fileName = UserInput.getString();
                    try {
                        theGraph = (Graph) deserialize(fileName);
                    } catch (ClassNotFoundException | IOException e) {
                        System.out.println("File not Found.");
                    }
                    break;
                    
                case 'Q':
                    System.out.println("Quiting Program");
                    loop = false;
                    continue;
                    
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
    }  // end main()

    public static void serialize(Object graph, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(graph);
        fos.close();
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}  // end class PathApp
