/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pathapp;

/**
 * @author Nicole Garcia 
 * December 3, 2015 
 * CSC 282 Project # 3 
 */
 class DistPar {                      // items stored in sPath array

        public int distance;   // distance from start to this vertex
        public int parentVert; // current parent of this vertex
// -------------------------------------------------------------

        public DistPar(int pv, int d) { // constructor
        
            distance = d;
            parentVert = pv;
        }
// -------------------------------------------------------------
    }  // end class DistPar
///////////////////////////////////////////////////////////////
