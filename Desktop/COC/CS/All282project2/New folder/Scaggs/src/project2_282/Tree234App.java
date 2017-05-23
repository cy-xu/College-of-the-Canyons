package project2_282;
// tree234.java
// demonstrates 234 tree
// to run this program: C>java Tree234App
import java.io.*;
import java.util.Scanner;
////////////////////////////////////////////////////////////////
public class Tree234App {
    public static void main(String[] args) throws IOException {
        Tree234 theTree;
        while (true) {
            System.out.print("Set tree order (4-8): ");
            int orderNum = getInt();
            if (Node.getOrder() == 4) {
                Node.setOrder(orderNum);
                theTree = new Tree234();
                System.out.println(Node.getOrder());
                break;
            }
            else if (orderNum > 4 && orderNum <= 8) {
                Node.setOrder(orderNum);
                theTree = new BTree();
                System.out.println(Node.getOrder());
                break;
            }
            else {
                System.out.println("Invalid entry");
            }
        }
        long value;
//        theTree.insert(50);
//        theTree.insert(40);
//        theTree.insert(60);
//        theTree.insert(30);
//        theTree.insert(70);
//        theTree.insert(20);
//        theTree.insert(80);
//        theTree.insert(10);
//        theTree.insert(90);
        loop: while(true) {
            System.out.print("Enter first letter of show, insert, find, change order (Destructive), read file, or quit: ");
            char choice = getChar();
            switch(choice) {
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
//                case 'c':
//                    System.out.print("What would you like to change the order to?: ");
//                    Node.setOrder(getInt());
////                    int orderChoice = getInt();
//                    break;
                case 'r':
                    readData(theTree);
                    break;
                case 'q':
                    break loop;
                default:
                System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()
    //--------------------------------------------------------------
    public static void readData (Tree234 theTree) throws IOException {
        System.out.print("What is the name of the file?:");
        String fileName = getString();
        loop: while (true) {
            System.out.print("Current order of the tree: " + Node.getOrder() + "\nDo you want to change the order? 'y'es or 'n'o: ");
            switch (getChar()) {
                case 'y':
                    while (true) {
                        System.out.print("Set tree order (4-8): ");
                        int orderNum = getInt();
                        if (Node.getOrder() == 4) {
                            Node.setOrder(orderNum);
                            theTree = new Tree234();
                            System.out.println(Node.getOrder());
                        }
                        else if (orderNum > 4 && orderNum <= 8) {
                            Node.setOrder(orderNum);
                            theTree = new BTree();
                            System.out.println(Node.getOrder());
                            break;
                        }
                        else {
                            System.out.println("Invalid entry");
                        }
                    }
                    break loop;
                case 'n':
                    break loop;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        int count = 0;
        while (in.hasNextLine()) {
            String newRecord = in.nextLine();
            String[] newRecordArray = newRecord.split(",", 2);
//            System.out.println(newRecordAr4ray[0]);
            theTree.insert(Integer.parseInt(newRecordArray[0]));
            count++;
        }
    }
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