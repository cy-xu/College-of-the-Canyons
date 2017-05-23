/*
 * NAME: Nicole Stone
 * Date: 10/20/15
 * Project: Project 2 - 234 Trees & B Trees
 * Description: Creates a 234 or B tree and populates it with vaules
 * The program also includes basic find, insert, delete, split methods
 */
package tree234app;

/**
 *
 * @author Nicole
 */
import java.io.*;
import java.util.Scanner;

public class Tree234App {

    public static void main(String[] args) throws IOException {

        long value;
        char choice = 'a';
        Tree234 theTree;
                
        changeOrder();

        if (Node.getOrder() == 4) {
            theTree = new Tree234();
        } else {
            theTree = new BTree();
        }

        theTree.insert(50);

        theTree.insert(40);

        theTree.insert(60);

        theTree.insert(30);

        theTree.insert(70);
        
        while (choice != 'q') {

            System.out.print("Enter first letter of ");

            System.out.print("show, insert, find, change, read, or quit: ");

            choice = getChar();

            switch (choice) {

                case 's': //show the tree

                    theTree.displayTree();

                    break;

                case 'i': //insert a value

                    System.out.print("Enter value to insert: ");

                    value = getInt();

                    theTree.insert(value);

                    break;

                case 'f': //find a key

                    System.out.print("Enter value to find: ");

                    value = getInt();

                    int found = theTree.find(value);

                    if (found != -1) {
                        System.out.println("Found " + value);
                    } else {
                        System.out.println("Could not find " + value);
                    }

                    break;

                case 'c': //change order of tree
                    changeOrder();

                    break;

                case 'r': // read text file

                    readData();

                    break;

                case 'q': //quit program
                    System.out.println("Exiting program. ");

                    break;

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

    public static void changeOrder() { //takes user input to reset order of tree
        System.out.println("Please enter the order of your new tree: ");
        int num = UserInput.getInt(4, 10);
        Node.setOrder(num);
    }
//-------------------------------------------------------------
    //When the user enters 'r' to read, call a method named 'readData' that does the following: 
    //#1 Ask them the name of the text file to import. 
    //#2 Print the current order of the tree and ask the 'Y'es or 'N'o do you want to change the order. 
    //#3 If 'Y'es, ask them for the new order of the tree. 
    //#4 Build a BTree in memory out of the data read from the named text file.

    public static BTree readData() {
        BTree fileTree = new BTree();
        System.out.println("Please enter the name of the file you would like to import: ");
        String filename = UserInput.getString();
        File file = new File(filename);

        System.out.println("The current order is set to " + Node.ORDER
                + ". Would you like to change the order? Please type Y for yes and N for no: ");

        char response = UserInput.getChar();
        if (response == 'Y') {
            changeOrder();
        }

        try {

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                DataItem fileRecord = new DataItem(s.nextLong());
                System.out.println(fileRecord.dData); //needs updating!!!!!
                fileRecord.setRecord(fileRecord.dData + s.nextLine());
                fileTree.insert(fileRecord);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileTree;
    } //end readData

    //---------------------------------------------------------------
    public static void testreadData() {
        //hard code a filename and order so you can test with no extra keyboard input & display
        BTree fileTree = new BTree();
        File file = new File("data2.txt");
        Node.setOrder(5);

        try {

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                String temp = s.nextLine();
                String id = temp.substring(0, temp.indexOf(","));
                long key = Long.parseLong(id);
                DataItem fileRecord = new DataItem(key);
                System.out.println(fileRecord.dData); //needs updating!!!!!
                fileRecord.setRecord(temp);
                fileTree.insert(fileRecord);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileTree.displayTree();

    } //end testreadData
}  // end class Tree234App
 
////////////////////////////////////////////////////////////////
