/*
 * NAME: Nicole Stone
 * Date: 8/25/15
 * Project: Project 0 - UserInput Class
 * Description: Provides user input methods to negate the need for implementing a scanner
 * Includes integer, char, double, and string input methods with and without parameters
 */
package pathapp;

/*
 *
 * @author Nicole
 */
import java.util.*;

public class UserInput {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

      /* 1. Print a message before calling the method
         2. Call the method
         3. Print a message with the user input returned by the method */
        System.out.println("Please enter an integer: "); //Takes User Input of any integer
        System.out.print(getInt());

        System.out.println("Please enter a character: "); //Takes User Input of any character
        System.out.print(getChar());

        System.out.println("Please enter a double: "); //Takes User Input of any double
        System.out.print(getDouble());

        System.out.println("Please enter a string: "); //Takes User Input of any string
        System.out.print(getString());

        System.out.println("Please enter an integer: "); //Takes User Input of an integer 0-100
        System.out.print(getInt(0, 100));

        System.out.println("Please enter a character: "); //Takes User Input of a character a-z
        System.out.print(getChar('a', 'z'));

        System.out.println("Please enter a double: "); //Takes User Input of a double 1.0 to 300.5
        System.out.print(getDouble(1.0, 300.5));

        System.out.println("Please enter a string: "); //Takes User Input of a string 1-30 characters
        System.out.print(getString(1, 30));

    }
    /* **** 4 Methods from textbook chapter 1 **** */

    public static int getInt() {
        int temp = -100;
        System.out.println("Please enter an integer: ");
        while (!input.hasNextInt()) {
            System.out.println("You must enter an integer. ");
            input.nextLine();
        }
        while (input.hasNextInt()) {
            temp = input.nextInt();
        }
        input.nextLine();

        return temp;
    }

    public static char getChar() {
        char temp = input.next().charAt(0);
        input.nextLine();
        return temp;
    }

    public static double getDouble() {
        double temp = input.nextDouble();
        input.nextLine();
        return temp;
    }

    public static String getString() {
        return input.nextLine();
    }

    /* **** 4 new methods with input error checking **** */
    /*public static int getInt(int min, int max) *include string variable for directions*
     public static char getChar(char min, char max)       // min char 'A', max char 'Z'
     public static double getDouble(double min, double max)
     public static String getString(int min, int max)      // min and max length*/
    public static int getInt(int min, int max) {

        //if (temp >= min && temp <= max)
        int temp = -100;

        while (!input.hasNextInt()) {
            System.out.println("You must enter an integer.");
            input.nextLine();
        }
        if (input.hasNextInt()) {
                temp = input.nextInt();
            }
        while ((temp < min || temp > max)) {
            System.out.println("Please enter a number between " + min + " and "
                    + max + ": ");
            input.nextLine();
            if (input.hasNextInt()) {
                temp = input.nextInt();
            }
        }
        input.nextLine();
        return temp;
    }

    public static char getChar(char min, char max) {

        char temp = input.next().charAt(0);
        while (temp < min || temp > max) {
            System.out.println("Please enter a character between " + min + " and "
                    + max + ": ");
            temp = input.next().charAt(0);
        }
        input.nextLine();
        return temp;
    } // min char 'A', max char 'Z'

    public static double getDouble(double min, double max) {

        double temp = input.nextDouble();
        while (temp < min || temp > max) {
            System.out.println("Please enter a number between " + min + " and "
                    + max + ": ");
            temp = input.nextDouble();
        }
        input.nextLine();
        return temp;
    }

    public static String getString(int min, int max) {

        String temp = input.nextLine();
        while (temp.length() < min || temp.length() > max) {
            System.out.println("Please enter a string of " + min + " - " + max + " characters: ");
            temp = input.nextLine();
        }
        return temp;
    }// min and max length
}
