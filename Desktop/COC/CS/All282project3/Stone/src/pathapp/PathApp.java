/*
 * NAME: Nicole Stone
 * Date: 11/18/15
 * Project: Project 3 - Weighted Graphs
 * Description: 
 * Phase 1
 Copy code from book and format nicely/create a pretty java package

 * Phase 2
 Add a menu to the main program. 
 We are going to need options to Change the weight of an edge, Add an edge, Delete an edge, Find path(s) from a vertex and Quit the program. 
 You can use a simple console menu, where the user enters the first character to execute a command. 
 Except for the Quit command, do not implement the commands just yet, a simple message printed on the console will be sufficient. 
 
 Be sure to keep the code that creates the vertices and edges at the top of your code, everyone needs to have the SAME graph when the program starts. 
 It is needed so you can test the code without having to create the Graph each time you run the program.

 * Phase 3
 Implement the Change command. Ask the user to enter a 'from' vertex, a 'to' vertex and the new weight for that edge. 
 Then set that edge to the new weight. Please note, the user will enter the letter of the vertex A, B, C, D or E. 
 Internally the code uses 0,1,2,3 and 4. You will need to write a method to translate from letters to numbers. 
 You should also verify the edge exists, before changing the weight.

 The find command has mostly been completed for you, it is part of the code from the book. 
 All you need to add, is asking the user which vertex you wish to find, and then some code to list the FULL path to that vertex. 
 For example, on the default graph to reach E for the lowest cost (always start from A), you must go from A to D to C to E. 
 This is the path I want printed out in addition to what the existing routine already outputs.
 The find command is important to the balanced, speedy operation of the network. 
 When data has to be sent from A to any vertex on the network, the find command will 'find' the best route for the data.

 * Phase 4
 In order for the network to remain stable, in needs to handle links coming down and going up. 
 The add and delete commands are designed to simulate links (or edges) being dropped and/or added to the network.

 Implement the Add command. It will be very similar to the change command, but you need to verify the link does not exist before adding it.

 Implement the Delete command. Enter a 'from' vertex, a 'to' vertex, then verify and delete that link. 
 Again, the user enters a letter A,B,C etc. to specify a vertex.

 * Phase 5
 Add Write the graph and Read the graph options to the main menu. 
 Google the term "Java Serialization" to learn how to Write and Read objects to a disk file. 
 When done right, it is a simple matter to write the entire Graph to disk. 
 Allow the user to name the file they write to disk. 
 Obviously, the Read option will ask the user the name of the file to read and restore the graph. 
 Do not create a new graph reference variable, make sure the read option replaces the graph that currently is in memory.
 * 
 */
package pathapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Nicole
 */
public class PathApp {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        char vertex;
        int from, to, weight;
        boolean exists = false;
        String filename;
        File graphFile;
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

        char selection = 'b';
        while (selection != 'q' && selection != 'Q') {
            System.out.println("Please enter the first letter of your selection: "
                    + "\nChange the weight of an edge \nAdd an edge \nDelete an edge \nFind path(s) from vertex A "
                    + "\nRead the Graph \nWrite the Graph \nQuit the program");
            selection = UserInput.getChar();

            switch (selection) {

                case 'C':
                case 'c': //Change weight of an edge
                   /*Implement the Change command. Ask the user to enter a 'from' vertex, a 'to' vertex and the new weight for that edge. 
                     Then set that edge to the new weight. Please note, the user will enter the letter of the vertex A, B, C, D or E. 
                     Internally the code uses 0,1,2,3 and 4. You will need to write a method to translate from letters to numbers. 
                     You should also verify the edge exists, before changing the weight.*/
                    from = -1;
                    to = -1;
                    System.out.println("Please enter the vertex that the edge comes from (Please enter A, B, C, D or E): ");
                    vertex = UserInput.getChar();
                    while (from == -1) {
                        from = charToIntVertex(vertex);
                        if (from == -1) {
                            vertex = UserInput.getChar();
                        }
                    }

                    System.out.println("Please enter the vertex that the edge goes to (Please enter A, B, C, D or E): ");
                    vertex = UserInput.getChar();
                    while (to == -1) {
                        to = charToIntVertex(vertex);
                        if (to == -1) {
                            vertex = UserInput.getChar();
                        }
                    }

                    if (theGraph.adjMat[from][to] == theGraph.INFINITY) {
                        System.out.println("That edge does not exist. Please select Add edge from the menu. ");
                        break;
                    }
                    System.out.println("Please enter the new weight of the edge. ");
                    weight = UserInput.getInt(0, 100);
                    theGraph.adjMat[from][to] = weight;

                    break;

                case 'A':
                case 'a': //add an edge
                    //Implement the Add command. It will be very similar to the change command, but you need to verify the link does not exist before adding it.
                    from = -1;
                    to = -1;
                    System.out.println("Please enter the first vertex the edge will connect to (Please enter A, B, C, D or E): ");
                    vertex = UserInput.getChar();
                    while (from == -1) {
                        from = charToIntVertex(vertex);
                        if (from == -1) {
                            vertex = UserInput.getChar();
                        }
                    }

                    System.out.println("Please enter the other vertex the edge will connect to (Please enter A, B, C, D or E): ");
                    vertex = UserInput.getChar();
                    while (to == -1) {
                        to = charToIntVertex(vertex);
                        if (to == -1) {
                            vertex = UserInput.getChar();
                        }
                    }

                    if (theGraph.adjMat[from][to] != theGraph.INFINITY) {
                        System.out.println("There is already an edge from " + Graph.intToCharVertex(from) + " to " + Graph.intToCharVertex(to) + ".");
                        break;
                    }

                    System.out.println("Please enter the weight of the new edge: ");
                    weight = UserInput.getInt(0, 100);
                    theGraph.addEdge(from, to, weight);

                    break;

                case 'D':
                case 'd': //delete an edge
                    //Implement the Delete command. Enter a 'from' vertex, a 'to' vertex, then verify and delete that link. 
                    //Again, the user enters a letter A,B,C etc. to specify a vertex.
                    from = -1;
                    to = -1;
                    System.out.println("Please enter the vertex that the edge comes from (Please enter A, B, C, D or E): ");
                    vertex = UserInput.getChar();
                    while (from == -1) {
                        from = charToIntVertex(vertex);
                        if (from == -1) {
                            vertex = UserInput.getChar();
                        }
                    }

                    System.out.println("Please enter the vertex that the edge goes to (Please enter A, B, C, D or E): ");
                    vertex = UserInput.getChar();
                    while (to == -1) {
                        to = charToIntVertex(vertex);
                        if (to == -1) {
                            vertex = UserInput.getChar();
                        }
                    }

                    if (theGraph.adjMat[from][to] == theGraph.INFINITY) {
                        System.out.println("That edge already does not exist. ");
                        break;
                    }

                    theGraph.adjMat[from][to] = theGraph.INFINITY;

                    break;

                case 'F': //find path(s) from a vertex
                case 'f':

                    /*Ask the user which vertex you wish to find, and then some code to list the FULL path to that vertex. 
                     For example, on the default graph to reach E for the lowest cost (always start from A), you must go from A to D to C to E. 
                     This is the path I want printed out in addition to what the existing routine already outputs.
                     The find command is important to the balanced, speedy operation of the network. 
                     When data has to be sent from A to any vertex on the network, the find command will 'find' the best route for the data. */
                    to = -1;
                    System.out.println("Which vertex would you like to find? (Please enter A, B, C, D or E): ");
                    vertex = UserInput.getChar();
                    System.out.println(vertex);
                    while (to == -1) {
                        to = charToIntVertex(vertex);
                        while (to == -1) {
                            vertex = UserInput.getChar();
                            to = charToIntVertex(vertex);
                        }
                        System.out.println(to);
                        theGraph.path(to);
                    }

                    break;

                case 'R':
                case 'r': //read the graph
                    //Read option will ask the user the name of the file to read and restore the graph. 
                    //Do not create a new graph reference variable, make sure the read option replaces the graph that currently is in memory.

                    System.out.println("Please enter the name of the file you would like to read: ");
                    filename = UserInput.getString();
                    graphFile = new File(filename);
                    exists = graphFile.exists();

                    if (exists) {
                        // Read from disk using FileInputStream
                        FileInputStream f_in = new FileInputStream(filename);

                        // Read object using ObjectInputStream
                        ObjectInputStream obj_in = new ObjectInputStream(f_in);

                        // Read an object
                        Object obj = obj_in.readObject();
                        theGraph = (Graph) obj;
                    } else {
                        System.out.println(filename + " does not exist. ");
                    }

                    break;

                case 'W':
                case 'w': //write to the graph
                    //Allow the user to name the file they write to disk. 
                    // Write to disk with FileOutputStream
                    System.out.println("Please enter the name of the file you would like to write to: ");
                    filename = UserInput.getString();
                    graphFile = new File(filename);
                    exists = graphFile.exists();

                    //if (exists) {
                        FileOutputStream f_out = new FileOutputStream(filename);

                        // Write object with ObjectOutputStream
                        ObjectOutputStream obj_out = new ObjectOutputStream(f_out);

                        // Write object out to disk
                        obj_out.writeObject(theGraph);

                        f_out.close(); //close file
                    // else {
                    //    System.out.println("Unable to write to " + filename);
                    //}

                    break;

                case 'Q':
                case 'q': //quit program
                    System.out.println("Exiting program. ");

                    break;

                default:

                    System.out.print("Invalid entry\n");

            }  // end switch
        }
        //System.out.println("Shortest paths");
        //theGraph.path();             // shortest paths
        //System.out.println();
    }  // end main()

    public static int charToIntVertex(char vertex) {
        int num = (vertex == 'A' || vertex == 'a') ? 0 : (vertex == 'B' || vertex == 'b') ? 1 : (vertex == 'C' || vertex == 'c') ? 2
                : (vertex == 'D' || vertex == 'd') ? 3 : (vertex == 'E' || vertex == 'e') ? 4 : -1;
        return num;
    }
}  // end class PathApp
