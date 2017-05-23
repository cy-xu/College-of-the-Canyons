
import java.util.ArrayList;
public class Hand
{
    private ArrayList<Card> hand;//create arraylist of cards
    
    //constructor method
    public Hand()
    {
       hand = new ArrayList<Card>();
    }
    
    //empties hand
    public void emptyHand()
    {
        for (int i = 0 ; i < hand.size() ; i++)
        {
            hand.remove(i);
            i--;
        }
    }
    
    //adds inputted card to hand
    public void addCard(Card x)
    {
        hand.add(x);
    }
    
    //removes card from hand by spot in arraylist
    public void removeCard(int x)
    {
        hand.remove(x);
    }
    
    //sets card from hand as null by spot in arraylist
    public void setCardNull(int x)
    {
        hand.set(x,null);
    }
    
    //sorts hand by value
    public void sortValue() 
    {
      ArrayList<Card> handSub = new ArrayList<Card>();
      while (hand.size() > 0) 
      {
         int position = 0;  // Position of minimal card.
         Card x = hand.get(0);  // Minimal card.
         for (int i = 1; i < hand.size(); i++)//starts at second card
         {
            Card y = hand.get(i);
            if ( y.getValue() < x.getValue() || (y.getValue() == x.getValue() && y.getSuit() < x.getSuit()) ) 
            {
                position = i;
                x = y;
            }
         }
         hand.remove(position);
         handSub.add(x);
      }
      hand = handSub;
    }
    
    //sorts hand by suit
    public void sortSuit()
    {
        ArrayList<Card> handSub = new ArrayList<Card>();
        while (hand.size() > 0)
        {
            int position = 0;
            Card x = hand.get(0);
            for (int i = 1; i < hand.size(); i++)
            {
                Card y = hand.get(i);
                if (y.getSuit() < x.getSuit() || (y.getSuit() == x.getSuit() && y.getValue() < x.getValue()))
                {
                    position = i;
                    x = y;
                }
            }
            hand.remove(position);
            handSub.add(x);
        }
        hand = handSub;
    }
    
    //allows other classes to get hand
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    
    //allows other classes to get hand size
    public int getHandSize()
    {
        return hand.size();
    }
    
    //allows other classes to get the card in hand by spot in arraylist
    public Card getCard(int x)
    {
        return hand.get(x);
    }
    
    //allows other classes to get first card in arraylist
    public Card getFirstCard()
    {
        return hand.get(0);
    }
    
    
    /*
     * BLACKJACK SPECIFIC METHODS
     */
    
    //calculates sum of hand 
    public int handSum()
    {
        int sum = 0;
        int aces = 0;
        for (int i = 0 ; i < hand.size(); i ++)
        {
            String cardNum = hand.get(i).getWordValue();
            if (cardNum.equals("Ace"))
            {
                aces++;
                sum = sum + 11;
            }
            else if (cardNum.equals("2"))
            {
                sum = sum + 2;
            }
            else if (cardNum.equals("3"))
            {
                sum = sum + 3;
            }
            else if (cardNum.equals("4"))
            {
                sum = sum +4;
            }
            else if (cardNum.equals("5"))
            {
                sum = sum +5;
            }
            else if (cardNum.equals("6"))
            {
                sum = sum +6;
            }
            else if (cardNum.equals("7"))
            {
                sum = sum +7;
            }
            else if (cardNum.equals("8"))
            {
                sum = sum +8;
            }
            else if (cardNum.equals("9"))
            {
                sum = sum +9;
            }
            else if (cardNum.equals("10") || cardNum.equals("Jack") || cardNum.equals("Queen") || cardNum.equals("King"))
            {
                sum = sum + 10;
            }

                for (int j = 0 ; j < aces ; j++)
                {
                    if (sum > 21)
                    {
                            sum = sum -10;
                            aces--;
                    }
     
                }
        }
        return sum;
    }

    //checks if sum of hand is over 21
    public boolean checkBust()
    {
        if(handSum() > 21)
        {
            return true;
        }
        return false;
    }
    
    
    /*
     * POKER SPECIFIC METHODS
     */
    
    //checks if hand is a straight
    public boolean isStraight()
    {
        if (hand.get(0).getValue() + 1== hand.get(1).getValue() && hand.get(1).getValue() + 1 == hand.get(2).getValue() && hand.get(2).getValue() + 1 == hand.get(3).getValue() && hand.get(3).getValue() + 1 == hand.get(4).getValue())
        {
            return true;
        }
        return false;
        
    }
    
    //checks if hand is a flush
    public boolean isFlush()
    {
        if (hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(1).getSuit() == hand.get(2).getSuit() && hand.get(2).getSuit() == hand.get(3).getSuit() && hand.get(3).getSuit() == hand.get(4).getSuit())
        {
            return true;
        }
        return false;
    }
    
    //checks if hand contains four of a kind
    public boolean isFourOfKind()
    {
        if ((hand.get(0).getValue() == hand.get(1).getValue() && hand.get(1).getValue()  == hand.get(2).getValue() && hand.get(2).getValue() == hand.get(3).getValue()) || (hand.get(1).getValue() == hand.get(2).getValue() && hand.get(2).getValue() == hand.get(3).getValue() && hand.get(3).getValue() == hand.get(4).getValue()))
        {
            return true;
        }
        return false;
    }
    
    //checks if hand contains a full house
    public boolean isFullHouse()
    {
        if ((hand.get(0).getValue() == hand.get(1).getValue()) && (hand.get(2).getValue() == hand.get(3).getValue() && hand.get(3).getValue() == hand.get(4).getValue()))
        {
            return true;
        }
        else if ((hand.get(0).getValue() == hand.get(1).getValue() && hand.get(1).getValue() == hand.get(2).getValue()) && (hand.get(3).getValue() == hand.get(4).getValue()))
        {
            return true;
        }
        return false;
    }
    
    //checks if hand contains three of a kind
    public boolean isThreeOfKind()
    {
        if ((hand.get(0).getValue() == hand.get(1).getValue() && hand.get(1).getValue()  == hand.get(2).getValue()) || (hand.get(1).getValue() == hand.get(2).getValue() && hand.get(2).getValue() == hand.get(3).getValue()) || (hand.get(2).getValue() == hand.get(3).getValue() && hand.get(3).getValue() == hand.get(4).getValue()))
        {
            return true;
        }
        return false;
    }
    
    //checks if hand contains two pairs 
    public boolean isTwoPairs()
    {
        if ( (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(2).getValue() == hand.get(3).getValue()) || (hand.get(1).getValue() == hand.get(2).getValue() && hand.get(3).getValue() == hand.get(4).getValue()) || (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(3).getValue() == hand.get(4).getValue()) )
        {
            return true;
        }
        return false;
    }
    
    //checks if hand contains one pair & is a face value
    public boolean isOnePair()
    {
        if ( (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() > 9) || (hand.get(1).getValue() == hand.get(2).getValue() && hand.get(1).getValue() > 9) || (hand.get(2).getValue() == hand.get(3).getValue() && hand.get(2).getValue() > 9) || (hand.get(3).getValue() == hand.get(4).getValue() && hand.get(3).getValue() > 9))
        {
            return true;
        }
        return false;
    }
    
    //return arraylist hand as a string
    public String toString()
    {
        return hand.toString();
    }
}
