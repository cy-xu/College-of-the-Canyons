import java.util.ArrayList;
import cs1.Keyboard;
public class Casino
{
    public static void main(String[] args)
    {
        int money = 100;
        System.out.println("Welcome to the Casino");
        System.out.println("You will start with $"+money+" to bet");
        while (true)
        {
            System.out.println("[blackjack],[poker], or [quit]");
            String whichGame = Keyboard.readString();
            if (whichGame.equals("blackjack"))
            {
                
            }
            else if (whichGame.equals("poker"))
            {
                
            }
            else if (whichGame.equals("quit"))
            {
                System.out.print("Player exits Casino with $"+money+". ");
                if (money == 0)
                {
                    System.out.println("You should really learn to conserve your money...");
                }
                else if (money <= 100)
                {
                    System.out.println("Maybe next time you'll actually make profit...");
                }
                else if (money > 100)
                {
                    System.out.println("Winner, winner, chicken dinner...");
                }
                break;
            }
            else
            {
                System.out.println("Please type a valid option");
            }
        }
    }

}
