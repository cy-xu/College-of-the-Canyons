import cs1.Keyboard;

public class RandomNumbers
{
	public static void main(String[] args)
	{
		int a;
		int b;
		System.out.println("Starting Number:");//tells starting value
		a = Keyboard.readInt();
		System.out.println("Ending Number:");//tells ending value
		b = Keyboard.readInt();
		double c = (int)(a+(b-a+1)*Math.random());//random number as a double
		System.out.println("Random number as an integer from "+a+" to "+b+":");
		System.out.println(c);
		
		
		c = (double) (a + (b-a) * Math.random());
		System.out.println("Random number as a double from "+a+" to "+b+":");
		System.out.println(c);
		
		
		
		
		/*
		Make a program called RandomNumbers.java that has the user 
		enter 2 integers, a and b. The program will then print out a
		 random double between a and b AND a random integer between a and b.
		  Use your notes from class today!
		*/
		
		
		
	
	}

}