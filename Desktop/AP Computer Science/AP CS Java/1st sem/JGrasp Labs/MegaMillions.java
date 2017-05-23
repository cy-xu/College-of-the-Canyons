import cs1.Keyboard;

public class MegaMillions
{
	public static void main(String[] args)
	{
      int a;
      int b;
      int c;
      int d;
      int e;
      int f;
      
      System.out.println("Welcome to the Mega Millions lottery");
      System.out.println();
      System.out.println("Your numbers are:");// prints 5 random normal lotto numbers (1-56)
      a = (int)(1 + 56 * Math.random());
      b = (int)(1 + 56 * Math.random());
      c = (int)(1 + 56 * Math.random());
      d = (int)(1 + 56 * Math.random());
      e = (int)(1 + 56 * Math.random());
      System.out.println(a);
      System.out.println(b);
      System.out.println(c);
      System.out.println(d);
      System.out.println(e);
      System.out.println("Your golden number is:"); // prints the golden number (1-46)
      f = (int)(1+ 46 * Math.random());
      System.out.println(f);
   

	/*
	Program 2:

The California Mega Millions lottery picks its winners by
 choosing 5 random numbers (integers) from 1 to 56, followed
  by a golden ball that is a random number from 1 to 46. 
  Design a java program called MegaMillions.java that will
   randomly choose and print one set of six mega millions lottery
	 winners. For the sake of this program, we will assume that it
	  is alright if some of the numbers repeat (for instance, the number
	   17 could show up twice - next week we will learn how to prevent
		 this from happening).

TIP: Do not buy lotto tickets. The lotto is a tax on people who are bad at math.
	*/
	}
}	