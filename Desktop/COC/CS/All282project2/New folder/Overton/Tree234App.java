/*
 * Name: Benjamin Overton
 * Date: Nov. 17, 2015
 * Description: Simulates a B-Tree by using an existing 2-3-4 Tree code.  
*/

import java.io.*;
import java.util.Scanner;

public class Tree234App {

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException, NumberFormatException {
		String s = getString();
		return Integer.parseInt(s);
	}

	public static void readData(Tree234 theTree) throws IOException, FileNotFoundException {

		Scanner in;

		System.out.print("Enter the name of the file to be read: ");
		String input = getString();
		try {
			in = new Scanner(new File(input));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}
		System.out.println("Order of the tree is: " + Node.getOrder());
		System.out.print("Would you like to change it? 'Y'es or 'N'o? : ");
		char choice = getChar();
		switch (choice) {
		case 'y':
			System.out.print("Enter the order of the tree: ");
			int value = getInt();
			if (value == 4) {
				Node.setOrder((int) value);
				theTree = new Tree234();
				in = new Scanner(new File(input));
				in.useDelimiter("[^0-9]+");
				while (in.hasNextLine()) {
					String id = in.next();
					theTree.insert(Long.parseLong(id));
					in.nextLine();
				}
				in.close();
				break;
			} else if (value > 4) {
				Node.setOrder((int) value);
				theTree = new Tree234();
				in = new Scanner(new File(input));
				in.useDelimiter("[^0-9]+");
				while (in.hasNextLine()) {
					String id = in.next();
					theTree.insert(Long.parseLong(id));
					in.nextLine();
				}
				in.close();
				break;
			} else
				System.out.println("Enter a valid order.");
			break;
		case 'n':
			in = new Scanner(new File(input));
			in.useDelimiter("[^0-9]+");
			while (in.hasNextLine()) {
				String id = in.next();
				theTree.insert(Long.parseLong(id));
				in.nextLine();
			}
			in.close();
			break;
		}
	}

	public static void main(String[] args) throws IOException {

		long value;
		Tree234 theTree = new Tree234();

		while (true) {
			System.out.print("Enter first letter of 's'how, 'i'nsert, 'f'ind, 'c'hange, 'r'ead or 'q'uit: ");
			char choice = getChar();
			switch (choice) {
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
				if (found != -1) {
					System.out.println("Found " + value);
				} else
					System.out.println("Could not find: " + value);
				break;
			case 'c':
				System.out.print("Enter the order of the tree: ");
				value = getInt();
				if (value > 4) {
					Node.setOrder((int) value);
					theTree = new BTree();
				} else if (value <= 4 && value > 1) {
					Node.setOrder((int) value);
					theTree = new Tree234();
				} else
					System.out.println("Enter a valid order.");
				break;
			case 'r':
				readData(theTree);
				break;
			case 'q':
				return;
			default:
				System.out.print("Invalid entry\n");
			}
		}
	}
}