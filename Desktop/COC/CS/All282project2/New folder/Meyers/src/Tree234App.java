//Megan Meyers
//11/15/15
//class 282 project 2
//main method. includes a menu to allow you options for building, inserting, changing order, reading from text file, exit. I bypassed the get methods in this that were from the book because i have a better input class called UserInput that handles exceptions and errors. 


import java.io.*;
import java.util.*;

public class Tree234App {

    static Tree234 theTree; //easier to work with this as static, doesn't matter, only working with one tree at a time, not multiple instances

    public static void main(String[] args) throws IOException {
        long value;
        Node.setOrder();
        if (Node.getOrder() == 4) {
            theTree = new Tree234();
        } else {
            theTree = new BTree();
        }

        populate();  //use this if you want to populate quickly just using Tree234.insert(dData)

        while (true) {

            System.out.print("Enter first letter of ");
            System.out.print("show, insert, find, change order, read, quit: ");
            char choice = getChar();
            switch (choice) {
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
                    if (found != -1) {
                        System.out.println("Found " + value);
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;
                case 'q':
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
                case 'c':
                    main(null); //rebuild the tree. 
                    break;
                case 'r':
                    readData();
                    //testReadData();
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()
//--------------------------------------------------------------
//i don't like any of these get methods. I imported my UserInput class because that class has error/exception handling. This code from the book just crashes. 

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//--------------------------------------------------------------

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

//-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------

    public static void readData() throws IOException {
        System.out.println("Enter the text file to import:");
        String file;
        Scanner input;
        try {
            file = UserInput.getString();
            input = new Scanner(new File(file));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            file = UserInput.getString();
            input = new Scanner(new File(file));        
        }
        boolean end = false;
        while (end == false) {
            System.out.println("Current order of tree is: " + Node.getOrder());
            System.out.println("y to change, n to keep");
            char selection = UserInput.getChar();
            if (selection == 'y') {
                Node.setOrder();
                if (Node.getOrder() == 4) {
                    theTree = new Tree234();
                } else {
                    theTree = new BTree();
                }
                System.out.println("Order set to : " + Node.getOrder());
                end = true;
            } else if (selection == 'n') {
                if (Node.getOrder() == 4) {   //this if else is here again to make sure that u clear any old tree data when you read your file
                    theTree = new Tree234();
                } else {
                    theTree = new BTree();
                }               
                end = true;
            } else {
                System.out.println("Invalid selection");
                end = false;
            }
        }
       
        input.useDelimiter(",");
        while (input.hasNext()) {            
            theTree.insert(input.nextInt(), input.nextLine());            
        }
        input.close();
    }//end readData    

//------------------------------------------------------------------    
    public static void testReadData() throws IOException { //automate the testing process so you don't have do any keyboard inputs. 
        Scanner input = new Scanner(new File("testreaddata.txt"));
        input.useDelimiter(",");
        while (input.hasNext()) {
            theTree.insert(input.nextInt(), input.nextLine());
        }
        theTree.displayTree();
        input.close();
    }

//------------------------------------------------------------------    
    public static void populate() {
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        theTree.insert(45);
        theTree.insert(35);
        theTree.insert(25);
        theTree.insert(75);
        theTree.insert(15);
        theTree.insert(65);
        theTree.insert(80);
        theTree.insert(10);
        theTree.insert(23);
        theTree.insert(33);
        theTree.insert(53);
    }
//------------------------------------------------------------------
}  // end class Tree234App

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* record of changes i made to the book code:
 1. took final off of order
 2. added get and set methods for order
 3. added dataitem variable record
 4. added get and set methods for record
 5. added some menu options (quit, change order, read)
 6. overloaded the insert method to also pass record as parameter and added one line of code to set the record. 
 7. made variable theTree static and placed it outside of main. 
 8. changed root variable to protected status (instead of private)
 9. imported my user input class and bypassed the inadequate get methods in this class. 

 most of these changes were in the project directions. My changes are 6,7, and 9. 

 Current status notes:
 1. when testing there is still an issue/problem with changing the order. currently if someone changes order it goes to main to restart
 probably need to make that better. i assumed changing order means rewriting the tree? or just changing it from then on???? 
 order changes from x>=5 to x >= 6 technically don't need to be recreated. all the nodes will simply not be full yet. but other changes of order would definately need the tree to be rebuilt.   
 2. Need to put header and comments at the top of each class


 */
