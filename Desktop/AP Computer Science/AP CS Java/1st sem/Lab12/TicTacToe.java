import cs1.Keyboard;
public class TicTacToe
{

    public static void main(String[] args)
    {

        String x = new String("x");
        String o = new String("o");
        String space = new String(" ");
        String[][] gameBoard = new String [3][3];
        int winnerX = 0;
        int winnerO = 0;
        int tie = 0;
        for (int i = 0; i < gameBoard.length; i++)
        {
            
            for (int j = 0; j < gameBoard.length; j++)
            {
                gameBoard[i][j] = " ";

            }
        }
        
        int randomFirstTurn = (int)(1+2*Math.random());
        if (randomFirstTurn%2 == 0)
        {
            System.out.println("You go first(x). Computer goes second(o).");
            for (int turns = 0 ; turns < 9 ; turns++)
            {

                    playerMove(gameBoard);
                    printScreen(gameBoard);
                    checkWinner(gameBoard);
                //if (winnerX == 69 || winnerO == 101 || tie ==77)
                //{
                    if (winnerX == 69)
                    {
                        System.out.println("Player wins!:)");
                        break;
                    }
                    if (winnerO == 101)
                    {
                        System.out.println("Computer wins!:(");
                        break;
                    }
                    if (tie == 77)
                    {
                        System.out.println("Tie");
                        break;
                    }
                    //break;
                //}
                    computerMove(gameBoard);
                    printScreen(gameBoard);
                    checkWinner(gameBoard);
                    if (winnerX == 69)
                    {
                        System.out.println("Player wins!:)");
                        break;
                    }
                    if (winnerO == 101)
                    {
                        System.out.println("Computer wins!:(");
                        break;
                    }
                    if (tie == 77)
                    {
                        System.out.println("Tie");
                        break;
                    }
           
            }

        }
        else
        {
            System.out.println("You go second(x). Computer goes first(o).");
            for (int turns = 0 ; turns < 9 ; turns++)
            {

                    computerMove(gameBoard);
                    printScreen(gameBoard);
                    checkWinner(gameBoard);
                    if (winnerX == 69)
                    {
                        System.out.println("Player wins!:)");
                        break;
                    }
                    if (winnerO == 101)
                    {
                        System.out.println("Computer wins!:(");
                        break;
                    }
                    if (tie == 77)
                    {
                        System.out.println("Tie");
                        break;
                    }
                    playerMove(gameBoard);
                    printScreen(gameBoard);
                    checkWinner(gameBoard);

            
            }
        }
        


        

        
    }
    public static void printScreen(String[][] gameBoard)
    {

        {

            System.out.println(); 
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<3 ; j++)
                {
                    if(gameBoard[i][j].equals("x"))
                    {
                        System.out.print("x"); 
                    } 
                    if(gameBoard[i][j].equals("o"))
                    {
                        System.out.print("o"); 
                    }
                    if(gameBoard[i][j].equals(" "))
                    {
                        System.out.print(" "); 
                    }

                    if(j==0 || j==1) // checks columns for line placement
                    {
                         
                        System.out.print("|");
                    }
                }
                System.out.println();
            } 

 
        }

    }

    public static String[][] computerMove(String[][] gameBoard)
    {
        System.out.println();
        System.out.println("Computer Moves");
        
        int spaceTaken = 1337;
        while (spaceTaken == 1337)
        {
            int random = (int)(1 + 9*Math.random());
            if (random == 1)
            {
                if (gameBoard[0][0].equals(" "))
                {
                    gameBoard[0][0] = "o";
                    spaceTaken = 1338;
                }
                
            }
            else if (random == 2)
            {
                if (gameBoard[0][1].equals(" "))
                {
                    gameBoard[0][1] = "o";
                    spaceTaken = 1338;
                }
            }
            else if (random == 3)
            {
                if (gameBoard[0][2].equals(" "))
                {
                    gameBoard[0][2] = "o";
                    spaceTaken = 1338;
                }
            }
            else if (random == 4)
            {
                if (gameBoard[1][0].equals(" "))
                {
                    gameBoard[1][0] = "o";
                    spaceTaken = 1338;
                }
            }
            else if (random == 5)
            {
                if (gameBoard[1][1].equals(" "))
                {
                    gameBoard[1][1] = "o";
                    spaceTaken = 1338;
                }
            }
            else if (random == 6)
            {
                if (gameBoard[1][2].equals(" "))
                {
                    gameBoard[1][2] = "o";
                    spaceTaken = 1338;
                }
            }
            else if (random == 7)
            {
                if (gameBoard[2][0].equals(" "))
                {
                    gameBoard[2][0] = "o";
                    spaceTaken = 1338;
                }
            }
            else if (random == 8)
            {
                if (gameBoard[2][1].equals(" "))
                {
                    gameBoard[2][1] = "o";
                    spaceTaken = 1338;
                }
            }
            else if (random == 9)
            {
                if (gameBoard[2][2].equals(" "))
                {
                    gameBoard[2][2] = "o";
                    spaceTaken = 1338;
                }
            }
        }    
        return gameBoard;
    }
    public static String[][] playerMove(String[][] gameBoard)
    {
        System.out.println();
        int spaceTaken = 1337;
        while (spaceTaken == 1337) 
        {
            System.out.println("It is your move. Where would you like to move(1-9)?");
            System.out.println("1|2|3");
            System.out.println("4|5|6");
            System.out.println("7|8|9");
            int playerMove = Keyboard.readInt();
            System.out.println();
            if (playerMove == 1)
            {
                if (gameBoard[0][0].equals(" "))
                {
                    gameBoard[0][0] = "x";
                    spaceTaken = 1338;
                }
                
            }
            else if (playerMove == 2)
            {
                if (gameBoard[0][1].equals(" "))
                {
                    gameBoard[0][1] = "x";
                    spaceTaken = 1338;
                }
            }
            else if (playerMove == 3)
            {
                if (gameBoard[0][2].equals(" "))
                {
                    gameBoard[0][2] = "x";
                    spaceTaken = 1338;
                }
            }
            else if (playerMove == 4)
            {
                if (gameBoard[1][0].equals(" "))
                {
                    gameBoard[1][0] = "x";
                    spaceTaken = 1338;
                }
            }
            else if (playerMove == 5)
            {
                if (gameBoard[1][1].equals(" "))
                {
                    gameBoard[1][1] = "x";
                    spaceTaken = 1338;
                }
            }
            else if (playerMove == 6)
            {
                if (gameBoard[1][2].equals(" "))
                {
                    gameBoard[1][2] = "x";
                    spaceTaken = 1338;
                }
            }
            else if (playerMove == 7)
            {
                if (gameBoard[2][0].equals(" "))
                {
                    gameBoard[2][0] = "x";
                    spaceTaken = 1338;
                }
            }
            else if (playerMove == 8)
            {
                if (gameBoard[2][1].equals(" "))
                {
                    gameBoard[2][1] = "x";
                    spaceTaken = 1338;
                }
            }
            else if (playerMove == 9)
            {
                if (gameBoard[2][2].equals(" "))
                {
                    gameBoard[2][2] = "x";
                    spaceTaken = 1338;
                }
            }
        }
        return gameBoard;
    }
    public static int checkWinner(String[][] gameBoard)
    {
        int winnerX = 69;
        int winnerO = 101;
        int tie = 77;
        int none = 137;
        
        //check rows
        for (int line = 0 ; line < 3 ; line++)
        {
        
            if ((gameBoard[line][0] + gameBoard[line][1] + gameBoard[line][2]).equals("xxx"))
            {
                return winnerX;
            }
            if ((gameBoard[line][0] + gameBoard[line][1] + gameBoard[line][2]).equals("ooo"))
            {
                return winnerO;
            }
 
        } 


        //check columns
        for (int column = 0 ; column < 3 ; column++)
        {
        
            if ((gameBoard[0][column] + gameBoard[1][column] + gameBoard[2][column]).equals("xxx"))
            {
                return winnerX;
            }
            if ((gameBoard[0][column] + gameBoard[1][column] + gameBoard[2][column]).equals("ooo"))
            {
                return winnerO;
            }
        } 

        //check diagonals
        if ((gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2]).equals("xxx"))
        {
            return winnerX;
        }
        if ((gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2]).equals("ooo"))
        {
            return winnerO;
        }
        if ((gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0]).equals("xxx"))
        {
            return winnerX;
        }
        if ((gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0]).equals("ooo"))
        {
            return winnerO;
        }
       
        
   
        for (int line=0 ; line<3 ; line++)
        {
            for (int column=0 ; column<3 ; column++)
            {
                if (gameBoard[line][column].equals(" ") )
                {
                    return none;
                }
            }
        }
        return tie; 
        
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