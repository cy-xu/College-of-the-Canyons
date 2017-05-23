import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList; 
import java.awt.Color; 
public class ZBug extends Bug
{
     private int steps; 
     private int sideLength; 
     private int count;
     
     public ZBug(int length) 
     { 
       
         steps = 0; 
         count = 0;
         sideLength = length; 
         setDirection(90);
     } 
     public void act()
     {
         if (steps < sideLength && canMove())
         {
             move();
             steps++;
         }
         else if (steps == sideLength)
         {
             setDirection(235);
             if (canMove())
             {
                 move();
             }
             steps++;
         }
         else if (steps < sideLength * 2 && canMove()) 
         {
             move();
             steps++;
         }
         else if (steps == sideLength * 2 )
         {
             setDirection(90);
             if (canMove())
             {
                 move();
             }
             steps++;
         }
         else if ( steps < sideLength * 3 && canMove())
         {
             move();
             steps++;
         }
     }
}
