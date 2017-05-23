import cs1.Keyboard;
public class TicTacToe
{
    public static void main(String[] args)
    {

        char x = 'x';
        char o = 'o';
        char[][] gameBoard = new char [3][3];
        int turn = 0;
        int outcome;
        int randomFirstTurn = (int)(1+2*Math.random());
        if (randomFirstTurn%2 == 0)
        {
            System.out.println("You go first. You are x's");
        }
        else
        {
            System.out.println("You go second. You are x's");
        }
        /*for (int i = 0; i < gameBoard.length; i++)
        {
            
            for (int j = 0; j < gameBoard.length; i++)
            {
                //gameBoard[i][j] = 0;
               
                if (j == 3)
                {
                    System.out.println();
                }
            }
        }
        for (int k = 0; k < 0; k++)
        {
            if ( k == 1 )
            {
                
            }
        }*/
        //System.out.print(gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2]);
    }
    public static void printScreen()
    {
        System.out.println("Would you like to print out the game board?(yes or no)");
        String answer = Keyboard.readString();
        if (answer.equals("yes"))
        {
            System.out.println();
        }

    }
}
/*
 2. You are going to write a TicTacToe.java file that 
 represents a tictactoe game. I will leave the implementation 
 of this game up to you (although I will provide some tips 
 down below if you want a starting point). You may write and 
 use whatever methods you would like. The user will play against 
 a computer. It will be randomly determined who goes first. The 
 computer should make moves at random and the user will be allowed 
 to make his/her move in any unoccupied square. I will be testing 
 your program by playing your game (running main, usually).

If you want a challenge, write your entire program from scratch. 
If not, follow some of these suggestions:


Here are some tips/thoughts that you may or may not choose to follow:
-represent the board using a 3x3 array, probably using chars or 
Strings to represent whether each location is 'x', 'o' or ' ' [blank]

-run the game through main, have a while loop to loop through each turn. 
This loop should check whether either player has won the game. Write 
several different other methods to split your program into parts.

-have a method called printScreen which will print the game board out to 
the user (however you decide you want to print it)

-have a method called checkWinner that will input the board and determine 
whether either player has won the game (and then return the winner). Call 
this after each move.

-have a method called computerMove which will input the board, randomly 
determine the computer's move based on which spaces are allowed, and return 
that location to main.

-have a method called playerMove that inputs the board, has the user put 
in their move, updates the board, and returns the changed board.

-remember that you have to pass all variables (like the board) from method 
to method

-think carefully about how you want the user to input their moves. You could 
have them type in row and column, number the locations 1 through 9, have them 
type "top middle" or whatever, it is up to you!



This is a big program. Try not to write it all at once - break it down into small 
chunks, think about how you want to organize it, and before you know it, you will 
have a program! When you finish, test your code several possible ways! For example, 
try to let the computer win and make sure that works.

Submit TicTacToe.java


FOR EXTRA CREDIT: Program an AI that can beat/tie me three games in a row... IF you are up to it.
 */