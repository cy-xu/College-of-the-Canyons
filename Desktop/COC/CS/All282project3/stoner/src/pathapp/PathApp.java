/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author justinstoner
 * name: justin stoner
 * date: 12/3/15
 * class: cs282
 * project info: console program for creating a graph
 */
public class PathApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0 (start)
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('B'); // 1
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
        while(true){
            System.out.print("enter the first letter of: \n");
            System.out.print("Change weight, Add edge, Delete edge, Find paths from vertex, quit\n");
            char choice = getChar();
            switch(choice){
                case 'c':
                    System.out.println("Enter a from vertex: (a, b, c, d, or e)");
                    char fromC = getChar();
                    int from = getInt(fromC);
                    System.out.println("Enter a to vertex: (a, b, c, d, or e)");
                    char toC = getChar();
                    int to = getInt(toC);
                    System.out.println("please enter a weight for the new edge");
                    int weight= getInt();
                    boolean edge=theGraph.confirmEdge(from, to);
                    if(edge){
                        theGraph.addEdge(from, to, weight);
                        System.out.println("weight of edge " + fromC + toC + " changed to " + weight);
                    }
                    else{
                        System.out.println("edge does not exist");
                    }
                    break;
                case 'a':
                    System.out.println("add edge");
                    break;
                case 'f':
                    System.out.println("which vertex do you want to find?");
                    char verC = getChar();
                    int v = getInt(verC);
                    break;
                case 'q':
                    System.out.println("quitting...");
                    return;
                default:
                    System.out.println("invalid entry");
            }
        }
    }
    public static String getString() throws IOException{
 
      InputStreamReader isr = new InputStreamReader(System.in);
 
      BufferedReader br = new BufferedReader(isr);
 
      String s = br.readLine();
 
      return s;
 
      }
     public static char getChar() throws IOException{
 
      String s = getString();
 
      return s.charAt(0);
 
      }
     public static int getInt(char c){
         switch(c){
             case 'a':
                 return 0;
             case 'b':
                 return 1;
             case 'c':
                 return 2;
             case 'd':
                 return 3;
             case 'e':
                 return 4;
             default:
                 System.out.println("invalid entry, using 0");
                 break;
            }
         return 0;
         
     }
     public static int getInt() throws IOException
 
      {
 
      String s = getString();
 
      return Integer.parseInt(s);
 
      }
}
