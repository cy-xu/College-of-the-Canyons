/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree234app;
import java.io.*;
/**
 *
 * @author justinstoner
 */
public class Tree234App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        long value;
 
      Tree234 theTree = new Tree234();
 

 
      theTree.insert(50);
 
      theTree.insert(40);
 
      theTree.insert(60);
 
      theTree.insert(30);
 
      theTree.insert(70);
 

 
      while(true)
 
         {
 
         System.out.print("Enter first letter of ");
 
         System.out.print("show, insert, find, change order, or quit: ");
 
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
                System.out.println("Enter an order, 4 or greater");
                int order = getInt();
                if(order > 4){
                    System.out.println(order);
                    Node.setOrder(order);
                    theTree = new BTree();
                }
                else if(order == 4)
                    System.out.println(order + " 234 tree");
                else
                    System.out.println("value must be 4 or greater");
                break;
                
            case 'q':
                
                return;
 
            default:
 
               System.out.print("Invalid entry\n");
 
            }  // end switch
 
         }  // end while
    }
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
