public class StringCompare
{
	public static void main(String[] args)
	{
		String a = new String("slow");
		String b = new String("but");
		
		//a comes AFTER b, so it prints out a positive
		//System.out.println( a.compareTo(b) );
		
		a = new String("slow");
		b = new String("stumped");
		
		//now a comes before, so this is negative
		//System.out.println( a.compareTo(b) );
		
		b = new String("325a");
		//System.out.println( a.compareTo(b) );
		//a comes after b, numbers are first
		
		a = new String("jim");
		b = new String("Jim");
		System.out.println( a.compareTo(b) );
		
		//if i want to check if two are equal
		a = new String("Mitchell");
		b = new String("Mitchell");
		
		//this is 0, same string
		System.out.println( a.compareTo(b) );
		
		//this is the exact same as .equals
		if (a.compareTo(b) == 0)
		{
		
		}
		
		
		/*this doesnt work:
		if (a < b)
		{
			System.out.println("a is before b");
		} */
	
	
	}
}