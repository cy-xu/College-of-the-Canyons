import java.util.ArrayList;
public class Deck 
{
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<Card> hand = new ArrayList<Card>();
    //private int numCards;
    //make a deck of cards
    public Deck()
    {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int v = 1; v < 14; v++)
        {
            for (int s = 0; s < 4; s++)
            {
                Card nextCard = new Card(v,s);          
                cards.add(nextCard);
            }
        }
        deck = cards;
        
    }
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    public int getSize()
    {
        return deck.size();
    }
    public void shuffle()
    {

        ArrayList<Card> shuffled = new ArrayList<Card>();
        while (shuffled.size() < 52)
        {
            int random = (int)(deck.size()*Math.random());
            shuffled.add(deck.get(random));
            deck.remove(random);
        }
    
        deck = shuffled;
    }
    public Card dealCard()
    {
        Card next = deck.get(0);
        deck.remove(0);
        return next;
    }
    /*public Card draw()
    {
        return deck.remove(0);
    }*/
    public String toString()
    {
        return deck.toString();
    }
}
