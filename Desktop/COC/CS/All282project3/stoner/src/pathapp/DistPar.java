/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathapp;

/**
 *
 * @author justinstoner
 * name: justin stoner
 * date: 12/3/15
 * class: cs282
 * project info: console program for creating a graph
 */
public class DistPar {
    public int distance; // distance from start to this vertex
    public int parentVert; // current parent of this vertex
    // -------------------------------------------------------------
    public DistPar(int pv, int d) // constructor
    {
    distance = d;
    parentVert = pv;
    }
}
