/*
Brian Dimaculangan
November 17, 2015
CS282 Advanced Data Structures Project 1
Description: This class contains the main method. It prompts the user to make 
    a selection and calls on methods from other classes to build or break down
    the tree. Also allows you to change order.
 */

import java.io.*;
 
public class Tree234App
{
    public static void main(String[] args) throws IOException
    {
        boolean loop = true;
        long value;
        Tree234 theTree = new Tree234();
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        
        while(loop)
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
                System.out.print("Enter value for new order: ");
                value = getInt();
                Node.setOrder(value);
                if(value == 4)
                    theTree = new Tree234();
                else if(value > 4)
                    theTree = new BTree((int) value);
                else
                    System.out.println("Invalid Entry! Order did not change");
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
                break;
                    
                case 'q':
                loop = false;
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
}  // end class Tree234App