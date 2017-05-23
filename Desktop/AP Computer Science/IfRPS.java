import cs1.Keyboard;
public class IfRPS
{
	public static void main(String[] args)
	{
		System.out.println("rock, paper, or scissors?(case sensitive)");
		String user = Keyboard.readString();
		
		int random = (int)(1+(3*Math.random()));
				
		if (random == 1)
		{
			System.out.println("Computer chooses Rock!");
			String rock = new String("rock");
			String paper = new String("paper");
			String scissors = new String("scissors");
			if (user.equals(rock))
			{
				System.out.println("It is a tie!");
			}
			else if (user.equals(paper))
			{
				System.out.println("You win!");
			}
			else if (user.equals(scissors))
			{
				System.out.println("You lose!");
			}
		}
		
		else if (random == 2)
		{
			System.out.println("Computer chooses Paper!");
			String rock = new String("rock");
			String paper = new String("paper");
			String scissors = new String("scissors");
			if (user.equals(rock))
			{
				System.out.println("You lose!");
			}
			else if (user.equals(paper))
			{
				System.out.println("It is a tie!");
			}
			else if (user.equals(scissors))
			{
				System.out.println("You win!");
			}
		}
		
		else if (random == 3)
		{
			System.out.println("Computer chooses Scissors!");
			String rock = new String("rock");
			String paper = new String("paper");
			String scissors = new String("scissors");
			if (user.equals(rock))
			{
				System.out.println("You win!");
			}
			else if (user.equals(paper))
			{
				System.out.println("You lose!");
			}
			else if (user.equals(scissors))
			{
				System.out.println("It is a tie!");
			}
		}
		
		
	}
}
/*
6. Write a program called IfRPS.java - This program 
will let the user play rock paper scissors against a 
computer opponent. The user will type in a String, either 
“rock” “paper” or “scissors.” The program will then randomly 
decide which of the three options the computer opponent will 
choose, output that, and then decide (and print) who wins! 
Submit IfRPS.java
*/