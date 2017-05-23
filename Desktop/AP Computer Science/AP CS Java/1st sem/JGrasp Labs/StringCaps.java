import cs1.Keyboard;
public class StringCaps
{
	public static void main(String[] args)
	{
		System.out.println("Name of string:");//asks name of string
		String name = new String();
		name = Keyboard.readString();
      int length = name.length();//length of name of string
      String firstFive = name.substring(0,5);//separates string - first 5 letters of string
		System.out.print(firstFive.toUpperCase());
      String end = name.substring(5,length);//the rest of the letters to string
      System.out.print(end);


/*
4. Write a program called StringCaps.java that inputs a sentence 
from the user. It should put the first five characters in all 
capital letters and then put the rest in lower case and print that. 
For instance, if the user types in “Batman: The Dark”, it would print 
out “BATMAn: the dark”. Submit StringCaps.java
*/

	}
}