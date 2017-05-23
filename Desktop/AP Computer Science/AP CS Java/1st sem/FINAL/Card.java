
public class Card
{
    private int value;
    private int suit;
    private String wordValue;
    private String wordSuit;
    public Card()
    {
        value=69;
        suit=69;
    }
    public Card(int v, int s)
    {
        value = v;
        suit = s;
        toString();
    }
    public int getValue()
    {
        return value;
    }
    public int getSuit()
    {
        return suit;
    }
    public String getWordValue()
    {
        return wordValue;
        
    }
    public String getWordSuit()
    {
        return wordSuit;
    }
    public String toString()
    {
        if(value==1)
        {
            wordValue="Ace";
        }
        else if(value==2)
        {
            wordValue="2";
        }
        else if(value==3)
        {
            wordValue="3";
        }
        else if(value==4)
        {
            wordValue="4";
        }
        else if(value==5)
        {
            wordValue="5";
        }
        else if(value==6)
        {
            wordValue="6";
        }
        else if(value==7)
        {
            wordValue="7";
        }
        else if(value==8)
        {
            wordValue="8";
        }
        else if(value==9)
        {
            wordValue="9";
        }
        else if(value==10)
        {
            wordValue="10";
        }
        else if(value==11)
        {
            wordValue="Jack";
        }
        else if(value==12)
        {
            wordValue="Queen";
        }
        else if(value==13)
        {
            wordValue="King";
        }
        
        if(suit==0)
        {
            wordSuit="Clubs";
        }
        else if(suit==1)
        {
            wordSuit="Spades";
        }
        else if(suit==2)
        {
            wordSuit="Diamonds";
        }
        else 
        {
            wordSuit="Hearts";
        }
        
        return wordValue + " of " + wordSuit;
    }
}