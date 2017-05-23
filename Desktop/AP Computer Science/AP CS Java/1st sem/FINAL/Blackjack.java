import cs1.Keyboard;
import java.util.ArrayList;
public class Blackjack
{
    private Deck deck = new Deck();
    private Hand player;
    private Hand opponent;
    public static void main(String[] args)
    {
        Hand playerHand = new Hand();
        Hand opponentHand = new Hand();
        
        int aces = 0;
        
        Deck deck = new Deck();
        deck.shuffle();
        
        System.out.println("Welcome to blackjack!\nHow much would you like to bet($)?");
        int wager = Keyboard.readInt();
        
        System.out.print("You start with two cards: ");
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        System.out.println(playerHand);
        System.out.println("Sum is: " + playerHand.handSum());
        
        opponentHand.addCard(deck.dealCard());
        //System.out.println(opponentHand);
        opponentHand.addCard(deck.dealCard());
        //System.out.println(opponentHand);
        System.out.println("Opponent starts with one unknown card and a(n) " + opponentHand.getFirstCard());
        //System.out.println(opponentHand);
        //System.out.println(opponentHand.handSum());
        while (true)
        {
            System.out.println("[hit], [stay], or [quit]?");
            String answer = Keyboard.readString();
            
            if (answer.equals("hit"))
            {
                playerHand.addCard(deck.dealCard());
                System.out.println("You hit.\nPlayer hand: " + playerHand);
                System.out.println("Sum is: " + playerHand.handSum());
                if (playerHand.checkBust() == true)
                {
                    System.out.println("You bust :(\nYou lose $"+wager);
                    break;
                }
                if (opponentHand.handSum() < 17)
                {
                    System.out.println("Opponent hits");
                    //System.out.println(opponentHand);
                    opponentHand.addCard(deck.dealCard());
                    if (opponentHand.handSum() > 21)
                    {
                        System.out.println("Computer busts:)\nYou win "+wager);
                        break;
                    }
                }
            }
            
            else if (answer.equals("stay"))
            {
                int breaker = 0;
                while (true)
                {
                    if (opponentHand.handSum() < 17)
                    {
                        System.out.println("Opponent hits");
                        opponentHand.addCard(deck.dealCard());
                        if (opponentHand.handSum() > 21)
                        {
                            System.out.println("Computer has a hand sum of "+ opponentHand.handSum()+" with a hand of " + opponentHand);
                            System.out.println("Computer busts:)\nYou win $"+wager);
                            breaker = 1;
                            break;
                        }
                    }
                    
                    else
                    {
                        if (playerHand.handSum() > opponentHand.handSum())
                        {
                            System.out.println("Computer reveals his hand of "+ opponentHand+" with a sum of "+opponentHand.handSum());
                            System.out.println("Your hand with sum of "+ playerHand.handSum()+" beats "+opponentHand.handSum());
                            System.out.println("You win:)\nYou win $"+wager);
                            breaker = 1;
                            wager *= 2;
                            break;
                        }
                        else if (playerHand.handSum() < opponentHand.handSum())
                        {
                            System.out.println("Computer reveals his hand of "+ opponentHand+" with a sum of "+opponentHand.handSum());
                            System.out.println(opponentHand.handSum()+ " beats your hand with sum of "+ playerHand.handSum());
                            System.out.println("Computer wins:(\nYou lose $"+wager);
                            breaker = 1;
                            wager = 0;
                            break;
                        }
                        else
                        {
                            System.out.println("Computer reveals his hand of "+ opponentHand+" with a sum of "+opponentHand.handSum());
                            System.out.println("Your hand with sum of "+ playerHand.handSum()+" ties "+opponentHand.handSum());
                            System.out.println("Tie. Computer wins.\nYou lose $"+wager);
                            breaker = 1;
                            wager = 0;
                            break;
                        }
                        
                    }
                    
                }
                if (breaker == 1)
                {
                    break;
                }
            }
            
            else if (answer.equals("quit"))
            {
                System.out.println("You quit.\nYou lose $"+wager);
                break;
            }
            
            
        }
        //System.out.println("Would you like to play again?");
    }




}
    
