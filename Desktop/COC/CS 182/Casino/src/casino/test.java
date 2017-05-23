package project4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BlackJack extends JFrame implements ActionListener {

    private static int winxpos = 0, winypos = 0;      // place window here

    private JButton shuffleButton, exitButton, newButton, hitButton, stayButton;
    private JPanel northPanel;
    private Project4.MyPanel centerPanel;
    private static JFrame myFrame = null;

    private CardList deck = new CardList(0);
    private CardList playerHand = new CardList(0);
    private CardList dealerHand = new CardList(0);
    private int playerScore;
    private int dealerScore;

    public static void main(String[] args) {

    }

    public BlackJack() {
        myFrame = this;                 // need a static variable reference to a JFrame object
        northPanel = new JPanel();
        northPanel.setBackground(Color.white);
        hitButton = new JButton("Hit");
        northPanel.add(hitButton);
        hitButton.addActionListener(this);
        stayButton = new JButton("Stay");
        northPanel.add(stayButton);
        stayButton.addActionListener(this);
        exitButton = new JButton("Exit");
        northPanel.add(exitButton);
        exitButton.addActionListener(this);
        getContentPane().add("North", northPanel);

        centerPanel = new Project4.MyPanel();
        getContentPane().add("Center", centerPanel);

        setSize(800, 700);
        setLocation(winxpos, winypos);

        setVisible(true);

        //----------------------------------------------------
        newGame();
        dealCard(playerHand);
        dealCard(playerHand);
        dealCard(dealerHand);
        dealCard(dealerHand);
        addScore(playerHand);
        addScore(dealerHand);
    }

    public void newGame() {
        deck = new CardList(52);//resets deck
        playerHand = new CardList(0);//resets player hand
        dealerHand = new CardList(0);//resets enemy hand
        deck.shuffle();//shuffles deck
        playerScore = 0;//resets scores
        dealerScore = 0;//resets scores

    }

    public void dealCard(CardList hand) {
        Card current = deck.deleteCard(0);
        hand.insertCard(current);
    }

    public int addScore(CardList hand) {
        int score = 0;
        Card current = hand.getFirstCard();
        while (current != null) {
            if ((current.getCardNumber() % 13) == 0) {
                //check for aces here
            } else if ((current.getCardNumber() % 13) < 10)//card values 2-10
            {
                score = score + (current.getCardNumber() % 13);
            } else if ((current.getCardNumber() % 13) >= 10) {//card values Jack, Queen, King
                score = score + 10;
            }
            current = current.getNextCard();
        }
        return score;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);
        }
        if (e.getSource() == shuffleButton) {
            deck.shuffle();
            repaint();
        }
        if (e.getSource() == newButton) {
            deck = new CardList(52);
            repaint();
        }
        if (e.getSource() == hitButton) {
            Card current = deck.deleteCard(0);
            playerHand.insertCard(current);
            repaint();
        }
        if (e.getSource() == stayButton) {
            //implement later
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
}
