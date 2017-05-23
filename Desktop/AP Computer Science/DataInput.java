//to include something someone else wrote
//use the word import
import cs1.Keyboard;

public class DataInput
{
	public static void main(String[] args)
	{
		System.out.println("what is your age?");
		
		//set up a variable, set it equal to what they type in
		int age = Keyboard.readInt();
		System.out.println("your age is " + age);
		
		//you can also use Keyboard.readChar() or Keyboard.readDouble()
		System.out.println("what is the first letter of your name");
		char name = Keyboard.readChar();
		System.out.println("hello mr/mrs. " + name);
	
	}
	
}