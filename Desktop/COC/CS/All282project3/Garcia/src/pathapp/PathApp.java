/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pathapp;

/**
 * @author Nicole Garcia 
 * December 3, 2015 
 * CSC 282 Project # 3 
 * Shows the shortest path of a graph
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathApp {

    public static void main(String[] args) throws IOException {
        long value;
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

        while (true) {
            System.out.print("Enter first letter of option: ");
            System.out.print("Change the weight of an edge, Add an edge, Delete an edge, "
                    + "\nFind path(s) from a vertex and Quit the program: ");
            char choice = getChar();
            switch (choice) {
                case 'c':
                    System.out.println("Enter a 'from' vertex, a 'to' vertex and the new weight for that edge");
                    char v = getChar();
                    NumtoLet(v);
                    break;
                case 'a':
                    System.out.println("Enter edge to be added");
                    break;
                case 'd':
                    System.out.println("Enter edge to be deleted");
                    break;
                case 'f':
                    System.out.println("Enter a vertex to find its paths");
                    char vertex = getChar();
                    NumtoLet(vertex);
                    break;
                case 'q':
                    System.out.println("Done");
                    System.exit(0);
                default:
                    System.out.print("Invalid entry\n");
            } //end switch
        } // end while
    }  // end main()
    
    public static int NumtoLet(char let) throws IOException {
        int num = 0;
        if (let == 'a'){
            num = 0;
        }
        if (let == 'b'){
            num = 1;
        }
        if (let == 'c'){
            num = 2;
        }
        if (let == 'd'){
            num = 3;
        }
        if (let == 'e'){
            num = 4;
        }
    return num;
    } 
    
    
     public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//--------------------------------------------------------------

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

//-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------
}  // end class PathApp
////////////////////////////////////////////////////////////////

