/*
Kevin Ponek
Project3.java
April 12, 2016
CS 182 Lab Project 3
Description: This is a project that is the game of Blackjack card
 * game. If there happens to be an Ace in a deck, and
 * the cards add up to be over 21, the value of the ace becomes a 1. There is
 * score keeping in the game. There are buttons for New Game, Deal, Hit, Stay, 
 * and Quit.
*/

/**
 * *************************************************************
 * Project Number 4 - Comp Sci 182 - Data Structures (w/ Swing) Start Code -
 * Build your program starting with this code Card Game Copyright 2005
 * Christopher C. Ferguson This code may only be used with the permission of
 * Christopher C. Ferguson
 * *************************************************************
 */
package project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Project3 extends JFrame implements ActionListener {

    private static int winxpos = 0, winypos = 0;      // place window here

    private JButton exitButton, hitButton, stayButton, dealButton, newGameButton;
    private CardList theDeck = null;
    private JPanel northPanel;
    private MyPanel centerPanel;
    private static JFrame myFrame = null;

    private CardList playerHand = new CardList(0);
    private CardList dealerHand = new CardList(0);
    private int playerScore;
    private int dealerScore;
    private int playerNumWins = 0;
    private int dealerNumWins = 0;
    private String message = "";
    //private boolean playerTurn;//true if player turn, false if dealer turn
    //private boolean playerStay = false;//true if stay button has been hit, false otherwise
    private boolean gameOver = true;//true if game is over
    private boolean deal = false;//check if cards have been dealt yet

    ////////////              MAIN      ////////////////////////
    public static void main(String[] args) {
        Project3 tpo = new Project3();
    }

    ////////////            CONSTRUCTOR   /////////////////////
    public Project3() {
        myFrame = this;                 // need a static variable reference to a JFrame object
        northPanel = new JPanel();
        northPanel.setBackground(Color.white);
        dealButton = new JButton("Deal");
        northPanel.add(dealButton);
        dealButton.addActionListener(this);
        hitButton = new JButton("Hit");
        northPanel.add(hitButton);
        hitButton.addActionListener(this);
        stayButton = new JButton("Stay");
        northPanel.add(stayButton);
        stayButton.addActionListener(this);
        newGameButton = new JButton("New Game");
        northPanel.add(newGameButton);
        newGameButton.addActionListener(this);
        exitButton = new JButton("Exit");
        northPanel.add(exitButton);
        exitButton.addActionListener(this);
        getContentPane().add("North", northPanel);

        centerPanel = new MyPanel();
        getContentPane().add("Center", centerPanel);

        //theDeck = new CardList(52);
        newGame();
        setSize(800, 700);
        setLocation(winxpos, winypos);

        setVisible(true);
    }

    ////////////   BUTTON CLICKS ///////////////////////////
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);
        }
        if (e.getSource() == hitButton) {
            if (gameOver == false && deal == true) {
                message = "";
                dealCard(playerHand);
                repaint();
            } else if (gameOver == true) {
                message = "Press NEW GAME.";
                repaint();
            } else if (deal == false) {
                message = "Press DEAL.";
                repaint();
            }

        }
        if (e.getSource() == stayButton) {
            if (gameOver == false && deal == true) {
                message = "";
                while (true) {
                    if (addScore(dealerHand) < 17) {
                        dealCard(dealerHand);
                    } else {
                        break;
                    }
                }
                gameOver = true;
                repaint();
            } else if (gameOver == true) {
                message = "Press NEW GAME.";
                repaint();
            } else if (deal == false) {
                message = "Press DEAL.";
                repaint();
            }

        }
        if (e.getSource() == dealButton) {
            if (gameOver == false && (playerHand.getNumCards() == 0) && (dealerHand.getNumCards() == 0 && (deal == false))) {
                message = "";
                dealCard(playerHand);
                dealCard(dealerHand);
                dealCard(playerHand);
                dealCard(dealerHand);
                playerScore = addScore(playerHand);
                dealerScore = addScore(playerHand);
                gameOver = false;
                deal = true;
                repaint();
            } else if (gameOver == true) {
                message = "Press NEW GAME.";
                repaint();
            } else {
                message = "Press HIT or STAY.";
                repaint();
            }
        }
        if (e.getSource() == newGameButton) {
            if (gameOver == true) {
                message = "";
                //add point to winner for win-counter
                if (addScore(playerHand) > 21) {
                    dealerNumWins++;
                } //dealer bust
                else if (addScore(dealerHand) > 21) {
                    playerNumWins++;
                } //player total greater than dealer total
                else if (addScore(playerHand) > addScore(dealerHand)) {
                    playerNumWins++;
                } //dealer total greater than or equal to player total
                else if (addScore(playerHand) <= addScore(dealerHand)) {
                    dealerNumWins++;
                }

                newGame();
            } else {
                message = "Please finish the game or EXIT.";
            }
            repaint();
        }
    }

// This routine will load an image into memory
//
    public static Image load_picture(String fname) {
        // Create a MediaTracker to inform us when the image has
        // been completely loaded.
        Image image;
        MediaTracker tracker = new MediaTracker(myFrame);

        // getImage() returns immediately.  The image is not
        // actually loaded until it is first used.  We use a
        // MediaTracker to make sure the image is loaded
        // before we try to display it.
        image = myFrame.getToolkit().getImage(fname);

        // Add the image to the MediaTracker so that we can wait
        // for it.
        tracker.addImage(image, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        if (tracker.isErrorID(0)) {
            image = null;
        }
        return image;
    }
// --------------   end of load_picture ---------------------------

    public void newGame() {
        theDeck = new CardList(52);//resets deck
        playerHand = new CardList(0);//resets player hand
        dealerHand = new CardList(0);//resets enemy hand
        theDeck.shuffle();//shuffles deck
        //playerScore = 0;//resets scores
        // dealerScore = 0;//resets scores
        gameOver = false;
        deal = false;

    }

    public void startGame() {
        theDeck = new CardList(52);
        theDeck.shuffle();
        playerHand = new CardList(0);
        dealerHand = new CardList(0);
        gameOver = false;
        dealCard(playerHand);
        dealCard(dealerHand);
        dealCard(playerHand);
        dealCard(dealerHand);
        playerScore = addScore(playerHand);
        dealerScore = addScore(playerHand);
//      playerTurn = true;
    }

    public void dealCard(CardList hand) {
        if (theDeck.getNumCards() != 0) {
            Card current = theDeck.deleteCard(0);
            hand.insertCard(current);
            if (addScore(hand) > 21) {
                gameOver = true;
            }
        }
    }

    public int addScore(CardList hand) {
        int score = 0;
        int numAce = 0;
        Card current = hand.getFirstCard();
        while (current != null) {
            if ((current.getCardNumber() % 13) == 0) {
                numAce++;
                score = score + 11;
            } else if ((current.getCardNumber() % 13) < 10)//card values 2-10
            {
                score = score + (current.getCardNumber() % 13 + 1);
            } else if ((current.getCardNumber() % 13) >= 10) {//card values Jack, Queen, King
                score = score + 10;
            }
            current = current.getNextCard();
        }
        if (score > 21) {
            score = score - (numAce * 10);
        }
        return score;
    }

    public String checkWin() {
        //player bust
        if (addScore(playerHand) > 21) {
            //          dealerNumWins++;
            return "PLAYER LOSES: Player busts with " + addScore(playerHand);
        }
        //dealer bust
        if (addScore(dealerHand) > 21) {
            //         playerNumWins++;
            return "PLAYER WINS: Dealer busts with " + addScore(dealerHand);
        }
        if (gameOver == true) {
            //player total greater than dealer total
            if (addScore(playerHand) > addScore(dealerHand)) {
                //             playerNumWins++;
                return "PLAYER WINS: " + addScore(playerHand) + "-" + addScore(dealerHand);
            } //dealer total greater than or equal to player total
            else if (addScore(playerHand) <= addScore(dealerHand)) {
                //              dealerNumWins++;
                return "PLAYER LOSES: " + addScore(playerHand) + "-" + addScore(dealerHand);
            }
        }
        return "";
    }

    class MyPanel extends JPanel {

        ////////////    PAINT   ////////////////////////////////
        public void paintComponent(Graphics g) {
            //each card is 80 x 105
            //grid is 800 x 700
            g.drawString("--------------------------------------", 400, 10);
            g.drawString("WELCOME TO BLACKJACK", 400, 25);
            g.drawString("--------------------------------------", 400, 40);
            g.drawString("PLAYER SCORE: " + playerNumWins, 350, 55);
            g.drawString("DEALER SCORE: " + dealerNumWins, 500, 55);
            g.drawString("Player Cards:", 25, 100);
            g.drawString("Dealer Cards:", 25, 300);
            g.drawString("Player score: " + addScore(playerHand), 25, 225);
            g.drawString("Dealer score: ", 25, 425);
            if (gameOver == true) {
                g.drawString("Dealer score: " + addScore(dealerHand), 25, 425);
            }
            g.drawString(message, 400, 550);
            g.drawString(checkWin(), 400, 600);

            //if the deck is null, skip the card setup
            int xpos = 25, ypos = 110;
            if (theDeck == null) {
                return;
            }

            //player hand setup
            Card current = playerHand.getFirstCard();
            while (current != null) {
                Image tempimage = current.getCardImage();
                g.drawImage(tempimage, xpos, ypos, this);
                // note: tempimage member variable must be set BEFORE paint is called
                xpos += 80;
                if (xpos > 700) {
                    xpos = 25;
                    ypos += 105;
                }
                current = current.getNextCard(); //while
            }

            //dealer hand setup
            int newXpos = 25, newYpos = 310;
            current = dealerHand.getFirstCard();
            if (current != null && gameOver == false) {

                Image flipped = Project3.load_picture("images/gbCard52.gif");//faced down card
                //         dealerHand.getFirstCard().setCardImage(flipped);

                g.drawImage(flipped, 25, 310, this);

                current = current.getNextCard();
                newXpos = 115;
            }
            while (current != null) {
                Image tempimage = current.getCardImage();
                //          Image flippedCard = Project4.load_picture("images/gbCard52.gif");
                g.drawImage(tempimage, newXpos, newYpos, this);
                //             if (dealerTurn == false && newXpos > 25) {
                //                g.drawImage(flippedCard, newXpos, newYpos, this);
                //            }
// note: tempimage member variable must be set BEFORE paint is called
                newXpos += 80;
                if (newXpos > 700) {
                    newXpos = 25;
                    newYpos += 105;
                }
                current = current.getNextCard(); //while
            }

        }

    }

}
