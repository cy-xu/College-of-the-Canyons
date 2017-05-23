package Project3;
/*
 * COMP 282-17867
 * Project 3: Graph
 * Programmer: Alexander Tolley
 * Date last edited: 12/03/2015
 * Description: This class represent a directed weighted graph. This code is 
 *              left as-is from the book, with three methods added at the end of 
 *              the class.
 */

import java.io.Serializable;

public class Graph implements Serializable {

    private final int MAX_VERTS = 20;
    protected final int INFINITY = 1000000;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][];      // adjacency matrix
    private int nVerts;          // current number of vertices
    private int nTree;           // number of verts in tree
    private DistPar sPath[];     // array for shortest-path data
    private int currentVert;     // current vertex
    private int startToCurrent;  // distance to currentVert
// -------------------------------------------------------------

    public Graph() // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for (int j = 0; j < MAX_VERTS; j++) // set adjacency
        {
            for (int k = 0; k < MAX_VERTS; k++) //     matrix
            {
                adjMat[j][k] = INFINITY;     //     to infinity
            }
        }
        sPath = new DistPar[MAX_VERTS];    // shortest paths
    }  // end constructor
// -------------------------------------------------------------

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }
// -------------------------------------------------------------

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;  // (directed)
    }
// -------------------------------------------------------------

    public void path() // find all shortest paths
    {
        int startTree = 0;             // start at vertex 0
        vertexList[startTree].isInTree = true;
        nTree = 1;                     // put it in tree

        // transfer row of distances from adjMat to sPath
        for (int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree, tempDist);
        }

        // until all vertices are in the tree
        while (nTree < nVerts) {
            int indexMin = getMin();    // get minimum from sPath
            int minDist = sPath[indexMin].distance;

            if (minDist == INFINITY) // if all infinite
            {                        // or in tree,
                System.out.println("There are unreachable vertices");
                break;                   // sPath is complete
            } else {                        // reset currentVert
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
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].isInTree = false;
        }
    }  // end path()
// -------------------------------------------------------------

    public int getMin() // get entry from sPath
    {                              //    with minimum distance
        int minDist = INFINITY;        // assume minimum
        int indexMin = 0;
        for (int j = 1; j < nVerts; j++) // for each vertex,
        {                           // if it's in tree and
            if (!vertexList[j].isInTree && // smaller than old one
                    sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j;            // update minimum
            }
        }  // end for
        return indexMin;               // return index of minimum
    }  // end getMin()
// -------------------------------------------------------------

    public void adjust_sPath() {
        // adjust values in shortest-path array sPath
        int column = 1;                // skip starting vertex
        while (column < nVerts) // go across columns
        {
            // if this column's vertex already in tree, skip it
            if (vertexList[column].isInTree) {
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
            if (startToFringe < sPathDist) // if shorter,
            {                            // update sPath
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }  // end while(column < nVerts)
    }  // end adjust_sPath()
// -------------------------------------------------------------

    public void displayPaths() {
        for (int j = 0; j < nVerts; j++) // display contents of sPath[]
        {
            System.out.print(vertexList[j].label + "="); // B=
            if (sPath[j].distance == INFINITY) {
                System.out.print("inf");                  // inf
            } else {
                System.out.print(sPath[j].distance);      // 50
            }
            char parent = vertexList[sPath[j].parentVert].label;
            System.out.print("(" + parent + ") ");       // (A)
        }
        System.out.println("");
    }
    //End of Book Code
// -------------------------------------------------------------
    //This method check is an edge is present between two vertices.
    //Returns false if there is no edge, true otherwise.

    public boolean checkEdge(int firstVertex, int secondVertex) {
        if (adjMat[firstVertex][secondVertex] == INFINITY) {
            return false;
        } else {
            return true;
        }
    }
// -------------------------------------------------------------    
    //This method finds the vertices that need to be traverced on the route to 
    //the vertex that is being sent to the method. It then prints that path to 
    ///the console.

    public void findPath(int vertex) {
        int currentVertex = vertex;
        String pathToVertex = vertexList[currentVertex].label + "";
        while (sPath[currentVertex].distance != INFINITY) {
            currentVertex = sPath[currentVertex].parentVert;
            pathToVertex += " >-- " + vertexList[currentVertex].label;
        }
        StringBuilder toPrint = new StringBuilder(pathToVertex);
        System.out.print(toPrint.reverse());
        System.out.println();

    }
// --------------------------------------------------------------
    //This method is the same as the path() method with one exception: it does
    //not display the contents of sPath[] at the end of the method.
    public void pathSansDisplay() // find all shortest paths
    {
        int startTree = 0;             // start at vertex 0
        vertexList[startTree].isInTree = true;
        nTree = 1;                     // put it in tree

        // transfer row of distances from adjMat to sPath
        for (int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree, tempDist);
        }

        // until all vertices are in the tree
        while (nTree < nVerts) {
            int indexMin = getMin();    // get minimum from sPath
            int minDist = sPath[indexMin].distance;

            if (minDist == INFINITY) // if all infinite
            {                        // or in tree,
                System.out.println("There are unreachable vertices");
                break;                   // sPath is complete
            } else {                        // reset currentVert
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
        
        nTree = 0;                     // clear tree
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].isInTree = false;
        }
    }  // end path()
}  // end class Graph
