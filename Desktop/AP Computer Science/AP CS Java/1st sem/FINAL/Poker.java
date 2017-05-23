import java.util.ArrayList;
import cs1.Keyboard;
public class Poker
{
    private Deck deck;
    private Hand hand;
    public Poker()
    {
        deck = new Deck();
        deck.shuffle();
        hand = new Hand();
        for (int i = 0 ; i < 5 ; i++)
        {
            hand.addCard(deck.dealCard());
        }
    }
    public void game()
    {
        System.out.println("Your start with hand: "+ hand);
            System.out.println("Would you like to exchange any cards? [yes] or [no]");
            String exchangeYesNo = Keyboard.readString();
            if (exchangeYesNo.equals("yes"))
            {
                int removeCount = 0;
                for (int i = 0 ; i < hand.getHandSize() ; i++)
                {
                    System.out.println("Exchange "+ hand.getCard(i) + "? [yes] or [no]");
                    String x = Keyboard.readString();
                    if (x.equals("yes"))
                    {
                        hand.removeCard(i);
                        removeCount++;
                        i--;
                    }
                    /*else if(x.equals("no"))
                    {
                        
                    }*/
                }
                System.out.println("Remaining hand is: " + hand);
                System.out.println("You draw "+removeCount+" cards");
                for (int j = 0; j < removeCount ; j++)
                {
                    hand.addCard(deck.dealCard());
                    
                }
                System.out.println("Hand: " + hand);
            }
            else
            {
                System.out.println("You keep hand: "+ hand);
            }
            
            // Checks if user has four of a kind
    		boolean FourOfAKind = false;
    		boolean ThreeOfAKind = false;
    		boolean Pair = false;
    		
    		for (String s: Card.kinds) {
    			int matches = Hand.numMatches(s);
    			
    			if (matches == 4)
    				FourOfAKind = true;
    			else if (matches == 3)
    				ThreeOfAKind = true;
    			else if (matches == 2)
    				Pair = true;
    		}
    
    		// Prints if user has full house or pairs
    		// Prints if user has four of a kind
    		if (FourOfAKind)
    			System.out.println("Congrats, you got a four of a kind!");		
    		else if (ThreeOfAKind && Pair)
    			System.out.println("Congrats, you got a full house!");
    		else if (ThreeOfAKind)
    			System.out.println("Congrats, you got a three of a kind!");
    		else if (Pair == true)
    			System.out.println("Congrats, you got a pair!");
    		else
    			System.out.println("You did not get a pair.");
            /*else if (exchangeYesNo.equals("no"))
            {
                
            }*/
            /*else
            {
                System.out.println("Please enter a valid answer");
            }*/
        /*while (true)
        {
            System.out.println("How many cards to exchange?");
            int cardExchange = Keyboard.readInt();
            if (cardExchange > 5 || cardExchange < 0)
            {
                System.out.println("Please enter valid number to exchange");
            }
            else
            {
                break;
            }
        }*/
    }
    public static void main(String[] args)
    {
        Poker play = new Poker();
        play.game();
    }
    
}
