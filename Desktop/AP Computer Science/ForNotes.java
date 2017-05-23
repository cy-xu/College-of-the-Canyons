public class ForNotes
{
	public static void main(String[] args)
	{
	/*
		//print out the numbers from 1 to 100
		//the dummy variable i set up called i = "index"
		//i++ means i = i+1
		for (int i = 1 ; i <= 100 ; i++)
		{
		//you can also use a break
			if (i == 69)
			{
			break;
			}	
			System.out.println(i);

		}
		
		//count by 2's, i go up by 2
		//start at 0, change initial value
		for (int i = 0 ; i <= 100 ; i=i+2)
		{
			System.out.println(i);
			//i can change i in here
			if (i == 48)
			{
			i = 60;
			}
		}
		*/
		
		//for loops are PERFECT for going through Strings
		//count all of the f's in a string
		/*
		String word = new String("your grade is hopefully not an f");
		int count = 0;
		//i am counting i up to BUT NOT INCLUDING charAt(length) because out of bounds
		for (int i = 0; i < word.length() ; i++)
		{
			//print each character
			// count f's
			System.out.print(word.charAt(i));
			if (word.charAt(i) == 'f')
			{
				count = count + 1;
			}
		}
		System.out.println("\n");
		
		//reverse that string
		//start counting at the end, go backwards
		//set up initial blank string
		String reverse = new String();
		for (int i = word.length() - 1 ; i >= 0; i--)
		{
			//build up reverse one char at a time
			reverse = reverse + word.charAt(i);
		}
		System.out.println(reverse);
		*/
		
		//nested for loop
		//for INSIDE A FREAKING FOR
		
		//times table 10 by 12, 10 rows, 12 columns
		
		//outer loop gives row
		/*
		for (int i = 1; i <= 10; i++)
		{
			//for each row, i need to go through each column
			for (int j = 1; j <= 12; j++)
			{
				//printing out i * j then a space
				System.out.print(i*j + " ");
			}
				//we want every time through the outer loop (after each row is done)
				//go to the next line
				System.out.println();
		}/*/
		
		//we are making a pyramid
		//5 rows:
		//loops through the rows
		for (int i = 1; i <= 52; i++)
		{
			//in each row, in row i, I print out that number i times
			//in row 1, i wanna go through my inner loop 1 time
			//in row 5 i wanna go through my inner loop 5 times
			//this way it stops when we have printed it i times
			//inner loop does the printing
			for (int c = 1; c <=i ; c++)
			{
				//print out the row we are in, print i
				//System.out.print(i);
			}
			//a blank line here
			//System.out.println();
			}
			
			//infinite for loop
			for (int i = 0; i > -10; i ++)
			{
				//every time through the loop, it adds one
				//but i will always be greater than -10!
			}
	
	}
}