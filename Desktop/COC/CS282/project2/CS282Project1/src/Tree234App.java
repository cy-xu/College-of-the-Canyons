/*
 * Kevin Ponek
 * November 10, 2015
 * CS 282 Advanced Data Structures Project 2
 * Description: Tree234App.java is the class that runs a user-friendly app that allows the user to display the tree, insert data, change the
 * 	order of the tree, read data, or quit the app.
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Tree234App
 
   {
//	public static final int RECORDSIZE = 64;
	//public static final int SECTORSIZE = 512;
   public static void main(String[] args) throws IOException
 
      {
 
      long value;//value input for 'input' and 'find' commands
      int order;//tracks the value of order for the 'read' data file command
      Tree234 theTree;//tree that is built to store data
      
      System.out.println("What is the order of the tree?");
      Scanner input = new Scanner(System.in);
      int o = input.nextInt();
      
      //when the order is 4, creates a 234-Tree
      if (o == 4) {
    	  Node.setOrder(o);
    	  order = o;
    	  System.out.println("234-Tree created.");
    	  theTree = new Tree234();
      }
      //when the order is greater than 4, creates a B-Tree
      else if (o > 4){
    	  Node.setOrder(o);
    	  order = o;
    	  System.out.println("B-Tree created.");
          theTree = new BTree();
      }
      //when the order is less than 4, automatically creates 234-Tree with order of 4 instead
      else{
    	  Node.setOrder(4);
    	  order = 4;
    	  System.out.println("Input is less than 4. Creating 234-Tree with order of 4.");
    	  theTree = new Tree234();
      }
 
      //inserts values into the tree
      theTree.insert(50);
      theTree.insert(40);
      theTree.insert(60);
      theTree.insert(30);
      theTree.insert(70);
      
      //stores random values into the tree
      //can change loop number to increase the amount of inputs for testing
      for (int i = 0; i < 10; i++){
    	  theTree.insert((int)(Math.random()*200)+ 1);
      }

      whileloop://tracks the 'q'uit command break
      while(true)
 
         {
 
         System.out.print("Enter first letter of ");
 
         System.out.print("['s']how, ['i']nsert, ['f']ind, ['c']hange order, ['r']ead data file, or ['q']uit: ");
 
         char choice = getChar();//user input for option from menu
 
         switch(choice)
 
            {
         	//displays the tree
            case 's':
 
               theTree.displayTree();
 
               break;
            //input value into the tree      
            case 'i':
 
               System.out.print("Enter value to insert: ");
 
               value = getInt();
 
               theTree.insert(value);
 
               break;
            //find value in the tree   
            case 'f':
            	
               System.out.print("Enter value to find: ");
 
               value = getInt();
 
               int found = theTree.find(value);
 
               if(found != -1)
 
                  System.out.println("Found "+value);
 
               else
 
                  System.out.println("Could not find "+value);
 
               break;
            //change the order of the tree and build a new tree   
            case 'c':
                System.out.println("What is the new order?");
                Scanner sc = new Scanner(System.in);
                int ord = sc.nextInt();
                if (ord == 4) {
                	Node.setOrder(ord);
                	order = ord;
              	  System.out.println("New 234-Tree created.");
              	  theTree = new Tree234();
                }
                else if (ord > 4){
                	Node.setOrder(ord);
                	order = ord;
              	  	System.out.println("New B-Tree created.");
                    theTree = new BTree();
                }
                else{
                	Node.setOrder(4);
                	order = 4;
              	  System.out.println("Input is less than 4. Creating new 234-Tree with order of 4.");
              	  theTree = new Tree234();
                }
                break;
            //read a data file    
            case 'r':
            	theTree = new BTree();
            	theTree = readData(order);
            	//theTree = testreadData();//used to test reading data to tree
            	break;
            //quit the menu and exit loop
            case 'q':
                System.out.println("Exiting program.");
                break whileloop;
            //catch for input that does not match
            default:
 
               System.out.print("Invalid entry\n");
 
            }  // end switch
 
         }  // end while
 
      }  // end main()
 
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
 
      return s.charAt(0);
 
      }
 

 
//-------------------------------------------------------------
 
   public static int getInt() throws IOException
 
      {
 
      String s = getString();
 
      return Integer.parseInt(s);
 
      }
   //option to change order of tree and read a data file into B-Tree
   public static Tree234 readData(int currOrder) throws IOException{
	   Scanner sc = new Scanner(System.in);
	   Scanner scc = new Scanner(System.in);
	   System.out.println("What is the name of the text file to import?");
	   String filename = sc.nextLine();
	   RandomAccessFile inout = new RandomAccessFile(filename, "r");
	   DataItem[] data = new DataItem[1000];
	   System.out.println("The current order of the tree is: " + currOrder);
	   System.out.println("Do you want to change the order? ['Y']es or ['N']o?");
	   char yesOrNo = scc.nextLine().charAt(0);
	   if (yesOrNo == 'y' || yesOrNo == 'Y'){
		   System.out.println("What is the new order?");
           int ord = sc.nextInt();
           if (ord < 4) {
        	   Node.setOrder(4);
        	   System.out.println("Input is less than 4. Defaulting to an order of 4.");
           }
           else Node.setOrder(ord);
	   }
	   Tree234 tree = new BTree();
       long fileSize = inout.length();
       int count = 0;
       while (fileSize > 0){
			   String recordString = inout.readLine();
			   fileSize = fileSize - recordString.length() - 2;//subtract 2 to account for each line space in file
			   int separatorIndex = recordString.indexOf(",");
			   String dDataString = recordString.substring(0,separatorIndex);
			   long dDataLong = Long.valueOf(dDataString).longValue();
			   data[count] = new DataItem(dDataLong);
			   data[count].setRecord(recordString);
			   tree.insert(dDataLong);
			   count++;
	   }
	   inout.close();
	   return tree;
   }
   //used to test data file reading into B-Tree with hard coded file and order values
   public static Tree234 testreadData() throws IOException{
	   RandomAccessFile inout = new RandomAccessFile("data2.txt","r");
	   Node.setOrder(6);
	   DataItem[] data = new DataItem[1000];
	   Tree234 tree = new BTree();
       long fileSize = inout.length();
       int count = 0;
       
       while (fileSize > 0){
			   String recordString = inout.readLine();
			   fileSize = fileSize - recordString.length() - 2;//subtract 2 to account for each line space in file
			   int separatorIndex = recordString.indexOf(",");
			   String dDataString = recordString.substring(0,separatorIndex);
			   long dDataLong = Long.valueOf(dDataString).longValue();
			   data[count] = new DataItem(dDataLong);
			   data[count].setRecord(recordString);
			   tree.insert(dDataLong);
			   count++; 
       }
       inout.close();
       return tree;
   }
//-------------------------------------------------------------
 
   }   // end class Tree234App