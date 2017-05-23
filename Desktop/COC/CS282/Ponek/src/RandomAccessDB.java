/*
 * Kevin Ponek
 * October 8, 2015
 * CS 282 Advanced Data Structures Project 1
 * Description: RandomAccessDB class that utilizes RandomAccessFile class to read and write byte array of sectors.
 * 	It includes constants for the sector size and record size.  There are two constructors: one to create a new file and one for an existing file.
 * 	Two test methods included in the main method and newFileWriteDB() to test the variables and methods of the class.
 * 	
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class RandomAccessDB {

	RandomAccessFile inout;
	String filename;
	public static final int SECTORSIZE = 512;//constant representing the sector size of the hard drive
	public static final int RECORDSIZE = 128;//constant representing the record size of the hard drive
	
	//part 2: test method
	public static void main(String[] args) throws IOException{
                //newFileWriteDB();
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
	}

	//part 3: method to create a new database file and write a sector
	public static void newFileWriteDB() throws IOException{
		System.out.println("Enter the name of a new file to create:");
		Scanner input = new Scanner(System.in);
		String file = input.nextLine();
		RandomAccessDB test = new RandomAccessDB(file,0);//constructor creates a new file
		byte [] bytes = new byte[SECTORSIZE];//create byte array and read sector 0 to it
		test.readDB(bytes, 0);
		for (int i = 0 ; i < SECTORSIZE/RECORDSIZE; i++){//loops through number of records in the sector
			String stringWriter = "Sector 0   Record " + i;
			byte [] recordBytes = stringWriter.getBytes();
			System.arraycopy(stringWriter.getBytes(),0,bytes,i*RECORDSIZE,recordBytes.length);
		}
		test.writeDB(bytes, 0);
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
		inout.close();//closes the file
	}
	public void readDB(byte [] bytes, int sectornum) throws IOException{
		inout.seek(sectornum * SECTORSIZE);//sets file pointer to beginning of the sector
		inout.read(bytes);//reads bytes.length number of positions from where the pointer is set
	}
	public void writeDB(byte [] bytes, int sectornum) throws IOException{
		inout.seek(sectornum * SECTORSIZE);//sets file pointers to beginning of the sector
		inout.write(bytes);//writes to the file bytes.length number of positions from where the pointer is set
	}
}
