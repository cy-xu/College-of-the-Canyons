import java.util.ArrayList;
import cs1.Keyboard;
public class Casino
{
    public static void main(String[] args)
    {
        double money = 100;
        while (true)
        {
            System.out.println();
            System.out.println("---------------------");
            System.out.println("WELCOME TO THE CASINO");
            System.out.println("---------------------");
            System.out.println();
            System.out.println("You have $"+money+".");
            System.out.println("Blackjack[1], Poker[2], Roulette[3], or Quit[4]");
            int whichGame = Keyboard.readInt();
            if (whichGame==1)
            {
                Blackjack playBlackjack = new Blackjack(money);
                System.out.println();
                System.out.println("--------------------");
                System.out.println("Welcome to Blackjack");
                System.out.println("--------------------");
                System.out.println();
                while (true)
                {
                    playBlackjack.gameBlackjack();
                    int breaker;
                    while (true)
                    {
                        System.out.println("Play Blackjack again? YES[1] or NO[2]");
                        String playAgain = Keyboard.readString();
                        breaker = 0;
                        if (playAgain.equals("1"))
                        {
                            break;
                        }
                        else if (playAgain.equals("2"))
                        {
                            System.out.println("You leave with $"+playBlackjack.getMoney()+". Returning to Casino...");
                            money = playBlackjack.getMoney();
                            breaker++;
                            break;
                        }
                    }
                    if (breaker > 0)
                    {
                        breaker = 0;
                        break;
                    }
                }
            }
            else if (whichGame==2)
            {
                Poker playPoker = new Poker(money);
                System.out.println();
                System.out.println("--------------------");
                System.out.println("Welcome to Poker");
                System.out.println("--------------------");
                System.out.println();
                while (true)
                {
                    playPoker.gamePoker();
                    int breaker;
                    while (true)
                    {
                        System.out.println("Play Poker again? YES[1] or NO[2]");
                        String playAgain = Keyboard.readString();
                        breaker = 0;
                        if (playAgain.equals("1"))
                        {
                            break;
                        }
                        else if (playAgain.equals("2"))
                        {
                            System.out.println("You leave with $"+playPoker.getMoney()+". Returning to Casino...");
                            money = playPoker.getMoney();
                            breaker++;
                            break;
                        }
                    }
                    if (breaker > 0)
                    {
                        breaker = 0;
                        break;
                    }
                }
            }
            else if (whichGame==3)
            {
                Roulette playRoulette = new Roulette(money);
                System.out.println();
                System.out.println("--------------------");
                System.out.println("Welcome to Roulette");
                System.out.println("--------------------");
                System.out.println();
                while (true)
                {
                    playRoulette.gameRoulette();
                    int breaker;
                    while (true)
                    {
                        System.out.println("Play Roulette again? YES[1] or NO[2]");
                        String playAgain = Keyboard.readString();
                        breaker = 0;
                        if (playAgain.equals("1"))
                        {
                            break;
                        }
                        else if (playAgain.equals("2"))
                        {
                            System.out.println("You leave with $"+playRoulette.getMoney()+". Returning to Casino...");
                            money = playRoulette.getMoney();
                            breaker++;
                            break;
                        }
                    }
                    if (breaker > 0)
                    {
                        breaker = 0;
                        break;
                    }
                }
            }
            else if (whichGame==4)
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
        }
    }

}
