/* 
Computer Science 282: Advanced Data Structures.
Fall:2015
Professor: Chris Ferguson
Programmer: Luis Riba 
Project : Project3
Description: 

*/


package Project3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class PathApp
   {
public static void main(String[] args)  {
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

// make keyboard reader
Scanner kybd = new Scanner(System.in);      
String select = ""; // menu selection
// inputs
String input="";
int from=0;
int to=0;
int weight;
String filename="";
// menu loop
do {
try
{
// print menu
System.out.println("\nGraph Menu:");
System.out.println("[C]hange the weight of an edge");
System.out.println("[A]dd an edge"); 
System.out.println("[D]elete an edge");
System.out.println("[F]ind path(s) from a vertex");
System.out.println("[P]print graph");
System.out.println("[R]ead graph from file");
System.out.println("[W]rite graph to file");
System.out.println("[Q]uit the program");
    	  
// get selection
System.out.println("Enter selection: ");
select = kybd.nextLine().toUpperCase();
    	  
// change the weight of an edge
if(select.equals("C")) {
// get from vertex
 System.out.println("Enter from Vertex");
 from = getVertex(kybd);    		  
// get to vertex
 System.out.println("Enter toVertex");
 to = getVertex(kybd);
    		  
 // get weight
 System.out.println("Enter weight");
 weight = Integer.parseInt(kybd.nextLine());
 // change edge
 if(theGraph.changeEdge(from,to, weight))
 System.out.println("Edge changed");
 else
 System.out.println("Edge does not exist");
   }
    	  
 // add an edge
 if(select.equals("A")) {
 // get from vertex
 System.out.println("Enter from Vertex");
 from = getVertex(kybd);
 // get to vertex
 System.out.println("Enter to Vertex");
 to = getVertex(kybd);
 // get weight
 System.out.println("Enter weight");
 weight = Integer.parseInt(kybd.nextLine());
 // add edge
 if(theGraph.addEdge(from,to, weight))
 System.out.println("Edge added");
 else
 System.out.println("Edge allready exists");
 }
 // delete an edge 
 else if(select.equals("D")) {
 // get from vertex
 System.out.println("Enter from Vertex");
 from = getVertex(kybd);
 // get to vertex
 System.out.println("Enter toVertex");
 to = getVertex(kybd);
 // delete edge
 if(theGraph.deleteEdge(from,to))
 System.out.println("Edge deleted");
 else
 System.out.println("Edge does not exist");
  }
 // find path(s) from a vertex 
 else if(select.equals("F")) {
 // get from vertex
 System.out.println("Enter Vertex to find");
 to = getVertex(kybd);
 System.out.println("Shortest paths");
 theGraph.path(to);             // shortest paths
 System.out.println();
 }
 // read graph
 else if(select.equals("R")) {
 try {
 System.out.print("Enter input file name: ");
 filename = kybd.nextLine();
 FileInputStream fileIn = new FileInputStream(filename);
 ObjectInputStream in = new ObjectInputStream(fileIn);
 theGraph = (Graph) in.readObject();
 in.close();
 fileIn.close();
 System.out.printf("Graph is read from file: " + filename);
  }
 catch(IOException ex) {
 System.out.printf("Graph NOT read from file: " + filename);
    	      }
    	  }
  // write graph
 else if(select.equals("W")){
 try {
 System.out.print("Enter output file name: ");
 filename = kybd.nextLine();
 FileOutputStream fileOut = new FileOutputStream(filename);
 ObjectOutputStream out = new ObjectOutputStream(fileOut);
 out.writeObject(theGraph);
 out.close();
 fileOut.close();
 System.out.printf("Graph is saved in file: " + filename); 
 }
 catch(IOException ex) {
 System.out.printf("Graph NOT saved in file: " + filename);
  }
 }
 // print graph
 else if(select.equals("P")) {
 theGraph.printGraph();
 }	  
 // quit the program 
 else if(select.equals("Q")) {
 System.out.println("Thankyou for graphing with us");
 }
 }
 catch(Exception ex) {
 System.out.println("Bad Input");
 }
 }while(!select.equals("Q"));
 }  // end main()
   
// get and return vertex index
 public static int getVertex(Scanner kybd) {
 int vertex = 0;
 String input = "";
 // get from vertex
 do{
 System.out.println("Enter Vertex (A-E): ");
 input = kybd.nextLine().toUpperCase();}
 while(input.compareTo("A")<0 || input.compareTo("E")>0);
 vertex = input.charAt(0) - 'A';
 return vertex;
   }
   }  // end class PathApp
////////////////////////////////////////////////////////////////

