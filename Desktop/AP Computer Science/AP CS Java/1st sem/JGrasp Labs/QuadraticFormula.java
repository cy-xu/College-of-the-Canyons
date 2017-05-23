import cs1.Keyboard;

public class QuadraticFormula
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to the Quadratic Formula Solver\nax^2 + bx + c = 0\nPlease enter variables:");
		double a;
		double b;
		double c;
		System.out.println("a = ");
		a = Keyboard.readDouble();
		System.out.println("b = ");
		b = Keyboard.readDouble();
		System.out.println("c = ");
		c = Keyboard.readDouble();
		
		double aSolved = Math.pow(a,2);
		System.out.println("(" + a + "x)^2 + " + b + "x + " + c + " = 0" );
		//System.out.println(aSolved + "x^2 + " + b + "x + " + c + " = 0");
      
      double bSquared = Math.pow(b,2);
      double fourAC = 4*a*c;
      double totalSqRt = bSquared - fourAC;
      
      double sqRtSolve = Math.sqrt((double)totalSqRt);
      double topPlus = (-b) + sqRtSolve;
      double topMinus = (-b) - sqRtSolve;
      double answerPlus = topPlus/(2*a);
      double answerMinus = topMinus/(2*a);
      //System.out.println(totalSqRt);
      //System.out.println(fourAC);
      //System.out.println(bSquared);
      //System.out.println(sqRtSolve);
      //System.out.println(topPlus);
      //System.out.println(topMinus);
      System.out.println("The solutions are:");
	   System.out.println(answerPlus);
      System.out.println(answerMinus);
      
	   
	
	
	
	
	}





}