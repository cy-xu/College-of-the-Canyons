
public class Card
{
    private int value;//integer value of card
    private int suit;//integer suit of card
    private String wordValue;//string value of card
    private String wordSuit;//string suit of card
    
    //constructor method - take two integer inputs
    public Card(int v, int s)
    {
        value = v;
        suit = s;
        toString();
    }
    
    //allows other classes to get value
    public int getValue()
    {
        return value;
    }
    
    //allows other classes to get suit
    public int getSuit()
    {
        return suit;
    }
    
    //allows other classes to get word value
    public String getWordValue()
    {
        return wordValue;
    }
    
    //allows other classes to get word suit
    public String getWordSuit()
    {
        return wordSuit;
    }
    
    //returns card values as string
    public String toString()
    {

        if(value==1)
        {
            wordValue="2";
        }
        else if(value==2)
        {
            wordValue="3";
        }
        else if(value==3)
        {
            wordValue="4";
        }
        else if(value==4)
        {
            wordValue="5";
        }
        else if(value==5)
        {
            wordValue="6";
        }
        else if(value==6)
        {
            wordValue="7";
        }
        else if(value==7)
        {
            wordValue="8";
        }
        else if(value==8)
        {
            wordValue="9";
        }
        else if(value==9)
        {
            wordValue="10";
        }
        else if(value==10)
        {
            wordValue="Jack";
        }
        else if(value==11)
        {
            wordValue="Queen";
        }
        else if(value==12)
        {
            wordValue="King";
        }
        else if(value==13)
        {
            wordValue="Ace";
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