/*
 * Kevin Ponek
 * October 8, 2015
 * CS 282 Advanced Data Structures Project 1
 * Description: 
 */
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class MiddleLayer {
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		System.out.println("What is the name of the file to open?");
		String fileName = input.nextLine();
		RandomAccessFile file = new RandomAccessFile(fileName,"rw");
		byte [] bytes = new byte[RandomAccessDB.SECTORSIZE];
		while(true){
			System.out.println("Would you like to read a sector [1], write a sector [2], or exit [3]?");
			String choice = input.nextLine();
			if (choice.equals("1")) {
				System.out.println("Which sector to read?");
				int sectorNum = input.nextInt();//variable for the sector number to read
				file.seek(sectorNum * RandomAccessDB.SECTORSIZE);//move file position to beginning of sector for read
				file.read(bytes);//read the chosen sector into byte array
				String [] byteString = buffer2Strings(bytes);//convert byte array into string array
				for (int i = 0; i < byteString.length; i++) {
					System.out.println(byteString[i].substring(0, 64));//print the first 64 characters of each record
				}
			}
			else if (choice.equals("2")) {//option to write a sector
				System.out.println("Which sector to write?");
				int sectorNum = input.nextInt();//variable for the sector number to read
				file.seek(sectorNum * RandomAccessDB.SECTORSIZE);//move file position to beginning of sector for read
				file.read(bytes);//reads the chosen sector into byte array
				String [] byteString = buffer2Strings(bytes);//convert byte array into string array
				System.out.println("Please input the record number:");
				int recordNum = input.nextInt();//variable for the sector number to write to
				System.out.println("Please enter a String for the new record:");
				String recordString = inputString.nextLine();//new record to write
				byteString[recordNum] = recordString;//replace the string at the record with the new string
				bytes = strings2Buffer(byteString);//convert string array back to byte array
				file.seek(sectorNum*RandomAccessDB.SECTORSIZE);//move file position back to beginning of sector to overwrite
				file.write(bytes);//write new data to sector
				
			}
			else if (choice.equals("3")) break;//option to exit
			else System.out.println("ERROR: Not a valid option of [1], [2], or [3]");
		}
		file.close();//close the file
	}
	public static String [] buffer2Strings(byte [] data) {
		String [] stringRecords = new String[RandomAccessDB.SECTORSIZE/RandomAccessDB.RECORDSIZE];
		for (int i = 0; i < stringRecords.length; i++) {
			byte [] copy = Arrays.copyOfRange(data, i * RandomAccessDB.RECORDSIZE, i * RandomAccessDB.RECORDSIZE + RandomAccessDB.RECORDSIZE);
			stringRecords[i] = new String(copy);
		}
		return stringRecords;
	}
	public static byte [] strings2Buffer(String [] records) {
		byte [] bytes = new byte[RandomAccessDB.SECTORSIZE];
		String concatString = new String();
		for (int i = 0; i < records.length; i++) {
			concatString = concatString + records[i];
			//byte [] recordBytes = records[i].getBytes();
			//System.arraycopy(recordBytes, 0, bytes, i*RandomAccessDB.RECORDSIZE, RandomAccessDB.RECORDSIZE);
		}
		bytes = concatString.getBytes();
		return bytes;
	}
}
