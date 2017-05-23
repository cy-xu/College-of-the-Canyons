/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg282.project1;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MiddleLayer 
{
    public static void main()
    {
        
    }
    
   public static String buffer2Strings( byte [] data )
    {
        String s;
        s = new String(data);
        
        return s;
        
        
    }
   
   public static byte[] strings2Buffer( String records )
   {
     byte[] b = records.getBytes(Charset.forName("UTF-8"));
     
     return b;
   }
}


