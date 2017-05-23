/*
5. ForWordCount.java - Write a program that will let the user input a sentence, 
and your program will then calculate the number of spaces in the sentence and 
use that to figure out the number of words in the sentence.

NOTE: if there are two or more spaces between words, your program should not 
count that as extra words. For instance, if you type in "My name is                 Mr. B", 
your program should recognize the 10 spaces in a row, and say that my string has 5 words 
in it. Submit ForWordCount.java
*/
import cs1.Keyboard;
public class ForWordCount
{
   public static void main(String[] args)
   {
      int count = 0;
   
      System.out.println("Please write a sentence:");
      String sentence = Keyboard.readString();
      for (int i = 0; i < sentence.length() ; i++)
		{
			//print each character
			// count f's
			//System.out.println(sentence.charAt(i));
			if (sentence.charAt(i) == ' ')
			{
            i++;
				count++;
            while (sentence.
			}
		}
      System.out.println(count);

   }
}