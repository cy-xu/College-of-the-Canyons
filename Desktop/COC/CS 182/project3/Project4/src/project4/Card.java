package project4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*****************************************************************
   Class Card, the derived class each card is one object of type Card
   May be placed in a file named Card.java
******************************************************************/

class Card extends Link {
  private Image cardimage;
  private int cardnumber;//to keep track of the card numbers
  private int cardValue;
  private String cardWord;
  
  public Card (int cardnum) {
      switch (cardnum % 13) {
            case 0:
                cardWord = "Ace";
                cardValue = 11;
                break;
            case 1:
                cardWord = "Two";
                cardValue = 2;
                break;
            case 2:
                cardWord = "Three";
                cardValue = 3;
                break;
            case 3:
                cardWord = "Four";
                cardValue = 4;
                break;
            case 4:
                cardWord = "Five";
                cardValue = 5;
                break;
            case 5:
                cardWord = "Six";
                cardValue = 6;
                break;
            case 6:
                cardWord = "Seven";
                cardValue = 7;
                break;
            case 7:
                cardWord = "Eight";
                cardValue = 8;
                break;
            case 8:
                cardWord = "Nine";
                cardValue = 9;
                break;
            case 9:
                cardWord = "Ten";
                cardValue = 10;
                break;
            case 10:
                cardWord = "Jack";
                cardValue = 10;
                break;
            case 11:
                cardWord = "Queen";
                cardValue = 10;
                break;
            case 12:
                cardWord = "King";
                cardValue = 10;
                break;
        }
    cardimage = Project4.load_picture("images/gbCard" + cardnum + ".gif");
    cardnumber = cardnum;
    // code ASSUMES there is an images sub-dir in your project folder
    if (cardimage == null) {
      System.out.println("Error - image failed to load: images/gbCard" + cardnum + ".gif");
      System.exit(-1);
    }
  }
  public Card getNextCard() {
    return (Card)next;
  }
  public Image getCardImage() {
    return cardimage;
  }
  public int getCardValue(){
      return cardValue;
  }
  public String getCardWord(){
      return cardWord;
  }
  public int getCardNumber(){
      return cardnumber;
  }
}  //end class Card
