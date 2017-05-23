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
public class Vertex {
    public char label; // label (e.g. ‘A’)
    public boolean isInTree;
    // -------------------------------------------------------------
    public Vertex(char lab) // constructor
    {
    label = lab;
    isInTree = false;
    }
}
