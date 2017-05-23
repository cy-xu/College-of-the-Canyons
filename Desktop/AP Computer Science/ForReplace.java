/*
3. You are now going to write your own version of the string 
method .replace(x,y) called ForReplace.java. The user will 
type in a string, and then two characters and your program 
should go through the string character by character and replace 
each instance of the first letter with the second letter as it 
builds a new string. For instance, if the user types in:

"Bandana man"
n
m
Your program should output: Bamdama mam

Notice how it only switches n into m and not vice versa. 
NOTE: YOUR CODE SHOULD NOT USE THE BUILT IN .replace FUNCTION!!!! 
Submit ForReplace.java

(fun fact: this is almost exactly how the actual String.replace(x,y) 
method is written)
*/
import cs1.Keyboard;
public class ForReplace
{
	public static void main(String[] args)
	{
		System.out.println("Please enter phrase:");
		String word = Keyboard.readString();
		System.out.println("Enter letter to be replaced:");
		char replaced = Keyboard.readChar();
		System.out.println("Enter letter to replace:");
		char replacer = Keyboard.readChar();
		 
		for (int i = 0; i < word.length(); i++)
		{
			
        
         
			if (word.charAt(i) == replaced)
			{
            
            System.out.print(replacer);
            
				/*String replacedString = word.replace(replaced,replacer);
            System.out.println(replacedString);*/
			}
         else if(word.charAt(i) != replaced)
         {
            System.out.print(word.charAt(i));
         }
		}
	}
}