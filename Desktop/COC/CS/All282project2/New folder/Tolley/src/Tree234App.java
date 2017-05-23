/*
 * COMP 282-17867 - Advanced Data Structures
 * Project 2: Tree234App
 * Programmer: Alexander Tolley
 * Date last edited: 11/16/2015
 * Description: This class is an application that creates and controls data trees.
                It initially creates a 234Tree and fills it with a few DataItems.
                The User then can show the entire tree, 
                find if an item is withing the tree, insert a new item, create 
                a new tree from scratch or using a text document, or quit.
 */
import java.io.*;

////////////////////////////////////////////////////////////////
public class Tree234App {

    public static void main(String[] args) throws IOException {
        long value = 0;
        String fileName = "", insertionDData, insertionSData;
        Tree234 theTree = new Tree234();
        Long test;

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.println("show, insert, find, or quit: ");
            System.out.println("Enter c to create new tree: ");
            System.out.println("Enter r to read text file into BTree: ");
            char choice = getChar();
            switch (choice) {
                //Displays the items within the tree.
                case 's':
                    theTree.displayTree();
                    break;
                //Inserts an int value into the tree
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                //Finds out if a certain value is within the tree
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
                //Creates a new tree.
                case 'c':
                    System.out.print("Enter new order: ");
                    value = getInt();
                    //If ORDER is 4, a 234Tree is created.
                    if (value == 4) {
                        Node.setORDER((int) value);
                        theTree = new Tree234();
                    }
                    //If ORDER is greater than 4, a BTree is created.
                    else if (value > 4) {
                        Node.setORDER((int) value);
                        theTree = new BTree();
                    } 
                    //If ORDER is less than 4, no tree is created.
                    else {
                        System.out.println("Invalid Order Entered");
                        break;
                    }
                    //Inserts some generic data into the tree.
                    for (int i = 0; i < 18; i++) {
                        theTree.insert((i + 1) * 5);
                    }
                    break;
                //Import a text document and uses the records within it to create a tree.
                case 'r':
                    System.out.print("Enter name of text file to import: ");
                    boolean loop = true;
                    //Checks to ensure that the files being entered actually exists.
                    while (loop == true) {
                        try {
                            fileName = getString();
                            RandomAccessFile check = new RandomAccessFile(fileName, "r");
                            loop = false;
                            check.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("Error: " + e);
                            System.out.print("Please enter the name of an existing file: ");
                        }
                    }
                    RandomAccessFile inout = new RandomAccessFile(fileName, "rw");
                    //Changes the order if the user wishes.
                    System.out.println("Current Order is " + Node.getORDER());
                    System.out.println("Do you wish to change the order? (y/n): ");
                    choice = getChar();
                    switch (choice) {
                        case 'y':
                            System.out.println("Enter in new ORDER: ");
                            loop = true;
                            while (loop == true) {
                                value = getInt();
                                if (value < 4) {
                                    System.out.println("Invalid ORDER entered, Enter New Valid ORDER.");
                                } else {
                                    loop = false;
                                }
                            }
                            Node.setORDER((int) value);
                            System.out.println("ORDER " + Node.getORDER() + "Entered");
                            break;
                        case 'n':
                            System.out.println("Prior ORDER kept");
                            break;
                    }
                    //Creates a new BTree
                    theTree = new BTree();
                    inout.seek(0);
                    int commaOffset;
                    loop = true;
                    //Fills out the tree with the data within the text.
                    while (loop == true) {
                        insertionSData = inout.readLine();
                        //If there is no more data to be read, the loop exits.
                        if (insertionSData == null) {
                            loop = false;
                        } else {
                            commaOffset = insertionSData.indexOf(",");
                            insertionDData = insertionSData.substring(0, commaOffset);
                            test = new Long(insertionDData);
                            theTree.insert(test, insertionSData);
                        }
                    }
                    break;
                case 'q':
                    System.exit(0);
                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()
//--------------------------------------------------------------

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
}  // end class Tree234App
 
////////////////////////////////////////////////////////////////
