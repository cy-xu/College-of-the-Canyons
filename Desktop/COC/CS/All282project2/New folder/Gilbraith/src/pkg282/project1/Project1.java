// Mark James Gilbraith
// Comp Sci - 282
// Professor Ferguson
// 11/12/2015

// Project 2, incomplete.



package pkg282.project1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import static pkg282.project1.Tree234App.getChar;
import static pkg282.project1.Tree234App.getInt;

public class Project1 
{
    

     public static void main(String[] args) throws IOException 
     {
        // Create a random access file
//        RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw"); //string name, string mode.
//
//        // Clear the file to destroy the old contents if exists
//        inout.setLength(0);
//
//        // Write new integers to the file
//        for (int i = 0; i < 200; i++)
//        {
//            inout.writeInt(i);   
//        }
//
//        // Display the current length of the file
//        System.out.println("Current file length is " + inout.length());
//
//        // Retrieve the first number
//        inout.seek(0); // Move the file pointer to the beginning
//        System.out.println("The first number is " + inout.readInt());
//
//        // Retrieve the second number
//        inout.seek(1 * 4); // Move the file pointer to the second number
//        System.out.println("The second number is " + inout.readInt());
//
//        // Retrieve the tenth number
//        inout.seek(9 * 4); // Move the file pointer to the tenth number
//        System.out.println("The tenth number is " + inout.readInt());
//
//        // Modify the eleventh number, this .writeInt is AFTER the inout.seek(9*4) which gets the 10th number.
//        inout.writeInt(555);
//
//        // Append a new number
//        inout.seek(inout.length()); // Move the file pointer to the end, sets the offset.
//        inout.writeInt(999);
//
//        // Display the new length
//        System.out.println("The new length is " + inout.length());
//
//        
//        inout.seek(10 * 4); // Move the file pointer to the eleventh number
//        System.out.println("The eleventh number is " + inout.readInt());
//
//
//        inout.close(); // Close the file.
         
 
        Tree234 theTree = new Tree234();
        
         long value;
         int SentValue = 0;
 

 
      theTree.insert(50);
 
      theTree.insert(40);
 
      theTree.insert(60);
 
      theTree.insert(30);
 
      theTree.insert(70);
 

 
      while(SentValue == 0)
 
         {
 
         System.out.print("Enter first letter of ");
 
         System.out.print("show, insert, find or quit: ");
 
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
                
            case 'q':
                SentValue = -1;
                break;
 
            default:
 
               System.out.print("Invalid entry\n");
 
            }  // end switch
 
         }  // end while
   
 

 
//         
//         RandomAccessDB DBObject = new RandomAccessDB();
//        
//         Scanner Scans = new Scanner(System.in);
//         Scanner Scans2 = new Scanner(System.in);
//         Scanner Scans3 = new Scanner(System.in);
//         String Input;
//         String FileNameInput;
//         
//         int InputChoice = 0;
//         
//         while(InputChoice != -1)
//         {
//             
//             System.out.println("*******************************");
//             System.out.println("");
//             System.out.println("Select an Action by typing in the proper number.");
//             System.out.println("1) Read File");
//             System.out.println("2) Create a File");
//             System.out.println("3) Write to a File");
//             System.out.println("-1) Quit the Program");
//             System.out.print("-->");
//             InputChoice = Scans2.nextInt();
//
//
//             if(InputChoice == 1)
//             {
//                 System.out.println("Enter the filename to read: ");
//                 System.out.print("-->");
//                 Input = Scans.nextLine();
//                 DBObject.RandomAccessDB(Input);
//
//                 System.out.println("Enter in a Sector Number: ");
//                 System.out.print("-->");
//                 int SectorNum = Scans.nextInt();
//
//                 byte[] document = new byte[(int) DBObject.inout.length()];
//
//                 DBObject.readDB(document, SectorNum); 
//                 DBObject.CloseDB();
//             }
//
//             else if(InputChoice == 2)
//             {
//                 System.out.println("Enter a name for a new file");
//                 System.out.print("-->");
//                 FileNameInput = Scans3.nextLine();
//                 
//
//                 DBObject.RandomAccessDB(FileNameInput, 0);
//
//
//                 DBObject.CloseDB();
//             }
//
//             else if(InputChoice == 3)
//             {
//                 System.out.println("Enter a file to write to: ");
//                 System.out.print("-->");
//                 FileNameInput = Scans3.nextLine();
//                 DBObject.RandomAccessDB(FileNameInput);
//                 
//                 System.out.println("Enter in a Sector Number to write to: ");
//                 System.out.print("-->");
//                 int SectorNum2 = Scans.nextInt();
//
//                 byte[] document = new byte[(int) DBObject.inout.length()];
//
//                 DBObject.writeDB(document, SectorNum2); 
//                 DBObject.CloseDB();
//
//             }
//         }
         
   
 
         
      }
}
