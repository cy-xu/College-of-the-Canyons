import cs1.Keyboard;
public class ifSort
{
	public static void main(String[] args)
	{
		System.out.println("Please enter 3 floating point numbers:");
		double a = Keyboard.readDouble();
		double b = Keyboard.readDouble();
		double c = Keyboard.readDouble();
		
		if (a > b && b > c)
		{
			System.out.println(a+">"+b+">"+c);
		}
		
		else if (b>a && a>c)
		{
			System.out.println(b+">"+a+">"+c);
		}
		
		else if (a>c && c>b)
		{
			System.out.println(a+">"+c+">"+b);
		}
		
		else if (b>c && c>a)
		{
			System.out.println(b+">"+c+">"+a);
		}
		
		else if (c>b && b>a)
		{
			System.out.println(c+">"+b+">"+a);
		}
		
		else if (c>a && a>b)
		{
			System.out.println(c+">"+a+">"+b);
		}
		
		else if (a == b && b == c)
		{
			System.out.println("They are all equal!");
		}
	
	}
}
/*
5.  You are going to write a miniature sorting algorithm here 
in a program called IfSort.java. Have the user enter 3 floating 
point (double) numbers (in any order). Your program should then 
decide which one is the largest, which one is the smallest, and 
then print those out. If all three of the numbers are equal, the 
program should nicely admonish the user. Submit IfSort.java.
*/