/* 
 * Author: Aaron Black, based on code by Robert LaFore
 * Course: CmpSci 282
 * Description: Graph object based on code provided by Robert LaFore. Expanded object
 *     includes new methods to add, change, and delete edges, as well as an extended 
 *     find path method to display all steps to a selected vertex. Methods additionally
 *     refined with updated exception handing.
 * Last Modified: 19 November 2015
 */
package pathapp;

import java.io.Serializable;

public class Graph implements Serializable {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private final Vertex vertexList[]; // list of vertices
    private final int adjMat[][];      // adjacency matrix
    private int nVerts;          // current number of vertices
    private int nTree;           // number of verts in tree
    private final DistPar sPath[];     // array for shortest-path data
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

    // function to add an edge to the graph. 
    // assumes startIndex and endIndex have already been determined via getVertexIndex, 
    public void addEdge(int startIndex, int endIndex, int weight) throws Exception {
        // check if weight is unsupported, and throw an exception if it isn't
        if (weight < 0) {
            throw new Exception("Graph does not support negative path weights.");
        }
        // check if the edge already exists, and throw an exception if it does
        if (adjMat[startIndex][endIndex] != INFINITY) {
            throw new Exception("Edge already exists.");
        }
        // if you haven't thrown an exception, it's a good edge so update the adj mat to add it.
        adjMat[startIndex][endIndex] = weight;
    }

    // function to change an existing edge in the graph
    // assumes startIndex and endIndex have already been determined via getVertexIndex, 
    public void changeEdge(int startIndex, int endIndex, int weight) throws Exception {
        // check if weight is unsupported, and throw an exception if it isn't
        if (weight < 0) {
            throw new Exception("Graph does not support negative path weights.");
        }
        // check if the edge already exists, and throw an exception if it doesn't 
        if (adjMat[startIndex][endIndex] == INFINITY) {
            throw new Exception("Edge does not exist to modify.");
        }
        // if you haven't thrown an exception, it's a good edge so update the adj mat
        adjMat[startIndex][endIndex] = weight;

    }

    // assumes startIndex and endIndex have already been determined via getVertexIndex, 
    public void deleteEdge(int startIndex, int endIndex) throws Exception {
        // check if the edge already exists, and throw an exception if it doesn't 
        if (adjMat[startIndex][endIndex] == INFINITY) {
            throw new Exception("Edge does not exist to delete.");
        }
        // if you haven't thrown an exception, it's a good edge so update the adj mat to remove it
        adjMat[startIndex][endIndex] = INFINITY;

    }

// -------------------------------------------------------------
    
    // new helper method to be called when you wnat to diplay the path to the selected target vertex
    public void path(int targetIndex) throws Exception {
        // do standard path stuff
        path();
        // display the path to the selected target vertex
        targetTree(targetIndex);
    }

    // unchanged from source
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

    // unchaned from source
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

    // unchanged from source
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

    // unchanged from source
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

    // function to display the path from the path from the starting vertex to the selected target vertex
    // assumes startIndex and endIndex have already been determined via getVertexIndex, 
    public void targetTree(int targetIndex) throws Exception {
        // index of starting vertex
        int startIndex = getVertexIndex('A');
        // tracking variable for parent vertices
        int nextIndex;

        // since i'm doing string manip, I'm using a string builder rather than regular strings.
        // this is a slightly ugly way to do front end string insertion, 
        //     but it works to display the path without using a temp storage like a stack or an array
        StringBuilder path = new StringBuilder((targetIndex == startIndex ? "" : "  ->  ") + vertexList[targetIndex].label);
        StringBuilder prepend;
        while (targetIndex != startIndex) {
            nextIndex = sPath[targetIndex].parentVert;
            prepend = new StringBuilder((nextIndex == 0 ? "" : "  ->  ") + vertexList[nextIndex].label);
            path = prepend.append(path);
            targetIndex = nextIndex;
        }
        System.out.println(path.toString());

    }
// -------------------------------------------------------------

    
    // function to determine the index of a vertex based on its character label
    // assumes graph only contains upper case labels
    public int getVertexIndex(char vertex) throws Exception {
        int targetIndex = -1, i = 0;
        vertex = Character.toUpperCase(vertex);

        while (targetIndex < 0 && i < vertexList.length && vertexList[i] != null) {
            if (vertexList[i].label == vertex) {
                targetIndex = i;
            }
            i++;
        }

        if (targetIndex == -1) {
            throw new Exception("Vertex not found.");
        }

        return targetIndex;
    }

}  // end class Graph
