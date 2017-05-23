/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package black.project2;

// tree234.java
// demonstrates 234 tree
// to run this program: C>java Tree234App
import java.io.*;
import java.util.Scanner;

////////////////////////////////////////////////////////////////
public class Tree234App {

    private static Tree234 theTree;

    public static void main(String[] args) throws IOException {

        long value;
        boolean runLoop = true;

        theTree = new Tree234();

        setupTestTree(theTree);

        while (runLoop) {
            System.out.print("Enter first letter of ");
            System.out.print("'s'how, 'i'nsert, 'f'ind, 'c'hange order, 'r'ead file, or 'q'uit: ");

            char choice = getChar();
            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;

                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getLong();
                    theTree.insert(value);
                    break;

                case 'f':
                    System.out.print("Enter value to find: ");
                    value = -1;
                    try {
                        value = getLong();
                    }
                    catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    if (value == -1)
                        break;
                    int found = theTree.find(value);
                    if (found != -1) {
                        System.out.println("Found " + value);
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;

                case 'c':
                    setOrder();
                    setupTestTree(theTree);
                    break;

                case 'r':
                    //testReadData();
                    readData();
                    break;

                case 'q':
                    runLoop = false;
                    break;

                default:
                    System.out.println("Invalid entry :-(");

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
    public static long getLong() throws IOException {
        String s = getString();
        return Long.parseLong(s);
    }

//-------------------------------------------------------------
    // a default values setup method
    // should be used to setup the initial tree,
    //    and again whenever the order of the tree is changed.
    public static void setupTestTree(Tree234 theTree) {
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        theTree.insert(20);
        theTree.insert(80);
        theTree.insert(10);
        theTree.insert(90);
        theTree.insert(00);
        /* 
        // these were helpful in testing, but feel excessive in normal runs
        theTree.insert(55);
        theTree.insert(45);
        theTree.insert(65);
        theTree.insert(35);
        theTree.insert(75);
        theTree.insert(25);
        theTree.insert(85);
        theTree.insert(15);
        theTree.insert(95);
        theTree.insert(05);
        theTree.insert(52);
        theTree.insert(42);
        theTree.insert(62);
        theTree.insert(32);
        theTree.insert(72);
        theTree.insert(22);
        theTree.insert(82);
        theTree.insert(12);
        theTree.insert(92);
        theTree.insert(02);
        */
        
    }

    public static void setOrder() {
        System.out.print("Current order: " + Node.getOrder() + ". Enter a new order: ");
        long value = 0;
        try {
             value = getLong();
        }
        catch (Exception e) {}
        if (value < 4) {
            System.out.println("Invalid order. Order unchanged.");
        } else if (value == 4) {
            Node.setOrder((int)value);
            theTree = new Tree234();
        } else {
            Node.setOrder((int)value);
            String rework = "";
            do {
                System.out.println("BTree Selected. Split like a traditional BTree - after attempting to insert into full node? ('y' or 'n')");
                try {
                    rework = getString();
                } catch (Exception e) {
                }
            } while (!(rework.equalsIgnoreCase("y") || rework.equalsIgnoreCase("n")));
            
            if (rework.equals("y"))
                theTree = new ActualBTree();
            else
                theTree = new BTree();
        }
    }

    public static void readData() {
        System.out.println("Enter the name of the file to read:");
        Scanner txtread = null;
        String filename = "";
        try {
            filename = getString();
            txtread = new Scanner(new File(filename));
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
        if (txtread == null) {
            return;
        }

        String rework = "";
        do {
            System.out.println("Current tree order: " + Node.getOrder() + ". Do you want to change the order? ('y' or 'n')");
            try {
                rework = getString();
            } catch (Exception e) {
            }
        } while (!(rework.equalsIgnoreCase("y") || rework.equalsIgnoreCase("n")));

        if (rework.equalsIgnoreCase("y")) {
            try {
                setOrder();
            } catch (Exception e) {
            }
        }

        while (txtread.hasNextLine()) {
            String rec = txtread.nextLine();
            String idsub = rec.substring(0, rec.indexOf(","));
            long id = Long.parseLong(idsub);
            DataItem temp = new DataItem(id, rec);
            theTree.insert(temp);
        }

        theTree.displayTree();

    }

    public static void testReadData() {
        Scanner txtread = null;
        try {
            txtread = new Scanner(new File("data2.txt"));
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.toString());
        }
        if (txtread == null) {
            return;
        }

        Node.setOrder(8);
        theTree = new BTree();
        //theTree = new ActualBTree();

        for (int i = 0; i < 20; i++) {
            String rec = txtread.nextLine();
            String idsub = rec.substring(0, rec.indexOf(","));
            long id = Long.parseLong(idsub);
            DataItem temp = new DataItem(id, rec);
            theTree.insert(temp);
        }

        theTree.displayTree();

    }

//-------------------------------------------------------------
}  // end class Tree234App
 
////////////////////////////////////////////////////////////////
