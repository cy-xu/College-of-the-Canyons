/* 
 * Name(Author): Oganes
 * File:   RandomAccessDB.java
 *  Date Created: Nov 3, 2015, 11:33:35 PM
 *  Project Name: RandomAccessDB
 *  Description: This program takes the data2.txt file and checks the context and assigns it to a BTree
 * with the default ORDER 4. The tree can be read write to and if the user like can change the ORDER
 * of the tree.
 */
package projectproadv2;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RandomAccessDB {

    Tree234App theTree = new Tree234App();
    Node theNode = new Node();

    public static Scanner rw = new Scanner(System.in);

    private RandomAccessDB theDisk;
    static RandomAccessFile inout;

    public static final int RECORDSIZE = 512;
    public static final int SECTORSIZE = 4096;
    public static final int RECORDWRITESIZE = 128;

    private static boolean openFlag = false;
    private static String dbname;

    public String value = null;
    public String writeRecord;

    public RandomAccessDB() {
        inout = null;

    }

    public void run() throws FileNotFoundException, IOException {
        int inputList = 0;

        do {
            System.out.println("\n\n1) Load  \n2) Read  \n3) Write \n4) Close DB  \n5) Change ORDER \n6) Exit ");
            System.out.print("Enter Command: ");
            inputList = userInput.getInt();

            if (inputList == 1) {
                if (openFlag == true) {
                    System.out.println("\n\nThere's already a file open. Close one first.\n\n");
                } else {
                    System.out.println("Enter the name of the file you want to open");
                    System.out.print("Enter File Name: ");
                    dbname = userInput.getString();
                    theDisk = new RandomAccessDB();
                    RandomAccessDB.openDisk(dbname, false);

                    openFlag = true;
                }
            } else if (inputList == 2) {
                if (openFlag == false) {
                    System.out.println("\n\nThere's no database open. Try making one.\n\n");
                } else {
                    byte[] recordbuffer = theDisk.readRecord();
                    theTree.displayTree();
                }
            } else if (inputList == 3) {
                if (openFlag == false) {
                    System.out.println("\n\nThere's already a file open.\n\n");
                } else {
                    System.out.print("Which Sector: ");
                    int sectornumber = userInput.getInt();
                    System.out.print("Which Record: ");
                    int recordnumber = userInput.getInt();
                    System.out.print("Enter Data in to the Record: ");
                    writeRecord = userInput.getString();
                    theDisk.writeRecord(inout, sectornumber, recordnumber, RECORDWRITESIZE, writeRecord);

                    openFlag = true;
                }
            } else if (inputList == 4) {

                if (openFlag == false) {
                    System.out.println("\n\nThere's no database open. Try making one.\n\n");
                } else {
                    System.out.println("\n\nThe Disk is closed...\n\n");
                    theDisk.closeDisk();
                    openFlag = false;
                }
            } else if (inputList == 5) {
                theNode.run();
                theTree.displayTree();

            } else if (inputList == 6) {
                System.out.println("Goodbye.\n");
                System.exit(-1);
            }
        } while (inputList != 5);

    }

    public static boolean openDisk(String fileName, boolean createFile) {

        if (inout != null) {
            return false;
        }

        try {
            if (createFile) {
                inout = new RandomAccessFile(fileName, "rw");
            } else {
                inout = new RandomAccessFile(fileName, "r");
                inout.close();
                inout = new RandomAccessFile(fileName, "rw");
            }
            System.out.println("\n\nDB " + fileName + " is open\n\n");
        } catch (IOException e) {
            System.out.println("\n\nDB " + fileName + " is NOT open " + e.toString() + "\n\n");
            return false;
        }
        return true;
    }

    public byte[] readRecord() {
        if (inout == null) {
            System.out.println("\n\nFile Not Open\n\n");
            return null;
        }

        byte[] buffer = new byte[RECORDSIZE];
        try {
            inout.seek(0);
            theTree.insert(inout.read(buffer));

            if (inout.read(buffer) == -1) {
                return null;
            }

        } catch (IOException e) {
            System.out.println("\n\nError in readSector:\n" + e.toString() + "\n\n");
            System.exit(-1);
        }
        return buffer;
    }

    public byte[] writeRecord(RandomAccessFile inout, int sectornum, int recordnum, int length, String recordData) {
        if (inout == null) {
            System.out.println("\n\nFile Not Open\n\n");
            return null;
        }

        byte[] buffer = new byte[RECORDSIZE];
        try {
            inout.seek((sectornum * SECTORSIZE) + (RECORDSIZE * recordnum));
            String[] fileInput = new String[length];

            for (int i = 0; i < 1; i++) {
                fileInput[i] = recordData;
            }
            for (int i = 0; i < fileInput.length; i++) {
                if (fileInput[i] != null) {
                    inout.writeBytes(fileInput[i]);
                } else {
                    inout.writeChars("");
                }
            }
        } catch (IOException e) {
            System.out.println("\n\nError in writeSector:\n" + e.toString() + "\n\n");
            System.exit(-1);
        }
        return buffer;
    }

    public void closeDisk() {
        if (inout == null) {
            return;
        }

        try {
            inout.close();
        } catch (IOException e) {
            System.out.println("\n\nError in fake disk close:\n\n");
            System.exit(-1);
        }
        inout = null;
    }
}
