
package project4;

public class Deck extends CardList{
    private CardList deck = new CardList(0);//creates empty CardList that represents the deck
    
    //constructor method - creates 52 card deck
    public Deck(){
        CardList cards = new CardList(52);
        deck = cards;
    }
    
    //allows other classes to get deck
    public CardList getDeck(){
        return deck;
    }
    
    //deals card from deck and removes it
    public Card dealCard(){
        Card current = deck.getFirstCard();
    }
}
