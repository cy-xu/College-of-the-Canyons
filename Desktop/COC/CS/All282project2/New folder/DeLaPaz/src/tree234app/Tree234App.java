/*
 * Raymond De La Paz
 * 11/17/15
 * CS282
 * The program allows for a 234Tree or BinaryTree to be created sorting the 
 * inputs. When changing the order from a 234Tree to a BTree the keys clear and
 * allowing for new keys to be sorted. The insert command on the menu allows for
 * the keys to be inserted and show the number of items moved. But since the 
 * key is inserted after split it will not show up on items moved. To see the 
 * the tree the show command on the main menu gives a print out of the keys and 
 * their levels. When reading a file the initial propt to ask for a file name
 * when inserted it it inserts the keys and stores the full lines in the file on
 * a string. 
 */
package tree234app;

import java.io.*;
import java.util.Scanner;

public class Tree234App {

    public static void main(String[] args) throws IOException {

        int change;

        long value;

        String filename;

        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        while (true) {

            System.out.print("Enter first letter of ");

            System.out.print("show, insert, find, change order, read a file or quit: ");

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

                case 'c':

                    System.out.println("Enter ORDER : ");

                    change = getInt();

                    if (change > 4) {

                        theTree = new BTree(change);
                        
                         theTree.insert(50);
                         theTree.insert(40);
                         theTree.insert(60);
                         theTree.insert(30);
                         theTree.insert(70);
                         theTree.insert(80);
                         theTree.insert(90);
                         theTree.insert(20);

                    }

                    break;

                case 'r':

                    readData(theTree);

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

    public static void readData(Tree234 theTree) throws IOException {
        int value;
        System.out.println("Enter the file name: ");
        String filename = getString();

        System.out.println("Current Order: 4");



        File file = new File(filename);

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            filename = sc.nextLine();

            Scanner temp = new Scanner(filename);
            temp.useDelimiter(",");
            Long binsert = temp.nextLong();
            theTree.insert(binsert, filename);

        }

        sc.close();

    }
//-------------------------------------------------------------

}  // end class Tree234App
