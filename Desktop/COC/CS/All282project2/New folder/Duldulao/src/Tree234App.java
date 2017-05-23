/*
 * Programmer: Aaron Duldulao
 * CMPSCI282 - Advanced Data Structure
 * Project 2
 * Date last modified: 11/16/2015
 * Description: This program inserts, finds, and shows the data items of a tree data structure.
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Tree234App {
    
    private static DataItem [] dItems;

    public static void main(String[] args) throws IOException 
    {
        long value;
        int order;
        char choice = 'a';
        char yesOrNo = 'a';
        String fileName;
        Tree234 theTree;
        File inputFile;
        
        System.out.println("Order of the tree is set to default which is 4."); //default order
        theTree = new Tree234();
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        while (choice != 'q') 
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, find, change order, read a data file or quit: ");
            choice = getChar();
            switch (choice) 
            {
                case 's': //show
                    theTree.displayTree();
                    break;
                    
                case 'i': //insert
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;

                case 'f': //find
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found != -1) 
                    {
                        System.out.println("Found " + value);
                    } 
                    else 
                    {
                        System.out.println("Could not find " + value);
                    }
                    break;
                    
                case 'q': //quit
                    System.out.println("Thank you for using Tree234App!");
                    break;
                    
                case 'c': //change order
                    System.out.println("Changing the order of the tree deletes the current tree and creates a new tree.");
                    System.out.print("Are you sure you want to continue (y/n)?");
                    yesOrNo = getChar();
                    if(yesOrNo == 'y')
                    {
                        System.out.println("Enter the order of the tree: ");
                        order = getInt();
                        if(order == Node.getOrder()) //if the same as current order
                        {
                            System.out.println("The order entered is the same as the current order.\nOrder has not been changed.\n");
                        }
                        else if(order < 4) //if invalid order
                        {
                            System.out.println("Invalid order! Order has not been changed.\n");
                        }
                        else if(order > 4) //create Btree if order greater than 4
                        {
                            Node.setOrder(order);
                            theTree = new BTree();
                            theTree.insert(50);
                            theTree.insert(40);
                            theTree.insert(60);
                            theTree.insert(30);
                            theTree.insert(70);
                        }
                        else //create 234tree 
                        {
                            Node.setOrder(order);
                            theTree = new Tree234();
                            theTree.insert(50);
                            theTree.insert(40);
                            theTree.insert(60);
                            theTree.insert(30);
                            theTree.insert(70);
                        }
                    }
                    yesOrNo = 'a';
                    break;
                    
                case 'r': //read a file
                    System.out.print("Enter the name of the file to import: ");
                    fileName = getString();
                    inputFile = new File(fileName);
                    if(inputFile.exists()) //if the file exists
                    {
                        readData(inputFile); //method call
                        System.out.println("The current order of the tree is " + Node.getOrder());
                        System.out.print("Do you want to change the order(y/n)? ");
                        yesOrNo = getChar();
                        if(yesOrNo == 'y') //if user will change order
                        {
                            System.out.println("Enter the new order of the tree: ");
                            order = getInt();
                            if(order == Node.getOrder()) //if inputted order the same with current order
                            {
                                System.out.println("The order entered is the same as the current order.");
                                System.out.println("Order has not been changed.\n");
                                if(Node.getOrder() == 4) //if current order is equal to 4
                                {
                                    theTree = new Tree234(); //create a 234tree
                                    for(int x = 0; x < dItems.length; x++)
                                    {
                                        theTree.insert(dItems[x]);
                                    }
                                }
                                else //if order more than 4
                                {
                                    theTree = new BTree(); //creates a btree
                                    for(int x = 0; x < dItems.length; x++)
                                    {
                                        theTree.insert(dItems[x]);
                                    }
                                }
                            }
                            else if(order < 4) //if inputted order is invalid, will use current order
                            {
                                System.out.println("Invalid order! Order has not been changed.\n");
                                if(Node.getOrder() == 4) //if current order is equals to 4
                                {
                                    theTree = new Tree234();
                                    for(int x = 0; x < dItems.length; x++)
                                    {
                                        theTree.insert(dItems[x]);
                                    }
                                }
                                else //if current order is greater than 4
                                {
                                    theTree = new BTree();
                                    for(int x = 0; x < dItems.length; x++)
                                    {
                                        theTree.insert(dItems[x]);
                                    }
                                }
                            }
                            else if(order > 4) //if inputted order greater than 4
                            {
                                Node.setOrder(order);
                                theTree = new BTree();
                                for(int x = 0; x < dItems.length; x++)
                                {
                                    theTree.insert(dItems[x]);
                                }
                            }
                            else //if inputted order is 4
                            {
                                Node.setOrder(order);
                                theTree = new Tree234();
                                for(int x = 0; x < dItems.length; x++)
                                {
                                    theTree.insert(dItems[x]);
                                }
                            }
                        }
                        else //if user will not change the order
                        {
                            if(Node.getOrder() == 4) //if current order is 4
                            {
                                theTree = new Tree234();
                                for(int x = 0; x < dItems.length; x++)
                                {
                                    theTree.insert(dItems[x]);
                                }
                            }
                            else //if current order is greater than 4
                            {
                                theTree = new BTree();
                                for(int x = 0; x < dItems.length; x++)
                                {
                                    theTree.insert(dItems[x]);
                                }
                            }
                        }
                        yesOrNo = 'a';
                    }
                    else //if file does not exist
                    {
                        System.out.println("The file does not exist!");
                    }
                    break;

                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()

    public static String getString() throws IOException 
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException 
    {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException 
    {
        String s = getString();
        return Integer.parseInt(s);
    }
    
    public static void readData(File inputFile) throws FileNotFoundException
    {
        String line;
        String [] records;
        long [] keys;
        ArrayList<String> stringList = new ArrayList();
        Scanner fileReader = new Scanner(inputFile);
        while (fileReader.hasNext()) 
        {
            line = fileReader.nextLine();
            stringList.add(line);
        }
        records = new String[stringList.size()];
        stringList.toArray(records);
        keys = new long[stringList.size()];
        for (int x = 0; x < stringList.size(); x++) 
        {
            keys[x] = Long.parseLong(records[x].split(",")[0]);
        }
        dItems = new DataItem[stringList.size()];
        for (int x = 0; x < stringList.size(); x++) 
        {
            dItems[x] = new DataItem(keys[x], records[x]);
        }
        fileReader.close();
    }
}

