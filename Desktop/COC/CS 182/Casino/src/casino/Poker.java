import java.util.ArrayList;
import cs1.Keyboard;
public class Poker
{
    private Deck deck;//master deck
    private Hand hand;//player's hand
    private double money;//total money
    
    //constructor method with input for total money you have from Casino
    public Poker(double cash)
    {
        hand = new Hand();
        money = cash;
    }
    
    //get money from game of poker
    public double getMoney()
    {
        return money;
    }
    
    //runs poker
    public void gamePoker()
    {
        hand.emptyHand();//reset hand at start
        deck = new Deck();//reset deck at start
        deck.shuffle();//shuffle deck at start
        double wager;
        while(true)
        {
            System.out.println("You have $"+money+". How much would you like to bet($)?");
            wager = Keyboard.readDouble();//input amount to bet
            if (wager >= 0)
            {
                break;
            }
        }
        money = money - wager; //subtracts bet from total money
        for (int i = 0 ; i < 5 ; i++)
        {
            hand.addCard(deck.dealCard());//deals player 5 cards to start
        }
        hand.sortValue();//sort player hand values from 2 to Ace
        int removeCount = 0;//keeps track of removed cards
        System.out.println("You start with hand: ["+hand.getCard(0)+"(1), "+hand.getCard(1)+"(2), "+hand.getCard(2)+"(3), "+hand.getCard(3)+"(4), "+hand.getCard(4)+"(5)]");
        System.out.println("Enter cards to remove: [1], [2], [3], [4], [5], ALL[6], DONE[7]");
        /*
         * removes entered cards from hand (1-5)
         * all option removes the whole hand
         * done option ends remove screen
         */
        while(true)
        {
            String cardRemove = Keyboard.readString();
            if (cardRemove.equals("1"))//sets first card in hand as null
            {
                hand.setCardNull(0);
            }
            if (cardRemove.equals("2"))//sets second card in hand as null
            {
                hand.setCardNull(1);
            }
            if (cardRemove.equals("3"))//sets third card in hand as null
            {
                hand.setCardNull(2);
            }
            if (cardRemove.equals("4"))//sets fourth card in hand as null
            {
                hand.setCardNull(3);
            }
            if (cardRemove.equals("5"))//sets fifth card in hand as null
            {
                hand.setCardNull(4);
            }
            if (cardRemove.equals("6"))//removes all cards in hand
            {
                for (int i = 0; i < hand.getHandSize(); i++)
                {
                    hand.removeCard(i);
                    removeCount++;//adds count for every card removed in hand
                    i--;
                }
                break;
            }
            if (cardRemove.equals("7"))//ends loop of removing hand cards
            {
                break;
            }
        }
        for (int i = 0; i < hand.getHandSize(); i++)//cards set as null in hand are removed
        {
            if (hand.getCard(i) == null)
            {
                hand.removeCard(i);
                removeCount++;//adds count for every card removed in hand
                i--;
            }
        }
        System.out.println("Remaining hand is: " + hand);
        for (int j = 0; j < removeCount ; j++)//add card for every removed card
        {
            hand.addCard(deck.dealCard());
        }
        hand.sortValue();//sort player hand values from 2 to Ace
        System.out.println("You draw "+removeCount+" card(s). Hand: " + hand);
        
        if (hand.isStraight() == true && hand.isFlush() == true && hand.getCard(4).getValue() == 13)//checks if hand has Royal Flush
        {
            System.out.println("You have a Royal Flush! Since nobody will ever get this: I like men. You win $"+(wager*250));
            money = money + (wager*251);
        }
        else if (hand.isStraight() == true && hand.isFlush() == true)//checks if hand has Straight Flush
        {
            System.out.println("You have a Straight Flush! Share some of your luck plz! You win $"+(wager*50));
            money = money + (wager*51);
        }
        else if (hand.isFourOfKind() == true)//checks if hand has Four of a Kind
        {
            System.out.println("You have a Four of a Kind! You're really lucky! :) You win $"+(wager*25));
            money = money + (wager*26);
        }
        else if (hand.isFullHouse() == true)//checks if hand has Full House
        {
            System.out.println("You have a Full House! You're pretty lucky! You win $"+(wager*9));
            money = money + (wager*10);
        }
        else if (hand.isFlush() == true)//checks if hand has Flush
        {
            System.out.println("You have a Flush! That's a good hand! You win $"+(wager*6));
            money = money + (wager*7);
        }
        else if (hand.isStraight() == true)//checks if hand has Straight
        {
            System.out.println("You have a Straight! That's a good hand! You win $"+(wager*4));
            money = money + (wager*5);
        }
        else if (hand.isThreeOfKind() == true)//checks if hand has Three of a Kind
        {
            System.out.println("You have a Three of a Kind! That's a decent hand! You win $"+(wager*3));
            money = money + (wager*4);
        }
        else if (hand.isTwoPairs() == true)//checks if hand has Two Pairs
        {
            System.out.println("You have Two Pairs! That's an okay hand I guess... You win $"+(wager*2));
            money = money + (wager*3);
        }
        else if(hand.isOnePair() == true)//checks if hand has One Pair
        {
            System.out.println("You have One Pair! I've seen better... You win $"+wager);
            money = money + (wager*2);
        }
        else//no poker hands in current hand
        {
            System.out.println("Nothing good in your hand. You lose $"+wager);
        }
    }
}
