
import java.util.ArrayList;
public class Hand
{
    //private Deck deck = new Deck();
    private ArrayList<Card> hand;
    public Hand()
    {
       hand = new ArrayList<Card>();
    }
    public void addCard(Card x)
    {
        hand.add(x);
    }
    public void removeCard(int x)
    {
        hand.remove(x);
    }
    /*public void emptyHand()
    {
        for (int i = 0; i < 10; i++)
        {
            hand.get(i).equals(null);
        }
    }*/
   public int handSum()
   {
        int sum = 0;
       // String cardNum;
        int aces = 0;
        for (int i = 0 ; i < hand.size(); i ++)
        {
            //System.out.println(hand);
            String cardNum = hand.get(i).getWordValue();
            //System.out.println(cardNum);
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
                }
 
            }
        }
        return sum;
    }
    /*public void draw(Deck x)
    {
        hand.add(x.getDeck().get(0));
        x.getDeck().remove(0);
    }*/

    public ArrayList<Card> getHand()
    {
        return hand;
    }
    public int getHandSize()
    {
        return hand.size();
    }
    public Card getCard(int x)
    {
        return hand.get(x);
    }
    public boolean checkBust()
    {
        if(handSum() > 21)
        {
            return true;
        }
        return false;
    }
    public String toString()
    {
        return hand.toString();
    }
}
