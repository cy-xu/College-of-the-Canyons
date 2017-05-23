
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