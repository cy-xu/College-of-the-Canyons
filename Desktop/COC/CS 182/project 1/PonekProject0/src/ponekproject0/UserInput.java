package ponekproject0;

/*
Kevin Ponek
UserInput.java
March 8, 2016
CS 182 Lab Project 0
Description: This is the UserInput class that utilizes Scanner in order to allow user inputs
    for integer, character, double, and String values.  Each method is overloaded to have another
    method that controls the user input to be in he range of the maximum and minimum value parameters.
*/
import java.util.*;
import java.lang.Character;

public class UserInput {
    Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        //getInt test methods
        System.out.println("getInt method input: ");
        int testInt = getInt();
        System.out.println("The stored value is: " + testInt);
        
        System.out.println("getInt OVERLOADED method input with min of 1 and max of 10:");
        int testIntOverloaded = getInt(1,10);
        System.out.println("The stored value is: " + testIntOverloaded);
        
        //getChar test methods
        System.out.println("getChar method input");
        char testChar = getChar();
        System.out.println("The stored value is: " + testChar);
        
        System.out.println("getChar OVERLOADED method input with min of 'A' and max of 'Z'");
        char testCharOverloaded = getChar('A','Z');
        System.out.println("The stored value is: " + testCharOverloaded);
        
        //getDouble test methods
        System.out.println("getDouble method input");
        double testDouble = getDouble();
        System.out.println("The stored value is: " + testDouble);
        
        System.out.println("getDouble OVERLOADED method input with min of 1.0 and max of 10.0");
        double testDoubleOverloaded = getDouble(1,10);
        System.out.println("The stored value is: " + testDoubleOverloaded);
        
        //getString test methods
        System.out.println("getString method input");
        String testString = getString();
        System.out.println("The stored value is: " + testString);
        
        System.out.println("getString OVERLOADED method input with min length of 1 and max length of 10");
        String testStringOverloaded = getString(1,10);
        System.out.println("The stored value is: " + testStringOverloaded);
    }
    public static int getInt(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        return input.nextInt();
    }
    public static char getChar(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        return input.nextLine().charAt(0);
    }     
    public static double getDouble(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a double: ");
        return input.nextDouble();
    }
    public static String getString(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return input.nextLine();
    }
    public static int getInt(int min, int max){
        while(true){
            int var = getInt();
            if (var >= min && var <= max) return var;
            else {
                System.out.println("Value does not meet the max/min criteria: " + var + " - please try again.");
            }
        }
    }
    public static char getChar(char min, char max){// min char 'A', max char 'Z'
        char minCap = Character.toUpperCase(min);//converts min parameter to capital in order to make this method case insensitive
        char maxCap = Character.toUpperCase(max);// converts max parameter to capital in order to make this method case insensitive
        while(true){
            char var = getChar();
            char varCap = Character.toUpperCase(var);//stores converts value from getChar as capital letter for case insensitive
            if (varCap >= minCap && varCap <= maxCap) return var;
            else {
                System.out.println("Value does not meet the max/min criteria: " + var + " - please try again");
            }
        }
    }
    public static double getDouble(double min, double max){
        while(true){
            double var = getDouble();
            if (var >= min && var <= max) return var;
            else {
                System.out.println("Value does not meet the max/min criteria: " + var + " - please try again");
            }
        }
    }
    public static String getString(int min, int max){// min and max length
        while(true){
            String var = getString();
            if (var.length() >= min && var.length() <= max) return var;
            else {
                System.out.println("Value does not meet the max/min length criteria: " + var.length() + " - please try again");
            }
        }
    }
}
