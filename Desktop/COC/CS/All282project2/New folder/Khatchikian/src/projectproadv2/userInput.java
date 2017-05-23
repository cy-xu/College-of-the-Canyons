/* 
 * Name(Author): Oganes
 * File:   userInput.java
 *  Date Created: Nov 16, 2015, 11:33:51 PM
 *  Project Name: userInput
 *  Description:
 */
package projectproadv2;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Oganes
 */
public class userInput {

    public static String getString() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }

    public static String getString(int min, int max) {
        String s = getString();
        while (s.length() < min || s.length() > max) {
            System.out.print(s + " is too long or too short"
                    + "\nPlease enter a String between " + min + " & " + max + "characters: ");
            s = getString();
        }
        return s;
    }

    public static char getChar() throws IOException {
        Scanner input = new Scanner(System.in);
        String c = input.next();
        //System.out.println("The Character Entered Is: " + c);
        return c.charAt(0);

    }

    public static char getChar(char min, char max) {
        Scanner input = new Scanner(System.in);
        String c = input.next();
        char char_c = c.charAt(0);
        System.out.println("The Character Entered Is: " + char_c);
        return char_c;
    }

    public static int getInt() throws IOException {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        //System.out.println("The Integer Entered Is: " + i);
        return i;

    }

    public static int getInt(int min, int max) throws IOException {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        if (i >= min && i <= max); else {
            System.out.println("The Integer Entered Is: " + i);
        }
        return i;
    }

    public static double getDouble() throws IOException {
        String s = getString();
        Double aDub = Double.valueOf(s);
        return aDub.doubleValue();

    }

    public static double getDouble(double min, double max) {
        Scanner input = new Scanner(System.in);
        double d = input.nextDouble();
        if (d >= min && d <= max); else {
            System.out.println("Please Re-Enter Double");
        }
        System.out.println("The Double Entered Is: " + d);
        return d;
    }
}
