/*Name: Thach Diep
 *Date: November 16, 2015
 *Description: BTreeProject main class for user interfaces 
 */
package project2.thach.diep;

import java.io.*;
import java.util.Scanner;

class Tree234App {

    private static UserInput input = new UserInput();
    private static Node node = new Node();
    private static Tree234 theTree = new Tree234();
    private static long value;

    public static void main(String[] args) throws IOException {

        char choice = ' '; //case switch choice for menu

        populate();

        while (choice != 'q') {  //menu
            System.out.print("\nCurrent ORDER: " + node.getOrder());
            System.out.print("\nEnter first letter of ");
            System.out.print("change, show, insert, find, read, or quit: ");
            choice = input.getChar();

            switch (Character.toLowerCase(choice)) { //change Order
                case 'c':
                    newOrder();
                    populate();
                    break;

                case 's': //show tree
                    theTree.displayTree();
                    break;

                case 'i':
                    System.out.print("Enter value to insert: "); //insert new items
                    value = input.getInt();
                    theTree.insert(value);
                    break;

                case 'f':
                    System.out.print("Enter value to find: "); //find item within tree
                    value = input.getInt();
                    int found = theTree.find(value);

                    if (found != -1) {
                        System.out.println("Found " + value);
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;

                case 'r': //read from text file
                    readData();
                    break;

                case 'q': //quit
                    System.out.println("Exiting program!");
                    break;
                    
                default: //pretty sure there was a mistake
                    System.out.print("Invalid entry\n");
                    break;
            }  // end switch
        }  // end while
    }  // end main()

    public static void populate() { //insert data into the tree

        System.out.print("Current ORDER: " + node.getOrder());
        System.out.print("\nEnter how many random items to populate the tree: ");
        value = input.getInt();

        for (int i = 0; i < value; i++) {
            theTree.insert((long) (Math.random() * 100));
        }
    }

    public static void newOrder() { //replace old tree with new ORDER, deleting old tree 
        System.out.print("Change the ORDER of the Tree, enter new ORDER: ");
        value = input.getInt();
        node.setOrder((int) value);
        theTree = null;
        if (value == 4) {
            theTree = new Tree234();
        } else {
            theTree = new BTree();
        }
    }

    public static void readData() { //read data from text file into the tree
       
        boolean valid = false;
        String textFile = null;
        int quit = 0;
        String choice = null;

        while (valid == false && quit != -1) { //loop until you entered -1 or entered a text file
            if (quit != 2) {
                System.out.print("Enter name of text file to be imported: (ENTER -1 to go back) ");
                textFile = input.getString();
            }

            if (textFile.equals("-1")) { //exit loop
                quit = -1;
            } else {
                try { //try catch to create file
                    File file = new File(textFile); 
                    Scanner scan = new Scanner(file);
                    theTree = null; //delete old tree and create a new tree 
                    theTree = new BTree();
                    while (scan.hasNext()) { //read entire text file
                        String[] record = scan.nextLine().split(","); //split record by each comma
                        theTree.insert((long) Integer.parseInt(record[0])); //insert key word
                        String rec = record[1] + "," + record[2] + "," + record[3] + "," + record[4] + "," + record[5]; // create a string for the rest of the record
                        theTree.insertRecord(rec); //insert string into data item
                    }

                    if (quit == 2) { //quit from looping back into changing order
                        quit = -1;
                    } else {
                        System.out.print("Current ORDER: " + node.getOrder()); //change order?
                        System.out.print("\nChange ORDER of tree? Y/N: ");
                        choice = input.getString();
                        
                        if (choice.equalsIgnoreCase("y")) { //change order
                            newOrder();
                            quit = 2;
                        } else {
                            valid = true;
                        }
                    }
                } catch (FileNotFoundException e) { //if file isn't found, rerun the method
                    System.out.println("Text file not found.");
                }
            }
        }
    }
}  // end class Tree234App