import java.util.ArrayList;
public class Deck 
{
    private ArrayList<Card> deck = new ArrayList<Card>();//creates arraylist of cards
    
    //constructor method - creates 52 card deck
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
    
    //allows other classes to get deck
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    
    //allows other classes to get deck size
    public int getSize()
    {
        return deck.size();
    }
    
    //shuffles deck randomly
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
    
    //deals card from deck and removes it
    public Card dealCard()
    {
        Card next = deck.get(0);
        deck.remove(0);
        return next;
    }
    
    //returns arraylist deck as a string
    public String toString()
    {
        return deck.toString();
    }
}
