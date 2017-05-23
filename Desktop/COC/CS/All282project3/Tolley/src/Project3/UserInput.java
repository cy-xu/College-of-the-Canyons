package Project3;
/*
 * COMP 282-17867
 * Project 3: UserInput
 * Programmer: Alexander Tolley
 * Date last edited: 12/03/2015
 * Description: This class contains static methods that obtain keyboard input
 *              from the user for use in future projects.
 */
import java.util.Scanner;

public class UserInput {
    static Scanner input = new Scanner(System.in);
    public static int getInt() {
        int intValue = input.nextInt();
        return intValue;
    }  
    public static long getLong() {
        long longValue = input.nextLong();
        return longValue;
    }

    public static char getChar() {
        String string = input.next();
        char charValue = string.charAt(0);
        return charValue;
    }

    public static double getDouble() {
        Double doubleValue = input.nextDouble();
        return doubleValue;
    }

    public static String getString() {
        String string = input.next();
        return string;
    }

    public static int getInt(int min, int max) {
        int intValue = getInt();
        while (intValue < min || intValue > max) {
            System.out.print("Invalid number entered: Please enter valid number (min: " + min + ", max: " + max + "): ");
            intValue = getInt();
        }
        return intValue;
    }
    
    public static long getLong(long min, long max){
        long longValue = getLong();
        while (longValue < min || longValue > max) {
            System.out.print("Invalid number entered: Please enter valid number (min: " + min + ", max: " + max + "): ");
            longValue = getLong();
        }
        return longValue;
    }

    public static char getChar(char min, char max) {
        char charValue = getChar();
        while (charValue < min || charValue > max) {
            System.out.print("Invalid character entered: Please enter valid character (min: " + min + ", max: " + max + "): ");
            charValue = getChar();
        }
        return charValue;
    }

    public static double getDouble(double min, double max) {
        double doubleValue = getDouble();
        while (doubleValue < min || doubleValue > max) {
            System.out.print("Invalid number entered: Please enter valid number (min: " + min + ", max: " + max + "): ");
            doubleValue = getDouble();
        }
        return doubleValue;
    }

    public static String getString(int min, int max) {
        String string = getString();
        while (string.length() < min || string.length() > max) {
            System.out.print("Invalid entry: Please enter valid entry: (min: " + min + ", max: " + max + "): ");
            string = getString();
        }
        return string;
    }
}
