import cs1.Keyboard;
public class WhileBig
{
   public static void main(String[] args)
   {
      int start = 100;
      int count = 0;
      int sum = 0;
      double average = 0;
      
      while (start != 0)
      {
         int number = Keyboard.readInt();
         
         if (number == 0)
         {
            System.out.println("DONE! You have output "+count+" number(s) before entering 0.");
            System.out.println("The sum of all numbers = "+sum);
            System.out.println("The average of numbers = "+average);
            break;
         }
         
         else if (number != 0)
         {
            
            count +=1;
            
            int holder = number;
            sum = sum + holder;
            
            average = (double)(sum/count);
            
         }
      }
   }
}
/*
3. Write a problem (WhileBig.java) that allows the user to 
enter in as many numbers (ints) as they want until they enter 
0 (this is the the indication to stop). The program should then 
output how many numbers were entered (not counting 0), the sum 
of the numbers, and the average (as a double). Here is an example 
output:

Type a number:
>2
Type a number:
>4
Type a number:
>-5
Type a number:
>0
You entered 3 numbers, the sum is 1, the average is 0.333333333333333


Submit WhileBig.java
*/