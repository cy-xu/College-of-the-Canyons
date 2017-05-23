/*
 * NAME: Nicole Stone
 * Date: 11/18/15
 * Project: Project 3 - Weighted Graphs
 * Description: 
 * Code from book used to develop graph objects
 * 
 */
package pathapp;

/**
 *
 * @author Nicole
 */
public class Graph implements java.io.Serializable {
    /* **** CLASS VARIABLES **** */

    private final int MAX_VERTS = 20;
    protected final int INFINITY = 1000000;
    private Vertex vertexList[]; // list of vertices
    protected int adjMat[][];      // adjacency matrix
    private int nVerts;          // current number of vertices
    private int nTree;           // number of verts in tree
    private DistPar sPath[];     // array for shortest-path data
    private int currentVert;     // current vertex
    private int startToCurrent;  // distance to currentVert
    char previousVertex;

    /* **** METHODS **** */
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

    public void path(int slot) // find all shortest paths
    {
        int i = 0;
        int k = 0;
        int parentPath[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        char shortestPath[] = new char[nVerts];
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

        parentPath[i++] = slot;
        while (slot != 0) {
            parentPath[i++] = sPath[slot].getParent();
            slot = sPath[slot].getParent();
        }

        displayPaths();  // display sPath[] contents
        
        /* **** UPDATED DISPLAY **** */
        String s = "";
        for (int j = 4; j >= 0; j--) {
            if (parentPath[j] < 0) {
            } //nop
            else {
                previousVertex = intToCharVertex(parentPath[j]);
                shortestPath[k++] = previousVertex;
                s += previousVertex;
                if ((j) > 0) {
                    s += " --> "; //probably a high overhead solution, but there are at most 5 calls, so it's happening.
                }
            }
        }
        System.out.println(s); //end display for Fergie

        nTree = 0; // clear tree
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
// -------------------------------------------------------------

    public static char intToCharVertex(int vertex) {
        char letter = (vertex == 0) ? 'A' : (vertex == 1) ? 'B' : (vertex == 2) ? 'C'
                : (vertex == 3) ? 'D' : (vertex == 4) ? 'E' : 'Z';
        return letter;
    }
}  // end class Graph
