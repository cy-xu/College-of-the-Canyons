/* 
 * Author: Aaron Black, based on code by Robert LaFore
 * Course: CmpSci 282
 * Description: A program that builds on existing directed graph code provided by Robert LaFore.
 *     Adds menu driven capability to add new edges, change existing edge weights, and delete
 *     existing edges. Updates the findPath capability to display actual path to vertex.
 *     Includes options to save graph object to disk via serialization, and to load serialized
 *     objects from disk.
 * Last Modified: 19 November 2015
 */
package pathapp;

// hey look, it's userinput from 182 again. yay code reuse!
import userinput.UserInput;
import java.io.*;

// path.java
// demonstrates shortest path with weighted, directed graphs
// to run this program: C>java PathApp
public class PathApp {

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');     // 0  (start)
        theGraph.addVertex('B');     // 1
        theGraph.addVertex('C');     // 2
        theGraph.addVertex('D');     // 3
        theGraph.addVertex('E');     // 4

        // initial graph setup
        // DO NOT MODIFY!!!!
        // used for comparison with other projects
        try {
            theGraph.addEdge(0, 1, 50);  // AB 50
            theGraph.addEdge(0, 3, 80);  // AD 80
            theGraph.addEdge(1, 2, 60);  // BC 60
            theGraph.addEdge(1, 3, 90);  // BD 90
            theGraph.addEdge(2, 4, 40);  // CE 40
            theGraph.addEdge(3, 2, 20);  // DC 20
            theGraph.addEdge(3, 4, 70);  // DE 70
            theGraph.addEdge(4, 1, 50);  // EB 50
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        char choice = ' ';
        
        // menu selection system. each choice calls a sub function to keep the menu clear
        do {
            System.out.println("(A)dd edge | (C)hange edge | (D)elete edge | (F)ind path | (L)oad graph | (S)ave graph | (Q)uit program");
            System.out.print("Select one of the above options: ");
            choice = UserInput.getChar();
            choice = Character.toLowerCase(choice);
            switch (choice) {
                case 'a':
                    addEdge(theGraph);
                    break;
                case 'c':
                    changeEdge(theGraph);
                    break;
                case 'd':
                    deleteEdge(theGraph);
                    break;
                case 'f':
                    findPath(theGraph);
                    break;
                case 'l':
                    theGraph = loadGraph();
                    break;
                case 's':
                    saveGraph(theGraph);
                    break;
                case 'q':
                    break; // will leave loop and quit
                default:
                    System.out.println("Invalid selection. Retry.");
            }
        } while (choice != 'q');

    }  // end main()

    // function to add an edge to the graph
    public static void addEdge(Graph theGraph) {
        try {
            // get integers for the indexes of the starting and ending points
            int startIndex = getVertIndex(theGraph, "starting");
            int endIndex = getVertIndex(theGraph, "ending");
            // get the weight of the new edge
            int weight = getWeight();
            
            // do the actual edge building
            theGraph.addEdge(startIndex, endIndex, weight);
        } catch (Exception e) {
            // if any of the above throw an exception, quit trying to build the edge and complain about it
            System.out.println(e.getMessage());
        }
        System.out.println("");
    }

    // function to change an existing edge
    public static void changeEdge(Graph theGraph) {
        try {
            // get integers for the indexes of the starting and ending points
            int startIndex = getVertIndex(theGraph, "starting");
            int endIndex = getVertIndex(theGraph, "ending");
            // get the weight of the new edge
            int weight = getWeight();
            
            // do the actual edge change
            theGraph.changeEdge(startIndex, endIndex, weight);
        } catch (Exception e) {
            // if any of the above throw an exception, quit trying to build the edge and complain about it
            System.out.println(e.getMessage());
        }
        System.out.println("");
    }

    // function to delete an existing edge
    public static void deleteEdge(Graph theGraph) {
        try {
            // get integers for the indexes of the starting and ending points
            int startIndex = getVertIndex(theGraph, "starting");
            int endIndex = getVertIndex(theGraph, "ending");
            
            // do the edge deletion
            theGraph.deleteEdge(startIndex, endIndex);
        } catch (Exception e) {
            // if any of the above throw an exception, quit trying to build the edge and complain about it
            System.out.println(e.getMessage());
        }
        System.out.println("");
    }

    // function to find build the lowest cost path array, and display the path to the chosen node
    public static void findPath(Graph theGraph) {
        try {
            // get integers for the index of the target vertex
            int targetIndex = getVertIndex(theGraph, "target");
            
            // build the path array and lowest cost things, then show the path to the requested point
            theGraph.path(targetIndex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

    }

    // function to get the index for the specified vertex.
    // includes a string to customize the message, because user input and exception throwing clarity
    private static int getVertIndex(Graph theGraph, String display) throws Exception {
        System.out.print("Enter the " + display + " vertex: ");
        char start = UserInput.getChar('A', 'Z');
        return theGraph.getVertexIndex(start);
    }

    // function to get a number for a weight
    private static int getWeight() {
        System.out.print("Enter the new weight: ");
        return UserInput.getInt(0, 10000);
    }

    // function to serialize the graph and save it to disk
    private static void saveGraph(Graph theGraph) {
        String filename;
        try {
            System.out.print("Enter the name of the file to save the graph in: ");
            filename = UserInput.getString();
            
            // build a file object first, and check to see if the file already exists
            File file = new File(filename);
            
            // if it does exist, confirm overwrite
            if (file.exists()) {
                System.out.print("File exists. Overwrite? (y/n): ");
                char answer;
                do {
                    answer = UserInput.getChar('N', 'Y');
                    answer = Character.toLowerCase(answer);
                } while (answer != 'n' && answer != 'y');
                // if they don't want to overwrite, cancel write operation and return to menu
                if (answer == 'n') {
                    System.out.println("");
                    return;
                }
                // else try to delete it first (because I don't feel like just overwriting), and throw an error if you can't for some reason
                else {
                    if (!file.delete())
                        throw new IOException("Unable to delete file " + filename + ".");
                }
            }
            
            // after checking for file existence, do the actual serialization and close the file
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(theGraph);
            out.close();
            fileOut.close();
            file = null;
            
            // confirm success to user
            System.out.println("Serialized data saved to " + filename);
            System.out.println("");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }

    // function to load a serailized graph from disk into memory, via reference return
    private static Graph loadGraph() {
        // local holder for the loaded graph, to be returned later
        Graph theGraph;
        try {
            // get file name
            System.out.print("Enter the name of the file to load the graph from: ");
            String filename = UserInput.getString();
            
            // check if the file exists, and if it doesn't throw an exception and return
            File file = new File(filename);
            if (!file.exists())
                throw new IOException("File " + filename + "does not exist.");
            
            // if the file does exist, try to read it in from serialization and close the file objects
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object test = in.readObject();
            in.close();
            fileIn.close();
            file = null;
            
            // test if the read object is a Graph object, cast it to a graph objct. 
            if (test instanceof Graph)
                theGraph = (Graph) test;
            // throw an exeption if it isn't
            else
                throw new IOException("File " + filename + "does not contain a Graph object.");
            
            // if we've made it here without exception, things are working nicely. report success
            System.out.println("Successfully loaded serialization from " + filename );
            System.out.println("");
        } catch (IOException i) {
            System.out.println(i.getMessage());
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Graph class not found, which is really weird.");
            return null;
        }
        return theGraph;
    }

}  // end class PathApp
////////////////////////////////////////////////////////////////

