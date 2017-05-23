
import cs1.Keyboard;
public class ForMaxMin
{
   public static void main(String[] args)
   {
      int highest = Integer.MIN_VALUE;
      int lowest = Integer.MAX_VALUE;
   
      System.out.println("How many numbers to enter?");
      int numbers = Keyboard.readInt();
      System.out.println("Enter your "+numbers+" now:");
      for (numbers = numbers; numbers > 0; numbers --)
      {
         int a = Keyboard.readInt();
         
      
         if (a > highest)
         {

            highest = a;
         }

         else if(a < lowest)
         {

            lowest = a;
         }
      }
      System.out.println("Highest number is: " + highest);
      System.out.println("Lowest number is: " + lowest);
      
   }
}