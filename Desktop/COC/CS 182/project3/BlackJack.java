
package project4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BlackJack {
    private CardList deck = new CardList(0);
    private CardList playerHand = new CardList(0);
    private CardList enemyHand = new CardList(0);
    private int playerScore;
    private int enemyScore;
    
    public static void main(String[] args){
        
    }
    public void play(){
        
    }
    public void newGame(){
        deck = new CardList(52);//resets deck
        playerHand = new CardList(0);//resets player hand
        enemyHand = new CardList(0);//resets enemy hand
        deck.shuffle();//shuffles deck
        playerScore = 0;//resets scores
        enemyScore = 0;//resets scores
        
    }
    public void dealCard(){
        Card current = deck.getFirstCard();
        
    }
}
