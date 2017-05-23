
public class RecurNotes
{
    //assume the user is not dumb and wont put in a negative
    public static int factorial(int x)
    {   
        //base case, 0! = 1
        if (x == 0)
        {
            return 1;
        } 
        
        //this will return x * ((x-1)! )
        else
        {
            return x*factorial(x-1);
        }
        
    }

    public static int abs(int x)
    {
        if (x>0)
            return x;
        else
            return -x;
        
    }
    
    public static int absDifference(int x, int y)
    {
        return abs(x-y);
        
    }
    
    public static void main(String[] args)
    {
        //this line doesnt do anything, it calls the method but 
        //doesnt store or print anything
        isPalindrome("slammin");
        boolean jim = isPalindrome("slammin");
        System.out.println(jim);
    }
    
    //i will write a method that determines if a string is a palindrome
    public static boolean isPalindrome(String str)
    {
        str = str.toLowerCase();
        //replace spaces with nothing, set str to that
        str = str.replace(" ","");
        //base case
        if (str.length() <= 1)
            return true;
        //compare first and last letters
        //if they are NOT the same
        if (str.charAt(0) != str.charAt(str.length() - 1))
        {
            return false;
        }
        //if the first and last ARE the same, keep looking
        //if (str.charAt(0) == str.charAt(str.length() - 1))
        //{
            //eliminate the first and last characters, check da rest
            //return what i get from checking the rest
            //considering everything but first and last
            return isPalindrome(str.substring(1,str.length() - 1));
       //}
        
    }
    
    //this is going to count the letter y
    //alternative to a for
    //check one character then check the rest
    public static int countY(String s)
    {
        //base case!
        if(s.length() == 0) 
            return 0;
        
        //compare first character
        if (s.substring(0,1).equals("y"))
        {
            //debugging technique
            //if i want to see what's happening, I can do this
            //i can print out the string we are counting every time we get here
            System.out.println(s);
            
            return 1 + countY(s.substring(1));
        }
        
        //if not found, check the rest
        return countY(s.substring(1));
        
    }
    
    //to reverse a String
    public static String reverse(String ab)
    {
        //base case
        if (ab.length() <= 1)
        {
            return ab;
        }
        
        //otherwise, im gonna do one character at a time
        //return last character plus reverse the rest
        return ab.charAt(ab.length()-1) + reverse(ab.substring(0,ab.length()-1));
    }
        
    //what does dog do? sit, stay
    public static int dog (int m)
    {
        if (m == 1) 
          return 1;
        else
          return 2*m + dog (m-1);
    }
}
