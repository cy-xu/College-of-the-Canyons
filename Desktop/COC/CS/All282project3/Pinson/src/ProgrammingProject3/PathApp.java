//John Pinson
//December 3rd, 2015
//CS 282 advanced Data Structures
//Project Description: Project 3 
//PathApp
//This is the app class for the directed weigthed graph project. 
//it contains a menu with quit, change, add, delete and find options.


package ProgrammingProject3;

// path.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// demonstrates shortest path with weighted, directed graphs
// to run this program: C>java PathApp
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
public class PathApp
{

    public static void main(String[] args) throws IOException
    {
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

        System.out.println("Shortest paths");
        theGraph.path();             // shortest paths
        System.out.println();

        while (true)
        {
            System.out.print("Enter first letter of ");
            System.out.print("change, add, delete, find or quit: ");
            char choice = getChar();

            switch (choice)
            {
                case 'q':
                    System.exit(0);
                case 'c':
                {
                    int fromInt = -1;
                    char from;
                    do
                    {
                        System.out.println("Please enter a 'from' vertex");
                        from = getChar();
                        fromInt = getVertex(from);
                    } while (fromInt == -1);

                    int toInt = -1;
                    char to;
                    do
                    {
                        System.out.println("Please enter a 'to' vertex");
                        to = getChar();
                        toInt = getVertex(to);
                    } while (toInt == -1);

                    if (theGraph.edgeExists(fromInt, toInt))
                    {
                        System.out.println("Please enter a weight for the edge between " + from + " and " + to);
                        int weight = getInt();
                        // We're fine to call "addEdge" since
                        // it only updates the weight and we're checking
                        // if the edge already exists or not.
                        theGraph.addEdge(fromInt, toInt, weight);
                    } else
                    {
                        System.out.println("The edge between " + from + " and " + to + " does not exist.");
                    }
                    break;
                }
                case 'a':
                {
                    int fromInt = -1;
                    char from;
                    do
                    {
                        System.out.println("Please enter a 'from' vertex");
                        from = getChar();
                        fromInt = getVertex(from);
                    } while (fromInt == -1);

                    int toInt = -1;
                    char to;
                    do
                    {
                        System.out.println("Please enter a 'to' vertex");
                        to = getChar();
                        toInt = getVertex(to);
                    } while (toInt == -1);

                    if (!theGraph.edgeExists(fromInt, toInt))
                    {
                        System.out.println("Please enter a weight for the edge between " + from + " and " + to);
                        int weight = getInt();
                        // We're not adding vertices...
                        
                        // We're fine to call "addEdge" since
                        // it only updates the weight and we're checking
                        // if the edge already exists or not.
                        theGraph.addEdge(fromInt, toInt, weight);
                    } else
                    {
                        System.out.println("The edge between " + from + " and " + to + " already exists.");
                    }
                    break;
                }
                case 'd':
                {
                    int fromInt = -1;
                    char from;
                    do
                    {
                        System.out.println("Please enter a 'from' vertex");
                        from = getChar();
                        fromInt = getVertex(from);
                    } while (fromInt == -1);

                    int toInt = -1;
                    char to;
                    do
                    {
                        System.out.println("Please enter a 'to' vertex");
                        to = getChar();
                        toInt = getVertex(to);
                    } while (toInt == -1);

                    if (theGraph.edgeExists(fromInt, toInt))
                    {
                        // Deleting an edge is setting the weight to infinity
                        theGraph.addEdge(fromInt, toInt, Graph.INFINITY);
                    } else
                    {
                        System.out.println("The edge between " + from + " and " + to + " does not exist.");
                    }
                    break;
                }
                case 'f':
                {
                    int vInt = -1;
                    char v;
                    do
                    {
                        System.out.println("Please enter a vertex to find.");
                        v = getChar();
                        vInt = getVertex(v);
                    } while (vInt == -1);
                    
                    // Do the calculations for shortest paths
                    theGraph.path();                    
                    theGraph.find(v);
                    
                    break;
                }
                default:
                    System.out.println("Invalid entry");

            }  // end switch

        }  // end while

    }  // end main()

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

//--------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        if (s == null || s.length() == 0)
        {
            return ' ';
        }
        return s.charAt(0);
    }

//-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }

    private static int getVertex(char c)
    {
        switch (c)
        {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            default:
                return -1;
        }
    }
}  // end class PathApp
////////////////////////////////////////////////////////////////

