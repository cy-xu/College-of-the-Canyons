/*
2. Write a program (ForFactorial.java) that will ask 
the user to input a non-negative integer (it should ask 
them to re-enter the number if they put in a negative) 
and then use a for loop to calculate the factorial (!) of 
their number. Recall that 6! = 6*5*4*3*2*1=720, and as a 
special case, 0! = 1. Submit ForFactorial.java.    
[when testing your program, it probably won't give answers 
larger than 10! or so accurately because it will be larger 
Integer.MAX_VALUE.]
*/
import cs1.Keyboard;
public class ForFactorial
{
	public static void main(String[] args)
	{
		int count = 1;
	
		System.out.println("Input non-negative integer:");
		int number = Keyboard.readInt();
			while (number < 0)
			{
				System.out.println("Number is negative. Please re-enter positive integer:");
				number = Keyboard.readInt();
			}
			for (count = number-1; count > 0; count--)
			{
				
				
				number = number*count;
				System.out.println(number);
				if (count == 1)
				{
					System.out.println("Final answer = "+number);
				} 
			}
	}
}