/*Gianni Lane
 * Nov 5, 2015 
 * CS 282 Lab Project
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.*;
 
public class Tree234App{
 
   public static void main(String[] args) throws IOException{
         
      long value;
 
      Tree234 theTree = new Tree234();
 
      theTree.insert(50);
 
      theTree.insert(40);
 
      theTree.insert(60);
 
      theTree.insert(30);
 
      theTree.insert(70);
 

 
      while(true){
 
         System.out.print("Enter first letter of change, show, insert, find, or quit: ");
         int i = 0;
         char choice = getChar();
 
         switch(choice){
 
             case 'c':
                 System.out.println("Enter the Order number ");
                 int newOrder = getInt();
                 if(newOrder > 4){
                     
                    Node obj = new Node();
                     
                    obj.setOrder(newOrder); //changes order 
                    
                    theTree = new BTree(); //creates BTree obj
                    
                    //theTree.insert(50);
                    //theTree.insert(40);
                    //theTree.insert(60);
                    //theTree.insert(30);
                    //theTree.insert(70);
                    //theTree.insert(72);   //inserts for testing
                    //theTree.insert(77);
                    //theTree.insert(88);
                    //theTree.insert(89);
                    //theTree.insert(99);
                    //theTree.insert(100);
                }
             break;
             
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
 
            case 'q':
 
               i++;
 
               break;
 
            default:
 
               System.out.print("Invalid entry\n");
 
            }  // end switch
            if(i!=0){
                System.out.println("QUIT");
                break;
            }
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
 
   }  // end class Tree234App
 
////////////////////////////////////////////////////////////////
