import cs1.Keyboard;
public class StringTypo
{
	public static void main(String[] args)
	{
		
		System.out.println("Name of string:");
		String name = new String();
		name = Keyboard.readString();//user inputs a string
		
		int length = name.length();//length of user's string
		
		int random = (int)(1 + (length)*Math.random());//selects random number from length of string
		System.out.println("Your string length is:");
		System.out.println(length);//prints length of string
		System.out.println("Your string random character number removed is " + random);//prints random number selected
		
		String start = (name.substring(0,(random-1)));//prints beginning half of string until the random number 
		System.out.print(start);
		name = name.substring(random);//prints last half of string after random number 
		
		System.out.print(name);
		
	
	
	
	
	}




}