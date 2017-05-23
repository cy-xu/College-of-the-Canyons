package graph;

/*Gianni Lane
 * Dec 2, 2015 
 * CS 282 Lab Project
 * constructs the graph and opens user interface
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// demonstrates shortest path with weighted, directed graphs
// to run this program: C>java PathApp
////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////
public class PathApp
   {
   private final int MAX_VERTS = 20;
   private final int INFINITY = 1000000;
   private Vertex vertexList[]; // list of vertices
   private int adjMat[][];      // adjacency matrix
   private int nVerts;          // current number of vertices
   private int nTree;           // number of verts in tree
   private DistPar sPath[];     // array for shortest-path data
   private int currentVert;     // current vertex
   private int startToCurrent;  // distance to currentVert
// -------------------------------------------------------------
   public PathApp()               // constructor
      {
      vertexList = new Vertex[MAX_VERTS];
                                         // adjacency matrix
      adjMat = new int[MAX_VERTS][MAX_VERTS];
      nVerts = 0;
      nTree = 0;
      for(int j=0; j<MAX_VERTS; j++)     // set adjacency
         for(int k=0; k<MAX_VERTS; k++)  //     matrix
            adjMat[j][k] = INFINITY;     //     to infinity
      sPath = new DistPar[MAX_VERTS];    // shortest paths
      }  // end constructor
// -------------------------------------------------------------
   public void addVertex(char lab)
      {
      vertexList[nVerts++] = new Vertex(lab);
      }
// -------------------------------------------------------------
   public void addEdge(int start, int end, int weight)
      {
      adjMat[start][end] = weight;  // (directed)
      }
// -------------------------------------------------------------
   public void path(int startTree)                // find all shortest paths
      {
      //int startTree = 0;             // start at vertex 0
      vertexList[startTree].isInTree = true;
      nTree = 1;                     // put it in tree

      // transfer row of distances from adjMat to sPath
      for(int j=0; j<nVerts; j++)
         {
         int tempDist = adjMat[startTree][j];
         sPath[j] = new DistPar(startTree, tempDist);
         }

      // until all vertices are in the tree
      while(nTree < nVerts)
         {
         int indexMin = getMin();    // get minimum from sPath
         int minDist = sPath[indexMin].distance;

         if(minDist == INFINITY)     // if all infinite
            {                        // or in tree,
            System.out.println("There are unreachable vertices");
            break;                   // sPath is complete
            }
         else
            {                        // reset currentVert
            currentVert = indexMin;  // to closest vert
            startToCurrent = sPath[indexMin].distance;
            // minimum distance from startTree is
            // to currentVert, and is startToCurrent
            }
         // put current vertex in tree
         vertexList[currentVert].isInTree = true;
         nTree++;
         adjust_sPath();             // update sPath[] array
         }  // end while(nTree<nVerts)

      displayPaths();                // display sPath[] contents

      nTree = 0;                     // clear tree
      for(int j=0; j<nVerts; j++)
         vertexList[j].isInTree = false;
      }  // end path()
// -------------------------------------------------------------
   public int getMin()               // get entry from sPath
      {                              //    with minimum distance
      int minDist = INFINITY;        // assume minimum
      int indexMin = 0;
      for(int j=1; j<nVerts; j++)    // for each vertex,
         {                           // if it's in tree and
         if( !vertexList[j].isInTree &&  // smaller than old one
                               sPath[j].distance < minDist )
            {
            minDist = sPath[j].distance;
            indexMin = j;            // update minimum
            }
         }  // end for
      return indexMin;               // return index of minimum
      }  // end getMin()
// -------------------------------------------------------------
   public void adjust_sPath()
      {
      // adjust values in shortest-path array sPath
      int column = 1;                // skip starting vertex
      while(column < nVerts)         // go across columns
         {
         // if this column's vertex already in tree, skip it
         if( vertexList[column].isInTree )
            {
            column++;
            continue;
            }
         // calculate distance for one sPath entry
                       // get edge from currentVert to column
         int currentToFringe = adjMat[currentVert][column];
                       // add distance from start
         int startToFringe = startToCurrent + currentToFringe;
                       // get distance of current sPath entry
         int sPathDist = sPath[column].distance;

         // compare distance from start with sPath entry
         if(startToFringe < sPathDist)   // if shorter,
            {                            // update sPath
            sPath[column].parentVert = currentVert;
            sPath[column].distance = startToFringe;
            }
         column++;
         }  // end while(column < nVerts)
   }  // end adjust_sPath()
// -------------------------------------------------------------
   public void displayPaths()
      {
      for(int j=0; j<nVerts; j++) // display contents of sPath[]
         {
         System.out.print(vertexList[j].label + "="); // B=
         if(sPath[j].distance == INFINITY)
            System.out.print("inf");                  // inf
         else
            System.out.print(sPath[j].distance);      // 50
         char parent = vertexList[ sPath[j].parentVert ].label;
         System.out.print("(" + parent + ") ");       // (A)
         }
      System.out.println("");
      }
   
   public int vertexExists(char vertex)throws IOException{
       //converts chars to ints and catches faulty input
       int charval = vertex - 65;
      try{
       if(vertexList[charval].label != vertex){}
       }catch(Exception e){
           System.out.println("vertex does not exist");
           charval = 666;
       }
       return charval;
   }
   public static void main(String[] args) throws IOException{
      
      PathApp theGraph = new PathApp();
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
      theGraph.path(0);             // shortest paths
      
      while(true){
 
         System.out.print("Enter first letter of: change, add, delete, find, or quit: ");
         int i = 0; //used to quit
         char choice = getChar();   //users input

         int charval=0; //charval1/2 used check both user inputs
         int charval2=0;
          
         switch(choice){
 
             case 'C':  //changes the value of an existing edge
                 while (true){
                    System.out.println("Enter the vertex we are starting from ");
                    char firstv = getChar();
                    charval =theGraph.vertexExists(firstv);
                       
                 
                    System.out.println("Enter the vertex we are going to ");
                    char secondv = getChar();
                    charval2 =theGraph.vertexExists(secondv);
                    if(charval!=666&&charval2!=666){    //if user input is valid
                        if(theGraph.adjMat[charval][charval2]==theGraph.INFINITY){ //check if a edge exists
                            System.out.println("There is no edge to be changed here");
                            continue;   //stick them  in the loop again
                        }else{
                            break;  //break if: valid vertexes who share a existing edge
                        }
                    }
                 }
                 System.out.println("Enter the new weigth for this edge ");
                 int weight = getInt();
                 theGraph.adjMat[charval][charval2]= weight;  
                 theGraph.path(0);
                 break;
             
             case 'A':  //adds a new edge
                 while (true){
                    System.out.println("Enter the vertex we are starting from ");
                    char firstv = getChar();
                    charval =theGraph.vertexExists(firstv);
                       
                 
                    System.out.println("Enter the vertex we are going to ");
                    char secondv = getChar();
                    charval2 =theGraph.vertexExists(secondv);
                    if(charval!=666&&charval2!=666){    //if user input is valid
                        if(theGraph.adjMat[charval][charval2]!=theGraph.INFINITY){  //checks for edge
                            System.out.println("there is already an edge here");
                            continue;   
                        }else{
                            break;//break if: valid vertexes and no edge between them
                        }
                    }
                 }
                 System.out.println("Enter the new weigth for this edge ");
                 int ADDweight = getInt();
                 theGraph.addEdge(charval, charval2, ADDweight);//uses user input to add the new edge
                 theGraph.path(0);
 
               break;
 
            case 'D':
 
              while (true){
                    System.out.println("Enter the vertex we are starting from ");
                    char firstv = getChar();
                    charval =theGraph.vertexExists(firstv);
                       
                 
                    System.out.println("Enter the vertex we are going to ");
                    char secondv = getChar();
                    charval2 =theGraph.vertexExists(secondv);
                    if(charval!=666&&charval2!=666){    //if user input is valid
                        if(theGraph.adjMat[charval][charval2]==theGraph.INFINITY){ //check if a edge exists
                            System.out.println("There is no edge to be deleted here");
                            continue;   //stick them  in the loop again
                        }else{
                            break;  //break if: valid vertexes who share an existing edge
                        }
                    }
                 }
                 theGraph.adjMat[charval][charval2]=theGraph.INFINITY;//if edge=INF then there is no edge
                 theGraph.path(0);
               break;
 
            case 'F':
                
                 System.out.println("Enter the vertex you would like to see the shortest path to");
                 char vertex = getChar();
                 int end = theGraph.vertexExists(vertex);
                 ArrayList path = new ArrayList(); //used later to display path in order
                
                
                 path.add(vertex);  //user input is placed in first
                 if(end==666){  //if input is invalid stop
                     break;
                 }
                 while(end > 0){//places all the parents into arraylist
                    char parent1 = theGraph.vertexList[ theGraph.sPath[end].parentVert ].label;
                     path.add(parent1);
                     end = parent1 -65;
                }
                 Collections.reverse(path); //reverse the order of the array list
                 System.out.println("Shortest path to "+vertex+" is "+path); //display the shortest path to vertex
                 
                 System.out.print("Distance is "); //after this use book code to print shortest distance route
                 System.out.print(theGraph.vertexList[vertex-65].label + "=");
                 
                    if(theGraph.sPath[vertex-65].distance == theGraph.INFINITY)
                        System.out.print("inf");                  // inf
                    else{
                        char parent = theGraph.vertexList[ theGraph.sPath[vertex-65].parentVert ].label;
                        end = theGraph.sPath[vertex - 65].distance;  
                        System.out.print(end); 
                        System.out.print("(" + parent + ") "); 
                        System.out.println("");
                    }
               break;
 
            case 'Q':
 
               i++;
 
               break;
 
            default:
 
               System.out.print("Invalid entry\n");
 
            }  // end switch
            if(i!=0){
                System.out.println("QUIT");
                break;
            }
         }  // end while
      }  // end main()
// -------------------------------------------------------------
   public static String getString() throws IOException {
 
      InputStreamReader isr = new InputStreamReader(System.in);
 
      BufferedReader br = new BufferedReader(isr);
 
      String s = br.readLine();
 
      return s;
 
      }
 
//--------------------------------------------------------------
 
   public static char getChar() throws IOException {
 
      String s = getString().toUpperCase();
 
      return s.charAt(0);
 
      }
 

 
//-------------------------------------------------------------
 
   public static int getInt() throws IOException {
 
      String s = getString();
 
      return Integer.parseInt(s);
 
      }
}  // end class PathApp
////////////////////////////////////////////////////////////////
