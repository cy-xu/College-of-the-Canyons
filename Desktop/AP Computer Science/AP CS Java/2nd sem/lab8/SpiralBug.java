import info.gridworld.actor.*;
import info.gridworld.grid.*; 
import java.util.ArrayList; 
import java.awt.Color;
public class SpiralBug extends Bug
{
     private int steps; 
     private int sideLength; 
     
     
     public SpiralBug(int length) 
     { 
         steps = 0; 
         sideLength = length; 
     } 
     
     
     public void act() 
     { 
         if (steps < sideLength && canMove()) 
         { 
             move(); 
             steps++; 
         } 
         else 
         { 
             turn();  
             turn();
             sideLength += 1;
             steps = 0; 
         } 
     } 
}
