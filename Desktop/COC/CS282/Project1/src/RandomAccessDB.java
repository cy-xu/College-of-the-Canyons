/*
 * Kevin Ponek
 * October 8, 2015
 * CS 282 Advanced Data Structures Project 1
 * Description: 
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class RandomAccessDB {

	RandomAccessFile inout;
	String filename;
	public static final int SECTORSIZE = 512;
	public static final int RECORDSIZE = 128;
	
	//main method to test methods
	public static void main(String[] args) throws IOException{
		System.out.println("Enter the name of the file to dump:");
		Scanner input = new Scanner(System.in);
		String file = input.nextLine();
		RandomAccessDB test = new RandomAccessDB(file);//file is chosen from directory by user input
		byte [] sectorBytes = new byte[SECTORSIZE];
		test.readDB(sectorBytes, 0);//read sector 0
		for (int i = 0 ; i < SECTORSIZE/RECORDSIZE; i++){//loops through number of records in the sector
			byte [] record64Bytes = Arrays.copyOfRange(sectorBytes, i * RECORDSIZE, i * RECORDSIZE + 64);
			String recordChar = new String(record64Bytes);
			System.out.println("Record " + i + ": " + recordChar);
		}
		test.closeDB();
		/*Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("Would you like to read a file [1], create a new database file [2], or exit [3]?");
			String choice = input.nextLine();
			if (choice.equals("1")) readDB();
			else if (choice.equals("2")) createDB();
			else if (choice.equals("3")) break;
			else System.out.println("ERROR: Not a valid option of [1], [2], or [3]");
		}*/
	}

	//part 3: method to create a new database file
	public static void newFileWriteDB() throws IOException{
		System.out.println("Enter the name of a new file to create:");
		Scanner input = new Scanner(System.in);
		String file = input.nextLine();
		RandomAccessDB test = new RandomAccessDB(file,0);//constructor creates a new file
		byte [] bytes = new byte[SECTORSIZE];//create byte array and read sector 0 to it
		test.readDB(bytes, 0);
		char [] charBytes = new char[SECTORSIZE];
		for (int i = 0 ; i < SECTORSIZE/RECORDSIZE; i++){//loops through number of records in the sector
			String stringWriter = "Sector 0   Record " + i;
			charBytes[0+i*RECORDSIZE] =
			test.writeDB(bytes,0);
		}
		test.closeDB();
	}
	public RandomAccessDB(String filename) throws IOException{
		inout = new RandomAccessFile(filename, "r");
	}
	public RandomAccessDB(String filename, int numsectors) throws IOException{
		inout = new RandomAccessFile(filename, "rw");
		inout.setLength(numsectors * SECTORSIZE);
	}
	public void closeDB() throws IOException{
		inout.close();
	}
	public void readDB(byte [] bytes, int sectornum) throws IOException{
		inout.seek(sectornum * SECTORSIZE);//sets file pointer to beginning of the sector
		inout.read(bytes);
	}
	public void writeDB(byte [] bytes, int sectornum) throws IOException{
		inout.seek(sectornum * SECTORSIZE);//sets file pointers to beginning of the sector
		inout.write(bytes);
	}
}
