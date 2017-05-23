/*Daniel Price
Computer Science 256 Project 2
234-Tree and B-Tree
11/17/2015
This program is designed to build a proper working 234-Tree.  The B-Tree is not a complete B-Tree as it still
has the same characteristics as a 234-Tree, but the split node method was changed in the B-Tree class.
 */
package tree234app;
import java.io.*;
/**
 *
 * @author daniel
 */
public class Tree234App {

  
    public static void main(String[] args) throws IOException {
        Tree234 theTree;
      long value;
      Node neworder = new Node();
        System.out.print("Enter order of tree: ");
      int values = getInt();
      neworder.setOrder(values);
        int order = neworder.getOrder();
        if(order <=4)
     theTree = new Tree234();
        else
            theTree = new BTree();
     theTree.insert(50);
 
     theTree.insert(40);
 
     theTree.insert(60);
 
     theTree.insert(30);
 
      theTree.insert(70);
        while(true)
 
         {
 
         System.out.print("Enter first letter of ");
 
         System.out.print("show, insert, find, change, or quit: ");
 
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
                System.out.print("Enter new tree order: ");
                int newvalue = getInt();
               neworder.setOrder(newvalue);
               break;
            case 'q':
                System.out.println("Goodbye");
                return;
 
            default:
 
               System.out.print("Invalid entry\n");
 
            }  // end switch
 
         }  // end while
 
      }  // end main()
    
    public static String getString() throws IOException
 
      {
 
      InputStreamReader isr = new InputStreamReader(System.in);
 
      BufferedReader br = new BufferedReader(isr);
 
      String s = br.readLine();
 
      return s;
 
      }
    public static char getChar() throws IOException
 
      {
 
      String s = getString();
 
      return s.charAt(0);
 
      }
    public static int getInt() throws IOException
 
      {
 
      String s = getString();
 
      return Integer.parseInt(s);
 
      }
    }
    

