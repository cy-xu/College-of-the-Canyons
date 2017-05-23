
package pkg282.project1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;



public class RandomAccessDB
{
    public RandomAccessFile inout;
    public String FileName;
    final static int SECTORSIZE = 512;
    final static int RECORDSIZE = 64;
    

    public void RandomAccessDB(String SentFileName) throws FileNotFoundException, IOException
    {

        
        File f = new File(SentFileName);
        if(f.exists() && !f.isDirectory()) // If file exists and not file.IsDirectory == true
        {
            inout = new RandomAccessFile(SentFileName, "rw"); // Open the file.
            FileName = SentFileName; // Set FileName to the name of the file.
            
            
        }
        
        else
        {
            System.out.println("ERROR: That file doesn't exist.");
        }

    }
    
    public void RandomAccessDB(String SentFileName, int NumSectors) throws FileNotFoundException, IOException // Creates a new file.
    {
        inout = new RandomAccessFile(SentFileName, "rw");
        FileName = SentFileName;
        
        inout.setLength(0);
        
    }
    
    public long SizeOfDB() throws IOException
    {
        return inout.length();
    }
    
    public void CloseDB() throws IOException
    {
        inout.close();
    }
    
    public void readDB(byte[] bytes, int sectornum) throws IOException
    {
         //dbase1.txt is 512 bytes per record.
        
        // Do a check if a sector is empty or not.
        
        // dbase1.txt = 12288 bytes
        
        // 24 total records in dbase1.txt
        
        //sectornum = bytes.length / 512; // This returns as 24.
        //dbase1.txt has 8 records per sector. 
        // 3 sectors total for dbase1.txt (0-2);
        
        int TotalNumOfRecords = SECTORSIZE / RECORDSIZE; // Gives the total number of records.
        int TotalNumOfSectors = (bytes.length / SECTORSIZE) / TotalNumOfRecords; // (Byte Length / Sector Size) / TotalNumOfRecords = Total Number of Sectors.
        System.out.println("Bytes Length: " + bytes.length);
        System.out.println("Total Number of Sectors: " + TotalNumOfSectors);
        
        String s; // Use this to convert the bytes into a string.
        
        if(sectornum > 0)
        {
            for(int i = TotalNumOfRecords * sectornum; i < TotalNumOfRecords * (sectornum + 1); i++)
            {
                 inout.seek(SECTORSIZE * i);
                 inout.read(bytes);

                 s = new String(bytes);

                 System.out.println("Sector: " + sectornum);
                 System.out.println("--Record: " + i + " : " + s.substring(0, RECORDSIZE));
            }   
        }
        
        else if(sectornum == 0)
        {
            for(int i = TotalNumOfRecords * sectornum; i < TotalNumOfRecords; i++)
            {
                inout.seek(SECTORSIZE * i);
                inout.read(bytes);
                
                
                
                s = new String(bytes); // Transfer to MiddleLayer
                
                 System.out.println("Sector: " + sectornum); //Go ahead and send this to Middle Layer
                 System.out.println("--Record: " + i + " : " + s.substring(0, RECORDSIZE)); // Transfer this to Middle Layer including RecordSize.
            }
        }
        
         
//         for(int i = 0; i < bytes.length; i++) // Use this to find the damned distance between records. It takes a little bit of time.
//         {
//             inout.seek(i);
//             inout.read(bytes);
//             s = new String(bytes);
//             System.out.println("File Content" + i + ": " + s);  
//         }
         //System.out.println("File Content: " + s);
        
    }
    
    public void writeDB(byte[] bytes, int sectornum) throws IOException
    {
        
        
        int TotalNumOfRecords = SECTORSIZE / RECORDSIZE; // Gives the total number of records.
        int TotalNumOfSectors = (bytes.length / SECTORSIZE) / TotalNumOfRecords; // (Byte Length / Sector Size) / TotalNumOfRecords = Total Number of Sectors.
        System.out.println("Bytes Length: " + bytes.length);
        System.out.println("Total Number of Sectors: " + TotalNumOfSectors);
        
        
        if(sectornum > 0)
        {
            for(int i = TotalNumOfRecords * sectornum; i < TotalNumOfRecords * (sectornum + 1); i++)
            {
                inout.seek(SECTORSIZE * i);
                inout.writeBytes("RECORD: " + i);
            }   
        }
        
       else if(sectornum == 0) // We're only asked for sector 0 at this time.
        {
            for(int i = TotalNumOfRecords * sectornum; i < TotalNumOfRecords; i++)
            {
                inout.seek(SECTORSIZE * i);
                inout.writeBytes("RECORD: " + i);
                
            }
            
        }
    }
           
}
