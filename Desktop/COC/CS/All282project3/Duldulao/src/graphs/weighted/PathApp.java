/*
 * Programmer: Aaron Duldulao
 * CMPSCI282 - Advanced Data Structure
 * Project 3
 * Date last modified: 11/30/2015
 * Description: This program adds and deletes edges, changes the weight of an edge, and finds the shortest
 * path of a graph.
 */
package graphs.weighted;

import java.io.*;

public class PathApp
{
    private static Graph theGraph;
    public static void main(String[] args) throws IOException
    {
        char choice = 'Z';
        char startVert, endVert, findVert;
        String fileName;
        int weight;
        
        theGraph = new Graph();
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

        while(choice != 'Q')
        {
            System.out.println("");
            System.out.println("--------------MENU--------------");
            System.out.println("[C] Change the weight of an edge");
            System.out.println("[A] Add an edge");
            System.out.println("[D] Delete an edge");
            System.out.println("[F] Find path(s) from a vertex");
            System.out.println("[W] Write graph to disk");
            System.out.println("[R] Read graph from disk");
            System.out.println("[Q] Quit the program");
            System.out.print("Enter a letter: ");
            choice = getChar();
            switch (choice)
            {
                case 'C': //change weight of an edge
                    System.out.println("---Change weight of edge---");
                    System.out.print("Enter the start vertex: ");
                    startVert = getChar();
                    System.out.print("Enter the end vertex: ");
                    endVert = getChar();
                    if(theGraph.hasEdge(vertToInt(startVert), vertToInt(endVert))) //if vertices have edge
                    {
                        System.out.print("Enter the new weight: ");
                        weight = getInt();
                        theGraph.addEdge(vertToInt(startVert), vertToInt(endVert), weight); //change weight
                        System.out.println("The weight of the edge has been changed.");
                    }
                    else //if there is no edge
                    {
                        System.out.println("The vertices you entered does not have an edge!");
                    }
                    break;
                
                case 'A': //add an edge
                    System.out.println("-------Add an edge-------");
                    System.out.print("Enter the start vertex: ");
                    startVert = getChar();
                    System.out.print("Enter the end vertex: ");
                    endVert = getChar();
                    if(theGraph.hasEdge(vertToInt(startVert), vertToInt(endVert)) == false) //if vertices have an edge
                    {
                        System.out.print("Enter the weight: ");
                        weight = getInt();
                        theGraph.addEdge(vertToInt(startVert), vertToInt(endVert), weight); //add edge
                        System.out.println("The edge has been added.");
                    }
                    else //if there is already an edge
                    {
                        System.out.println("The vertices you entered already have an edge!");
                    }
                    break;
                    
                case 'D': //delete an edge
                    System.out.println("------Delete an edge------");
                    System.out.print("Enter the start vertex: ");
                    startVert = getChar();
                    System.out.print("Enter the end vertex: ");
                    endVert = getChar();
                    if(theGraph.hasEdge(vertToInt(startVert), vertToInt(endVert))) //if vertices have an edge
                    {
                        theGraph.deleteEdge(vertToInt(startVert), vertToInt(endVert)); //delete edge
                        System.out.println("The edge has been deleted.");
                    }
                    else //if there is no edge
                    {
                        System.out.println("The vertices you entered does not have an edge!");
                    }
                    break;
                    
                case 'F': //find a path
                    System.out.println("--------Find a path--------");
                    int [] pathList;
                    System.out.print("Enter the vertex to find: ");
                    findVert = getChar();
                    System.out.println("Shortest paths");
                    theGraph.path();             // shortest paths
                    pathList = theGraph.findPath(vertToInt(findVert)); //to get the path list
                    for(int x = pathList.length - 1; x >= 0; x--)
                    {
                        if(x != 0)
                        {
                            System.out.print(intToVert(pathList[x]) + " to ");
                        }
                        else
                        {
                            System.out.print(intToVert(pathList[x]));
                        }
                    }
                    if(pathList.length == 2) //if there is no path from A to that vertex
                    {
                        if(theGraph.hasEdge(pathList[1], pathList[0]) == false)
                        {
                            System.out.print("(No path)");
                        }
                    }
                    System.out.println();
                    break;
                    
                case 'W': //write graph to disk
                    System.out.print("Enter the filename: ");
                    fileName = getString();
                    serializeG(fileName); //method call
                    break;
                    
                case 'R': //read graph from disk
                    System.out.print("Enter the filename: ");
                    fileName = getString();
                    deserializeG(fileName); //method call
                    break;
                    
                case 'Q': //quit
                    System.out.println("Thank you for using PathApp!");
                    break;
                    
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }//end of main
    
    public static String getString() throws IOException 
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException 
    {
        String s = getString().toUpperCase();
        return s.charAt(0);
    }

    public static int getInt() throws IOException 
    {
        String s = getString();
        return Integer.parseInt(s);
    }
    
    public static int vertToInt(char letter) //method to convert letter to int
    {
        int index;
        char [] letterList = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};
        for(index = 0; index < 20; index++)
        {
            if(letterList[index] == letter)
            {
                return index;
            }
        }
        return -1;
    }//end of vertToInt
    
    public static char intToVert(int number) //method to convert int to letter
    {
        char [] letterList = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};
        return letterList[number];
    }//end of intToVert
    
    public static void serializeG(String outputFile) //method to serialize object
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(theGraph); //write object to disk
            out.close();
            fileOut.close();
            System.out.println("The graph has been saved.");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }//end of serializeG
    
    public static void deserializeG(String inputFile) //method to deserialize object
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(inputFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            theGraph = new Graph();
            theGraph = (Graph) in.readObject(); //read graph from disk
            in.close();
            fileIn.close();
            System.out.println("The graph has been read from file.");
            
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }//end of deserializeG
}//end of class PathApp
