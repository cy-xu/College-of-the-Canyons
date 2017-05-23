/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

/**
 *
 * @author luisriba
 */
/*
 * RandomAccessDB.java
 * Program to mimic the low level reading and writing of disk sectors 
 * from a hard drive
*/

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessDB {
    
    // variables
    private RandomAccessFile inout; // ref to read/write file
    private String filename; // filename to read/write.
 
    // constants
    public static final int SECTORSIZE = 4096; // to be set to a value 512, 1024, 2048, 4096
    public static final int RECORDSIZE = 256; // to be set to 64, 128, 256, 512, 1024
    
    
    // methods
    
   // opens the file and sets the global inout
    public RandomAccessDB( String filename ) throws IOException {
        // store file name
        this.filename=filename;
          
        inout = new RandomAccessFile(filename, "rw");

    }

   // Creates the file and sets LENGTH numsectors * SECTORSIZE      
    public RandomAccessDB( String filename, int numsectors ) throws IOException
    {
 
        inout = new RandomAccessFile(filename, "rw");
        inout.setLength(numsectors * SECTORSIZE) ;
   
    }
    
    // close the file/DB
    public void closeDB() throws IOException {
  
        inout.close();
     
       
    }


        
    // read sector number into array of bytes from sector
    public void readDB(byte [] bytes, int sectornum) throws IOException
    {
         
        inout.seek(sectornum*SECTORSIZE);
        if(inout.read(bytes)==-1)
            throw new EOFException("end of file");
       
    }

                            
   // write sector number and using array of bytes input        
    public void writeDB(byte [] bytes, int sectornum) throws IOException
    {
        
    
        inout.seek(sectornum*SECTORSIZE);
        inout.write(bytes);
       
            
    }
    
    
    // create bew database
    public static void newDB(String filename, int numsectors) 
    {
       try
       {
       // make data bsse
       RandomAccessDB db = new RandomAccessDB( filename, numsectors );
       
       // calculate records per sector
       int numRecords = SECTORSIZE/RECORDSIZE;
       
       // data for record
       byte[] data = new byte[SECTORSIZE];
       
       // for each sector
       for(int i=0;i< numsectors;i++)
       {
            // clean sector
            for(int n=0;n<SECTORSIZE;n++)
               {
                   data[n] = ' '; // pad
               }
           
           
           
           // for each record
           for(int k=0;k<numRecords;k++)
           {
             
             // make message
               String str = "Sector " + i + " Record " + k;
               
             for(int n=0;n<str.length();n++)
             {
                 data[k*RECORDSIZE+n] = (byte)str.charAt(n);
             }
           }
           
         //write sector to db
         db.writeDB(data,i);
       
       } // end for
       
       // close file
       db.closeDB();
       
       } // end try
       
       catch(Exception ex)
       {
           
       }
        
    }
    
     public static void main(String[] args) throws IOException {
        
        byte[] data = new byte[SECTORSIZE];  // sector data 
        int numSectors = 0;  // num sectors read
      
        
        // make keyboard reader
        Scanner kybd = new Scanner(System.in);
        
        
        // test new db method
        // get file name
        System.out.println("Enter the name of the file to make or type 'skip': ");
        String filename = kybd.nextLine();
        
        if(!filename.equalsIgnoreCase("skip"))
        {
        // get number of sectors
        System.out.println("Enter number of sectors: ");
        numSectors  = Integer.parseInt(kybd.nextLine());
        
        newDB(filename, numSectors);
        }
        
        // get file name
        System.out.println("Enter the name of the file to dump: ");
        filename = kybd.nextLine();
        
        // open file

        // open random access file
        RandomAccessDB db = new RandomAccessDB(filename);

        // print sectors
        boolean padding = false;
        numSectors=0;
        try
        {
        // sector loop
        while(true)
        {
        // read sector
        db.readDB(data, numSectors);
        
        // print sector number
        System.out.println("Sector " + (numSectors++));
        
        
        // print 64 byte records
        for(int j=0;j<SECTORSIZE/ RECORDSIZE;j++)
        {
            
        // test for padding
        padding = true;
               
        for(int k=0;k<RECORDSIZE;k++)
        {
             if(data[j*RECORDSIZE+k]!= ' ') padding = false;
        }
          
        
        //  print record if not padding
        if(!padding)
        {
      
        // print characters
        for(int k=0;k<RECORDSIZE;k++)
        {
        System.out.print((char)data[j*RECORDSIZE+k]);
        }
        System.out.println("");
        } 
        
        }// end for
        } // end while
        } // end try
        
        catch(IOException ex)
        {
        // end of file
        }
       // close file
        db.closeDB();
        
        
        // test middle layer class
         System.out.println("\nTest Middle Layer class\n");
        
      // Ask the user the name of the file they want to open, 
        
        // get file name
        System.out.println("Enter the name of the file: ");
        filename = kybd.nextLine();
        
        int sectornum = 0;
        int recordnum = 0;
        String record = "";
        String ans = "";
        data = new byte[SECTORSIZE];
        String[] records = new String[SECTORSIZE/RECORDSIZE];
        
        try
        {
        // use RandomAccessFile to open it
        RandomAccessFile  inout = new RandomAccessFile(filename,"rw");
        
        // go into a loop 
       do
        {
            
        // asking the user to read a sector, 
         System.out.println("Enter a sector to read: ");
         sectornum = Integer.parseInt(kybd.nextLine());
         
         // use RandomAccessFile to get the byte 
         inout.seek(sectornum*SECTORSIZE);
         inout.read(data);
         
         //  Use buffer2Strings to convert it to an array of strings
         records = MiddleLayer.buffer2Strings(data);
         
         // print out records
         // print the first 64 character of each record
         for(int i=0;i<records.length;i++)
         {
             System.out.println("record " + i);
             for(int n=0;n<64;n++)
             {
                 System.out.print(records[i].charAt(n));
             }
             
             System.out.println("");
         }
        
        //write a sector  
        // asking the user which sectot to write 
         System.out.println("Enter a sector to write: ");
         sectornum = Integer.parseInt(kybd.nextLine());
         
          // then use RandomAccessFile to get the byte array from that sector.
         inout.seek(sectornum*SECTORSIZE);
         inout.read(data);
         
         // Use buffer2Strings to convert it to an array of strings. 
         records = MiddleLayer.buffer2Strings(data);
         
         // Ask the user to input the record number  
        System.out.println("Enter a record number: ");
        recordnum = Integer.parseInt(kybd.nextLine());
         
        // ask for a string for the new record.
        System.out.println("Enter a record: ");
        record = kybd.nextLine();
                 
         //Replace the record in the array of strings.
         records[recordnum]="";
         for(int i=0;i<RECORDSIZE;i++)
             records[recordnum] += " ";
         records[recordnum] = record + records[recordnum].substring(record.length());
         
         //Use strings2Buffer to convert to a byte array
         data = MiddleLayer.strings2Buffer(records);
         
         // use RandomAccessFile to write the byte array back to the proper sector.
         inout.seek(sectornum*SECTORSIZE);
         inout.write(data);
         
                
         // ask to exit
         System.out.println("Do you want to exit (y/n): ");
         ans = kybd.nextLine();
         
        }while(!ans.equalsIgnoreCase("y"));

        // When the user exits, remember to use RandomAccessFile to close the database file.
        inout.close();
        
        }
        catch(IOException  ex)
        {
            System.out.println(ex.getMessage());
        }

} // end main
     
     
} // end  RandomAccessDB
