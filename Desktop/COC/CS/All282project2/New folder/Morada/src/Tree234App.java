/*Programmer: Brent Morada
Date: 11/16/2015
Project: CS_282_Project2
Description: Inherit 234-Tree code, and make a split method that essentially makes it act like a B-tree.
Then, add file reading capability.
*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree234App {

    ////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws IOException {

        long value;

        String s;

        Tree234 theTree = new Tree234();

        while (true) {

            System.out.print("Enter first letter of ");

            System.out.print("show, insert, find, change-order, or read-file: ");

            char choice = getChar();

            switch (choice) {

                case 's':

                    theTree.displayTree();

                    break;

                case 'i':

                    System.out.print("Enter value to insert: ");
                    
                    try{
                    value = getInt();
                    } catch(Exception e){
                        System.out.println("Invalid Input.");
                        break;
                    }

                    System.out.print("Enter String to insert: ");

                    s = getString(); //This is the 'Record' that is put in when a DataItem is Created.

                    theTree.insert(value, s);

                    break;

                case 'f':

                    System.out.print("Enter value to find: ");
                    value = 0;
                    try{
                    value = getInt();
                    } catch(Exception e){
                        System.out.println("Invalid Input");
                        break;
                    }

                    int found = theTree.find(value);

                    if (found != -1) {
                        System.out.println("Found " + value);
                    } else {
                        System.out.println("Could not find " + value);
                    }

                    break;

                case 'c':

                    System.out.print("Enter value of new order: ");
                    int order;
                    try{
                    order = getInt();
                    } catch(Exception e ){
                        System.out.println("Invalid Input.");
                        break;
                    }
                    if (order < 4) {
                        System.out.print("Order too small. No new Tree created.");
                    } else if (order == 4) {
                        Node.setOrder(order);
                        theTree = new Tree234();
                    } else if (order > 4) {
                        Node.setOrder(order);
                        theTree = new BTree();
                    }
                    break;

                case 'r':
                    System.out.print("Please enter the file name/path from the root: "); //will be 'data2.txt'
                    String fileName = getString();
                    boolean changeOrder = true;
                    while (changeOrder) {
                        System.out.println("The current order of the Tree is " + Node.getOrder() + "."
                                + "\nWould you like to change the Order? (y/n): ");
                        char orderChange = getChar();
                        boolean badOrder = false;
                        switch (orderChange) {
                            case 'y':
                                System.out.println("Please enter the new Order: ");
                                int NewOrder;
                                try{
                                NewOrder = getInt();
                                }catch(Exception e){
                                    System.out.println("Invalid Input. Order not set. Returning to main menu.");
                                    badOrder = true;
                                    break;
                                }
                                if (NewOrder < 4) {
                                    System.out.print("Order too small. No new Tree created.");
                                } else if (NewOrder == 4) {
                                    Node.setOrder(NewOrder);
                                    theTree = new Tree234();
                                } else if (NewOrder > 4) {
                                    Node.setOrder(NewOrder);
                                    theTree = new BTree();
                                }
                                changeOrder = false;
                                break;
                            case 'n':
                                if (Node.getOrder() == 4) {
                                    theTree = new Tree234();
                                } else {
                                    theTree = new BTree();
                                }
                                changeOrder = false;
                                break;
                            default:
                                System.out.print("Invalid entry\n");
                                break;
                        }
                        if(badOrder){
                            break;
                        }
                        String[] data;
                        try{
                        data = readData(fileName);
                        } catch(Exception e){
                            System.out.println("File was not found.");
                            break;
                        }
                        int i = 0;
                        while (data[i] != null) { //Parse Each Lines ID
                            String tempString = "";
                            int j = 0;
                            while(data[i].charAt(j) != ','){
                                tempString += data[i].charAt(j);
                                j++;
                            }
                            long templong = Long.parseLong(tempString);
                            theTree.insert(templong, data[i]);
                            i++;
                        }
                    }
                    break;

                default:

                    System.out.print("Invalid entry\n");

            } // end switch

        } // end while

    } // end main()

    // --------------------------------------------------------------
    public static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();

        return s;

    }

    // --------------------------------------------------------------
    public static char getChar() throws IOException {

        String s = getString();

        return s.charAt(0);

    }

    // -------------------------------------------------------------
    public static int getInt() throws IOException {

        String s = getString();

        return Integer.parseInt(s);

    }

    // -------------------------------------------------------------
    public static String[] readData(String fileName) throws IOException { //Reads file and Stores each Line as an item in a String Array, then returns the Array.
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String[] strings = new String[10000];
        String line = null;
        try {
            int i = 0;
            while ((line = br.readLine()) != null) {
                strings[i] = line;
                i++;
            }
        } catch (Exception e) {
            System.out.println("Reached end of File.");
        }
        return strings;
    }

}
