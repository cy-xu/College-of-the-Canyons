import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tree234App {
    public static void main(String[] args) throws IOException {

        //File file = new File("data2.txt");
        //Scanner input = new Scanner(file);
        String line;

        long value;
        Tree234 theTree = new Tree234();
        theTree.insert(70);
        theTree.insert(50);
        theTree.insert(30);
        theTree.insert(40);
        theTree.insert(20);
        theTree.insert(80);
        theTree.insert(25);
        theTree.insert(90);
        theTree.insert(75);
        theTree.insert(10);

        while(true){
            System.out.println("*****************************************************");
            System.out.println("Enter the first letter of ");
            System.out.println("show -- (s) to show or display a tree");
            System.out.println("insert -- (i) to insert a value into a tree");
            System.out.println("change -- (c) to change the order of the tree");
            System.out.println("find -- (f) to find or search for a value");
            System.out.println("read -- (r) to read a .txt file into a tree");
            System.out.println("quit -- (q) to quit and exit the program");
            char choice = getChar();

            switch (choice)
            {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter a value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter a value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if(found != -1){
                        System.out.println("Found: " + value);
                    }else{
                        System.out.println("Could not find " + value);
                    }
                    break;
                case 'c':
                    System.out.println("Enter an integer to change the order of the Tree");
                    value = getInt();
                    Node.setORDER((int) value);
                    theTree = (Node.getORDER() >= 5)? new BTree(): new Tree234();
                    System.out.println("Order of Tree set to: " + Node.getORDER());
                    //System.out.println(theTree instanceof BTree);
                    /*
                    theTree.insert(70);
                    theTree.insert(50);
                    theTree.insert(30);
                    theTree.insert(40);
                    theTree.insert(20);
                    theTree.insert(80);
                    theTree.insert(25);
                    theTree.insert(90);
                    theTree.insert(75);
                    theTree.insert(10);
                    //*/
                    break;
                case 'q':
                    System.exit(0);
                    break;  // I suppose there's no need for a break if it exits the program however
                case 'r':
                    // reads a text file into a tree
                    System.out.println("Please enter the full path of the filename: ");
                    Scanner in = new Scanner(System.in);
                    String filename = in.nextLine();
                    File file = new File(filename);


                    System.out.println("Order of Tree set to: " + Node.getORDER());
                    System.out.println("Would you like to change the order? Y for yes, N for no");
                    char yesorno = getChar();
                    switch (yesorno){
                        case 'Y':
                            System.out.println("Enter an integer to change the order of the Tree");
                            value = getInt();
                            Node.setORDER((int) value);
                            theTree = (Node.getORDER() >= 5)? new BTree(): new Tree234();
                            System.out.println("Order of Tree set to: " + Node.getORDER());
                            break;
                        case 'N':
                            // do nothing the tree order stays the same
                            break;
                        default:
                            System.out.println("Invalid entry");
                    }

                    if(file.exists()){
                        Scanner inFile = new Scanner(file);
                        while (inFile.hasNext()){
                            line = inFile.nextLine();
                            String tokens[] = line.split(",");
                            int key = Integer.parseInt(tokens[0]);
                            //System.out.println(key);
                            theTree.insert(key);

                        }
                        inFile.close();

                    }

                    break;
                default:
                    System.out.println("Invalid entry");
            } // end switch
        } // end while


        //theTree.displayTree();
        //int found = theTree.find(70);
    } // end main

    private static char getChar() throws IOException{

        String s = getString();
        return s.charAt(0);
    }

    private static String getString()throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    private static int getInt() throws IOException{

        String s = getString();
        return Integer.parseInt(s);
    }
}