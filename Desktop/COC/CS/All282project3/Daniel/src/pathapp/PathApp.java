package pathapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/* Jason Daniel
   compsci 282 Project#3
    11-27-2015
 demonstrates shortest path with weighted, directed graphs of a computer network
*/  
////////////////////////////////////////////////////////////////



public class PathApp   {
    Scanner input= new Scanner(System.in); 
    
   public static void main(String[] args)
      {
      PathApp m = new PathApp();
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
          System.out.println(theGraph.getnVerts());
          
       m.Menu(theGraph);
      System.out.println("Shortest paths");
      theGraph.path();             // shortest paths
      System.out.println();
      }  // end main()
        char fvert;
     char tvert;
     int numfvert;
     int numtvert;
     int newweight;

 public void Menu( Graph g){
 
 
 System.out.println("ENTER SELECTION");
 System.out.println(" C- change weight\n A- add edge\n D- delete edge\n F- find path\n Q- Quit ");
   
 char sel= input.next().charAt(0);
 
 switch(sel){
     case 'A':  add(g);
         break;
     case 'C': changeWeight(g);
         break;
     case 'D':
         break;
     case 'F': find(g);
        break;
     case 'Q': System.exit(0);
         break;
     default:
         break;
 }
 
 
 }//end of Menu
 
  public  void find(Graph g){
      char findvert;
      int numfindvert;
      System.out.println("Enter Vertex to find:");
      findvert=input.next().charAt(0);
     numfindvert=vertTranslate(findvert);

            while (numfindvert> 0) {
                System.out.print(g.getParent(numfindvert));

                numfindvert--;
            }

            System.out.println();
      
  }
 
  public void add(Graph g){
      System.out.println("Enter new Vertex:");
      tvert=input.next().charAt(0);
      System.out.println("Enter From Vertex");
       fvert=input.next().charAt(0);
       numfvert=vertTranslate(fvert);
      System.out.println("Enter Weight");
      newweight=input.nextInt();
      if (g.adjMat[numfvert][numtvert] == 1000000) {
            g.adjMat[numfvert][numtvert] = newweight;
                  g.addVertex(tvert);  
                  int nv = g.getnVerts();
                  g.sPath[nv] = new DistPar(nv, newweight);
      } 
     else {
                System.out.println("Edge already exists");
            }
      

  
  }
 public void delete(Graph g) {
       
        
            System.out.print("Enter From vert:");
           fvert=input.next().charAt(0);
       numfvert=vertTranslate(fvert);
            System.out.print("Enter To vert: ");
       tvert=input.next().charAt(0);
       numtvert=vertTranslate(tvert);

      
            if (g.adjMat[numfvert][numtvert] == 1000000) {
                System.out.println("Edge does not exist.");
            } else {
                g.adjMat[numfvert][numtvert] = 1000000;
            }
 }
  public void changeWeight(Graph g){

     
     System.out.println("Enter From Vertex: ");
       fvert=input.next().charAt(0);
       numfvert=vertTranslate(fvert);
     System.out.println("Enter To Vertex: ");
       tvert=input.next().charAt(0);
       numtvert=vertTranslate(tvert);
       System.out.println("Enter new Weight: ");
        newweight=input.nextInt();
       
        g.addEdge(numfvert, numtvert, newweight);
       
       
 }//end of changeWSeight      
public int vertTranslate(char v){

    switch(v){
    case 'A': return 1;
       
    case 'B': return 2;
        
    case 'C': return 3;
        
    case 'D': return 4;
        
    case 'E': return 5;
        
    default: return 99;
        
}
}
  public void writeGraph(Graph g) {
        System.out.println("Export");
        try {
            try (FileOutputStream fileOut = new FileOutputStream("Graph.ser"); 
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(g);
            }
            System.out.println("Export to file Graph.ser completed.");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void readGraph() {
        Graph g = null;

        try {
            try (FileInputStream fileIn = new FileInputStream("Graph.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                g = (Graph) in.readObject();
            }
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Graph class not found.");
            c.printStackTrace();
        }
    }
}  // end class PathApp
////////////////////////////////////////////////////////////////


 
