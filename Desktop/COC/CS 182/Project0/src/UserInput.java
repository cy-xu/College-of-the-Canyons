import java.util.Scanner;
        
public class UserInput {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("Please input an integer");
        int i = getInt(1,10);
        System.out.println("Inputted value: " + i);
        System.out.println("Please input a character");
        char c = getChar('a','z');
        System.out.println("Inputted value: " + c);
        System.out.println("Please input a double");
        double d = getDouble(1,10);
        System.out.println("Inputted value: " + d);
        System.out.println("Please input a string");
        String s = getString(1,10);
        System.out.println("Inputted value: " + s);
    }
    public static int getInt() {
        return input.nextInt();
    }
    public static int getInt(int min, int max){
        while(true){
            int i = getInt();
            if (i >= min && i <= max){
                return i;
            }
            System.out.println("Please enter a value between the min and max:");
        }
    }
    public static char getChar(){
        return input.next().charAt(0);
    }
    public static char getChar(char min, char max){
        while(true){
            char c = getChar();
            if (c >= min && c <= max){
                return c;
            }
            System.out.println("Please enter a value between the min and max:");
        }
    }
    public static double getDouble() {
        return input.nextDouble();
    }
    public static double getDouble(double min, double max){
        double d = getDouble();
        while(true){
            if (d >= min && d <= max){
                return d;
            }
            System.out.println("Please enter a value between the min and max:");
        }
    }
    public static String getString(){
        return input.next();
    }
    public static String getString(int min, int max){
        String s = getString();
        while(true){
            if (s.length() >= min && s.length() <= max){
                return s;
            }
            System.out.println("Please enter a value between the min and max:");
        }
    }
    
}
