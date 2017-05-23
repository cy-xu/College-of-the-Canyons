package Tree234App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Tree234App
{

    public static void main(String[] args) throws IOException
    {

        long value;

        Tree234 theTree = new Tree234();

        theTree.insert(50);

        theTree.insert(40);

        theTree.insert(60);

        theTree.insert(30);

        theTree.insert(70);

        while (true)

        {
            System.out.println("Enter q to quit or ");

            System.out.print("Enter first letter of ");

            System.out.print("change, show, insert, find or Read: ");

            char choice = getChar();

            switch (choice)
            {
                case 'q':
                    System.exit(0);
                case 'c':
                    System.out.println("Enter a value for the new ORDER");

                    int order = getInt();
                    Node.setOrder(order);
                    if (order == 4)
                    {
                        theTree = new Tree234();
                    } else if (order >= 5)
                    {
                        theTree = new BTree();
                    } else
                    {
                        System.out.println("You have entereed an invalid order. Please enter a number greater than 3.");
                        break;
                    }

                    theTree.insert(50);
                    theTree.insert(40);
                    theTree.insert(60);
                    theTree.insert(30);
                    theTree.insert(70);
                    break;

                case 'r':
                    readData();
                    //testReadData();
                    //testReadDataBTree();
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

                    if (found != -1)

                    {
                        System.out.println("Found " + value);
                    } else

                    {
                        System.out.println("Could not find " + value);
                    }

                    break;

                default:

                    System.out.print("Invalid entry\n");

            }  // end switch

        }  // end while

    }  // end main()

    
    public static void testReadData() throws FileNotFoundException {
        // Don't set order for Tree234, use default of 4
        Tree234 tree = build("data2test.txt", false);
        tree.displayTree();
    }
    
    public static void testReadDataBTree() throws FileNotFoundException {
        Node.setOrder(5); // Some higher order for testing btrees
        Tree234 tree = build("data2test.txt", true);
        tree.displayTree();
    }
    
    public static void readData() throws FileNotFoundException, IOException {
        System.out.println("What is the name of the file you wish to import?");
        String fileName = getString();
        System.out.println("The current order is " + Node.ORDER + ". Do you wish to change it? Yes or No.");
        String change = getString();
        char choice = change.toLowerCase().charAt(0);
        if (choice == 'y') {
            System.out.println("What order do you want?");
            int order = getInt();
            Node.setOrder(order);
        }
        Tree234 tree = build(fileName, true);
        tree.displayTree();
    }
    
    public static Tree234 build(String fileName, boolean createBtree) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(fileName));
        Tree234 tree = createBtree ? new BTree() : new Tree234();
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");
            String userID = parts[0].trim();
            long dData = Long.parseLong(userID);
            System.out.println("Inserting " + dData + " from record " + line);
            tree.insert(dData, line);
            tree.displayTree();
        }
        return tree;
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
        if (s == null || s.length() == 0)
        {
            return ' ';
        }
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
