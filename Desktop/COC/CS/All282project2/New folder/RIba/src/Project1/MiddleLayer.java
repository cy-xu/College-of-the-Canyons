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
 * MiddleLayer class
 * The purpose of the methods is to convert to/from a byte array that 
 * was read or being written to the hard drive.
 */

public class MiddleLayer {
    

// convert byte data to string array
// byte data containds 1 sector of data
static String [] buffer2Strings( byte [] data ) {
    // calculate number records
    int n = RandomAccessDB.SECTORSIZE/RandomAccessDB.RECORDSIZE;
    
    // make byte array
    String[] records = new String[n]; 
    
    // for each record
    for(int i=0;i<n;i++)
    {
        // make a string (use string buffer)
        StringBuffer sb = new StringBuffer(RandomAccessDB.RECORDSIZE);
        
        // for each byte in data
        for(int j=0;j<RandomAccessDB.RECORDSIZE;j++)
            {
            sb.append((char)data[i*RandomAccessDB.RECORDSIZE+j]);      
            }
        
        // store record
        records[i] = sb.toString();
    }
    
    // return records array
    return records;
    
}

// convert string array to byte array
static byte [] strings2Buffer( String [] records ) {
    
       // calculate number records
    int n = RandomAccessDB.SECTORSIZE/RandomAccessDB.RECORDSIZE;

    // make byte array
    byte[] data = new byte[RandomAccessDB.SECTORSIZE]; 
    
    // for each record
    for(int i=0;i<n;i++) {
        // for each char in record
        for(int j=0;j<RandomAccessDB.RECORDSIZE;j++) {
                 data[i*RandomAccessDB.RECORDSIZE+j] = (byte)records[i].charAt(j);      
            }
    }
    
    // return byte array
    return data;
}

    
}
