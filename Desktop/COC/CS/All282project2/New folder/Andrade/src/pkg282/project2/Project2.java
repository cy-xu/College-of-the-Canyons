/* Monica Andrade
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg282.project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Monica
 */

public class Project2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
       public static void main(String[] args) throws IOException
 
      {
 
      long value;
      int order;
 
      Tree234 theTree = new Tree234();
      
      
 

 
      theTree.insert(50);
 
      theTree.insert(40);
 
      theTree.insert(60);
 
      theTree.insert(30);
 
      theTree.insert(70);
 

 
      while(true)
 
         {
 
         System.out.print("Enter first letter of ");
 
         System.out.print("show, insert, find, change, read, or quit: ");
 
         char choice = getChar();
 
         switch(choice)
 
            {
 
            case 's':
 
               theTree.displayTree();
 
               break;
 
            case 'i':
 
               System.out.print("Enter value to insert: ");
 
               value = getInt();
 
               theTree.insert(value);
 
               break;
 
            case 'f':
 
               System.out.print("Enter value to find: ");
 
               value = getInt();
 
               int found = theTree.find(value);
 
               if(found != -1)
 
                  System.out.println("Found "+value);
 
               else
 
                  System.out.println("Could not find "+value);
 
               break;
            
            
            case 'c':
                System.out.println("Enter order to be changed ");
                
                order = getInt();   
            
                break;
                
            case 'r':
                
                
                
                break;
                
            case 'q':
                  System.exit(0);
                break;
            
 
            default:
 
               System.out.print("Invalid entry\n");
                
            
 
            }  // end switch
 
         }  // end while
 
      }  // end main()
 
//--------------------------------------------------------------
 
   public static String getString() throws IOException
 
      {
 
      InputStreamReader isr = new InputStreamReader(System.in);
 
      BufferedReader br = new BufferedReader(isr);
 
      String s = br.readLine();
 
      return s;
 
      }
 
//--------------------------------------------------------------
 
   public static char getChar() throws IOException
 
      {
 
      String s = getString();
 
      return s.charAt(0);
 
      }
 

 
//-------------------------------------------------------------
 
   public static int getInt() throws IOException
 
      {
 
      String s = getString();
 
      return Integer.parseInt(s);
 
      }
 
//-------------------------------------------------------------
}
    


    
    

