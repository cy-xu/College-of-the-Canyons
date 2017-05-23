public class SpellCasting
{
	public static void main(String[] args)
	{
		int a = 7;
		int b = 5;
		//this is sad, it makes it 1
		//System.out.println(  a / b);
	
		//cast a as a double - this says the next thing is a double
		//my computer will see 7.0 / 5.0
		//System.out.println( (double) a / b);
		
		// ACHTUNG: this does division BEFORE casting it, so its wrong
		//System.out.println( (double) (a / b));
		
		//now lets add two doubles, cast it as an int
		double d = 45.231;
		double e = 7.112;
		
		//to round it off, add first THEN round down
		System.out.println ( (int) (d + e) );
		
		
	
	}
	
}