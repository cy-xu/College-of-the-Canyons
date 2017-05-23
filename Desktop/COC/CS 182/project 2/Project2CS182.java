/*
Kevin Ponek
Project2CS182.java
March 17, 2016
CS 182 Lab Project 2
Description: Java file that contains three recursion methods.
    The first method sumInts(begin, end) will recursively add every integer from the beginning value until the end value.
    The second method minChar(string) will return the smallest character in the string (ASCII)
    The third method doublePay(day) will return the amount made on a certain day of the month if on the first day
        $0.01 is made, and every day after the amount made is double.
*/

package ponekproject2cs182;

public class Project2CS182 {
    public static void main(String[] args) {
        while (true){
            System.out.println("sumInts [1], minChar [2], doublePay [3], or exit [4]");
            int choice = UserInput.getInt(1, 4);
            //sumInts
            if (choice == 1){
                System.out.println("Please enter the beginning integer:");
                int begin = UserInput.getInt();
                System.out.println("Please enter the end integer:");
                int end = UserInput.getInt();
                System.out.println("The sum of all integers from " + begin + " to " + end + " is: " + sumInts(begin,end));
            }
            //minChar
            else if (choice == 2){
                System.out.println("Please enter a string to find the minimum character:");
                String str = UserInput.getString();
                System.out.println("The smallest character in the string is: " + minChar(str));
            }
            //doublePay
            else if (choice == 3){
                System.out.println("How many days will you be working? (1-31)");
                int days = UserInput.getInt(1,31);
                double money = doublePay(days);
                System.out.println("On day number " + days + ", you will make: $" + money);
            }
            //exit
            else if (choice ==4){
                System.out.println("Exiting the program.");
                break;
            }
            //should never get this, but just in case!
            else System.out.println("Not a valid integer value from 1 to 4: " + choice);
        }
    }
    
    /*  Exercise #4 Page 189 sumInts(begin,end), no global variables allowed
        "Given two integers start and end, where end is greater than start, 
        write a recursive Java method that returns the sum of the integers 
        from start through end, inclusive."
    */
    public static int sumInts(int begin,int end){
        if (end >= begin){
            return end + sumInts(begin,end-1);
        }
        return 0;
    }
    
    /*
        Exercise #8 Page 190 Method minChar, no global variables allowed
        "Write a method called minChar that returns the minimum character 
        (using the ASCII collating sequence) in a given string. So for example, 
        minChar("hello") returns 'e'."
    */
    public static char minChar(String s){
        String subStr;//string to make new string that compares last two characters and places the smaller one on the end and drops the larger one
        if (s.length() > 2){
            if (Character.toUpperCase(s.charAt(s.length()-1)) < Character.toUpperCase(s.charAt(s.length() - 2)) ){
                 subStr = s.substring(0,s.length()-2) + s.charAt(s.length()-1);
                 return minChar(subStr);
            }
            
            return minChar(s.substring(0,s.length()-1));
        }
        //compares last two values, or if there was only one value inputted - it will return first value
        if ((s.length() == 1) || (Character.toUpperCase(s.charAt(0)) < Character.toUpperCase(s.charAt(1)))){
            return s.charAt(0);
        }
        //returns second character when first character has a larger value than the second character
        return s.charAt(1);
    }
    
    /*
        Page 195 Double Your Pay, Everyday! Format answer in dollars and cents e.g. $ddd.cc
        "You have been offered a one month job that pays as follows: on the first day of the month, you are paid 
        1 cent.  On the second day, 2 cents, on the third, 4 cents, and so forth, the amount doubles every day.  
        Write a recursive method that, given the day number, computes the amount of money paid that day.  
        Would you want this job?"
    */
    public static double doublePay(int numDays){
        if (numDays == 1){
            return .01;
        }
        return doublePay(numDays - 1) * 2;
    }
}


//check that doublePay values are right
//check that a string will most likely return a space