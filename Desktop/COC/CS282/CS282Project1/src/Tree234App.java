
import java.io.*;
import java.util.Scanner;

public class Tree234App
 
   {
 
   public static void main(String[] args) throws IOException
 
      {
 
      long value;
 
      System.out.println("What is the order of the tree?");
      Scanner input = new Scanner(System.in);
      int o = input.nextInt();
      
      Node.setOrder(o);
      Tree234 theTree;
      if (o == 4) {
    	  System.out.println("234-Tree created.");
    	  theTree = new Tree234();
      }
      else if (o > 4){
    	  System.out.println("B-Tree created.");
          theTree = new BTree();
      }
      else{
    	  System.out.println("Input is less than 4. Creating 234-Tree with order of 4.");
    	  theTree = new Tree234();
      }
 
      theTree.insert(50);
 
      theTree.insert(40);
 
      theTree.insert(60);
 
      theTree.insert(30);
 
      theTree.insert(70);
 

      whileloop:
      while(true)
 
         {
 
         System.out.print("Enter first letter of ");
 
         System.out.print("show, insert, find, change order, or quit: ");
 
         char choice = getChar();
 
         switch(choice)
 
            {
 
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
            case 'c':
                System.out.println("What is the new order?");
                Scanner sc = new Scanner(System.in);
                int ord = sc.nextInt();
                Node.setOrder(ord);
                if (ord == 4) {
              	  System.out.println("New 234-Tree created.");
              	  theTree = new Tree234();
                }
                else if (ord > 4){
              	  System.out.println("New B-Tree created.");
                    theTree = new BTree();
                }
                else{
              	  System.out.println("Input is less than 4. Creating new 234-Tree with order of 4.");
              	  theTree = new Tree234();
                }
                break;
            case 'r':
            	
            case 'q':
                System.out.println("Exiting program.");
                break whileloop;
 
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
   public void readData(Tree234 tree) throws IOException{
	   Scanner sc = new Scanner(System.in);
	   System.out.println("What is the name of the text file to import?");
	   String filename = sc.nextLine();
	   RandomAccessFile inout = new RandomAccessFile(filename, "r");
	   tree.displayTree();
	   System.out.println("Do you want to change the order? ['Y']es or ['N']o?");
	   char yesOrNo = sc.nextLine().charAt(0);
	   if (yesOrNo == 'y' || yesOrNo == 'Y'){
           int ord = sc.nextInt();
           Node.setOrder(ord);
           tree = new BTree();
	   }
   }
//-------------------------------------------------------------
 
   }  // end class Tree234App