

/* 
Computer Science 282: Advanced Data Structures.
Fall:2015
Professor: Chris Ferguson
Programmer: Luis Riba 
Project : Project2
Description: 
Programming Project #2 – 234 Trees and B Trees (10 Points)
For this project, we are going to start with code from the textbook and build on top of it.
In chapter 10 there is a fully functional 234 Tree program example, but it has several limitations. 
It does not store the tree to a disk drive and it does not support building B-Trees. 
For this project, you will add the disk storage capability, use Inheritance and code to support B-Trees.
Keep in mind, one very important goal of this project. 
Change the existing code from the book as little as possible! Do not rewrite the code. 
Develop the code as a new 'layer' of code. Use OOP Inheritance to build new classes from the existing classes. 
For example, when you add BTree support, write a new split() method in the new derived class, DO NOT modify the old one. 
In fact, keep it as part of the code so the program will support BOTH a BTree and a 234 Tree.

*/
package Project2;
import java.io.*;
import java.util.Scanner;

public class Tree234App {
private static Tree234 theTree = new Tree234();

public static void main(String[] args) throws IOException {
long value;
Node.setOrder(4);
// initial tree
theTree = new Tree234();
theTree.insert(50);
theTree.insert(40);
theTree.insert(60);
theTree.insert(30);
theTree.insert(70);
char choice = 0;

// menu loop
    while (choice != 'q') {
        try {
	System.out.print("Enter first letter of ");
	System.out.print("show, insert, find, change_order, read or quit: ");
	choice = getChar();
	switch (choice) {

// show
    case 's':
	theTree.displayTree();
	break;

// insert
    case 'i':
    System.out.print("Enter value to insert: ");
    value = getInt();
    theTree.insert(value);
    break;
// find
    case 'f':
    System.out.print("Enter value to find: ");
    value = getInt();
    int found = theTree.find(value);
    if (found != -1)
    System.out.println("Found " + value);
    else
    System.out.println("Could not find " + value);
    break;
// change order
// 4 = Tree234
// 5 = BTree
    case 'c':
    System.out.print("Enter order >= 4: ");
    int order = getInt();
// tree234
    if (order == 4) {
    Node.setOrder(4);
    theTree = new Tree234();
    theTree.insert(50);
    theTree.insert(40);
    theTree.insert(60);
    theTree.insert(30);
    theTree.insert(70);
    
    }
// btree
    else if (order > 4) {
    Node.setOrder(order);
    theTree = new BTree();
    theTree.insert(50);
    theTree.insert(40);
    theTree.insert(60);
    theTree.insert(30);
    theTree.insert(70);
}

else
System.out.println("Wrong order enterred");
break;

//read file
    case 'r': {
    readdata();
    break;
}
// quit
    case 'q':
    System.out.print("goodbye");
    break;
    default:
    System.out.print("Invalid entry\n");
} // end switch
} // end try
catch (Exception ex) {
System.out.println(ex.getMessage());
}
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
public static int getInt() throws Exception {
String s = getString();
return Integer.parseInt(s);
}

// read data file
public static void readdata() {
try {
// #1 Ask them the name of the text file to import.
System.out.println("Enter file name to read (data2.txt): ");
String filename = getString();
// #2 Print the current order of the tree and ask the 'Y'es or 'N'
// or do you want to change the order.
int order = Node.getOrder();
System.out.println("Current tree order is: " + order);
// #3 If 'Y'es, ask them for the new order of the tree.
System.out.println("Would you like to change the tree order? (y/n): ");
String ans = getString().toUpperCase();

// change order
if (ans.equals("Y")) {
do {
System.out.println("Enter new order >= 4: ");
order = getInt();
if (order < 4)
System.out.println("Wrong order enterred");
} while (order < 4);
}

// Tree 234
if (order == 4) {
Node.setOrder(order);
theTree = new Tree234();
}

// Btree
else if (order > 4) {
Node.setOrder(order);
theTree = new BTree();
}

// #4 Build a BTree in memory out of the data read from the named
// text file.
// open file
String line = null;
try {
Scanner fsc = new Scanner(new File(filename));
// for each line in file get/record
while (fsc.hasNext()) {
line = fsc.nextLine();
// get key from line
int pos = line.indexOf(',');
long key = Long.parseLong(line.substring(0, pos));
String record = line.substring(pos + 1);
theTree.insert(key, record);
}
}
catch (Exception ex2) {
System.out.println(ex2.getMessage() + " " + line);
}
} // end try
catch (Exception ex1) {
System.out.println(ex1.getMessage());
}
}
// -------------------------------------------------------------
} // end class Tree234App
// //////////////////////////////////////////////////////////////

