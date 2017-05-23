import cs1.Keyboard;

public class Paint
{
    public static void main(String[] args)
    {	
	 		final int COVERAGE = 350;  //paint covers 350 sq ft/gal
        	//declare integers (or doubles, your choice) length, width, and height;
			double length;//feet
			double width;//feet
			double height;//feet
        	//declare double totalSqFt;
			double totalSqFt;
        	//declare double paintNeeded;
			double paintNeeded; //gallons

        	//Prompt for and read in the length of the room
			System.out.println("Length of Room:");
			length = Keyboard.readDouble();

        	//Prompt for and read in the width of the room
			System.out.println("Width of Room:");
			width = Keyboard.readDouble();

        	//Prompt for and read in the height of the room
			System.out.println("Height of room:");
			height = Keyboard.readDouble();

        	//Compute the total square feet to be painted--think
			/*int length = 25;
			int width = 25;
			int height = 8;
			double totalSqFt = length*width*height;*/
			
        	//about the dimensions of each wall
			double wallOne = height*width;
			double wallTwo = height*length;
			double wallAll = wallOne*2+wallTwo*2;
			double Ceiling = length*width;
			totalSqFt = wallAll+Ceiling;
			System.out.println("The total square feet of all the walls and the ceiling is: "+totalSqFt);
			
		
		
        	//Compute the amount of paint needed. Use COVERAGE
			paintNeeded = ((totalSqFt)/COVERAGE);
			int gallonsRounded = (int)paintNeeded + 1;

        	//Print the length, width, and height of the room and the
			
			System.out.println("The total amount of gallons of paint needed is: " + paintNeeded);
			
			System.out.println("You need to have " +gallonsRounded+ " gallon(s) to paint all walls and ceiling.");
			
        	//number of gallons of paint needed. 
			double doors;
			double windows;
			System.out.println("Number of windows:");
			windows = Keyboard.readDouble();
			System.out.println("Number of doors:");
			doors = Keyboard.readDouble();
			double doorArea = doors*20;
			double windowArea = windows*15;
			double doorsAndWindows = doorArea + windowArea;
			double areaWithout = totalSqFt - doorsAndWindows;
			System.out.println("The total square feet without doors and windows: "+areaWithout);
			double paintNeededFinal = ((areaWithout)/COVERAGE);
			System.out.println("The total amount of paint needed to paint all walls and ceiling without windows and doors is: "+paintNeededFinal);
			int gallonsRoundedNow = (int)paintNeededFinal + 1;
			System.out.println("You need to have " +gallonsRoundedNow+ " gallon(s) to paint all walls and ceiling without doors and windows.");

    }
}
