
package project4;

public class Card {
    private int value;//values 2 - 14 (2 is card number 2, 13 is king, the rest is ace)
    private int suit;//0 is clubs, 1 is spades, 2 is diamonds, rest is hearts
    private int identifier;//0 - 51 based on images
    
    //constructor method - take one integer input and one string input
    public Card(int v, int s){
        value = v;
        suit = s;
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
    //converts and allows access to string value
    public String getWordValue()
    {
        if(value==2)
        {
            return "2";
        }
        else if(value==3)
        {
            return "3";
        }
        else if(value==4)
        {
            return "4";
        }
        else if(value==5)
        {
            return "5";
        }
        else if(value==6)
        {
            return "6";
        }
        else if(value==7)
        {
            return "7";
        }
        else if(value==8)
        {
            return "8";
        }
        else if(value==9)
        {
            return "9";
        }
        else if(value==10)
        {
            return "10";
        }
        else if(value==11)
        {
            return "Jack";
        }
        else if(value==12)
        {
            return "Queen";
        }
        else if(value==13)
        {
            return "King";
        }
        else 
        {
            return "Ace";
        }
    }
    //converts and allows access to string suit
    public String getWordSuit()
    {
        if(suit==0)
        {
            return "Clubs";
        }
        else if(suit==1)
        {
            return "Spades";
        }
        else if(suit==2)
        {
            return "Diamonds";
        }
        else 
        {
            return "Hearts";
        }
    }
}
