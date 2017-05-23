/* Name: Thach Diep
 * Date: August 31, 2015
 * Description: Program used to test user input, with range of variable, using Scanner 
 */
package project2.thach.diep;

import java.util.Scanner;

public class UserInput {

    private static Scanner input = new Scanner(System.in);

    public static int getInt() {
        String message = "Invalid input. Please enter an INTEGER: ";

        return checkInt(message, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(int min, int max) {
        String message = "Invalid input. Please enter an INTEGER between " + min + " and " + max + ": ";

        return checkInt(message, min, max);
    }

    public static double getDouble() {
        String message = "Invalid input. Please enter an DOUBLE: ";

        return checkDouble(message, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public static double getDouble(double min, double max) {
        String message = "Invalid input. Please enter an DOUBLE between " + min + " and " + max + ": ";

        return checkDouble(message, min, max);
    }

    public static char getChar() {
        return getString().charAt(0);
    }

    public static char getChar(char min, char max) {
        char charOut = 'a';
        min = 'A';
        max = 'Z';
        getString();

        do {
            System.out.println("Invalid input. Please enter a CHAR between A and Z: ");
            charOut = getString().charAt(0);
        } while (getString().charAt(0) >= min && getString().charAt(0) <= max);
        return charOut;

    }

    public static String getString() {
        String userInput = input.nextLine();

        while (userInput.matches(".*\\s+.*")) {
            System.out.println("There's a SPACE in the entered field. Please re-enter: ");
            userInput = input.nextLine();
        }
        return userInput;
    }

    public static String getString(int min, int max) {
        String stringInput = getString();

        while (stringInput.length() < min || stringInput.length() > max) {
            System.out.println("Invalid input. Please enter a STRING with a length between " + min + " and " + max + ": ");
            stringInput = getString();
        }

        return stringInput;
    }

    private static int checkInt(String message, int min, int max) {
        int intNumber = 0;
        boolean valid = false;

        do {
            try {
                intNumber = Integer.parseInt(getString());
                if (intNumber >= min && intNumber <= max) {
                    valid = true;
                } else {
                    System.out.println(message);
                }
            } catch (NumberFormatException e) {
                System.out.println(message);
            }
        } while (valid == false);
        return intNumber;
    }

    private static double checkDouble(String message, double min, double max) {
        double doubleNum = 0;
        boolean valid = false;

        do {
            try {
                doubleNum = Double.parseDouble(getString());
                if (doubleNum >= min && doubleNum <= max) {
                    valid = true;
                } else {
                    System.out.println(message);
                }
            } catch (NumberFormatException e) {
                System.out.println(message);
            }
        } while (valid == false);
        return doubleNum;
    }
}
