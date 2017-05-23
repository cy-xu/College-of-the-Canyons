import cs1.Keyboard;
import java.util.ArrayList;
public class Blackjack
{
    private Deck deck;//master deck
    private Hand playerHand;//player's hand
    private Hand opponentHand;//computer's hand
    private double money;//total money
    
    //constructor method with input for total money you have from Casino
    public Blackjack(double cash)
    {
        playerHand = new Hand();
        opponentHand = new Hand();
        money = cash;
    }
    
    //get money from game of blackjack
    public double getMoney()
    {
        return money;
    }
    
    //runs blackjack
    public void gameBlackjack()
    {
        int aces = 0;//int for number of aces in hand
        int firstTurn = 0;//int to keep track of first turn
        double extra = 0;//double that is for additional payout for first turn 21
        double wager;
        playerHand.emptyHand();//reset player hand at start
        opponentHand.emptyHand();//reset computer hand at start
        deck = new Deck(); // reset deck at start
        deck.shuffle();//shuffles deck at start
        while(true)
        {
            System.out.println("You have $"+money+". How much would you like to bet($)?");
            wager = Keyboard.readDouble();//input amount to bet
            if (wager >= 0)
            {
                break;
            }
        }
        money = money - wager;//subtracts bet from total money
        playerHand.addCard(deck.dealCard());//deal cards to player
        playerHand.addCard(deck.dealCard());
        System.out.println("You start with two cards: "+playerHand+ "(Sum: "+ playerHand.handSum()+")");
        opponentHand.addCard(deck.dealCard());//deal cards to computer
        opponentHand.addCard(deck.dealCard());
        if (playerHand.handSum()==21)
        {
            System.out.println("21 ON FIRST TURN - WINNINGS INCREASED BY 1/2 ($"+(wager*1.5)+")");
            extra = wager*(.5);
        }
        System.out.println("Opponent starts with one unknown card and a(n) " + opponentHand.getFirstCard());
        while (true)
        {
            String answer;
            if (firstTurn == 0)//first turn (double down option)
            {
                System.out.println("HIT[1], STAY[2], QUIT[3], or DOUBLE-DOWN[4]?");
                answer = Keyboard.readString();
                if (answer.equals("4"))//doubles bet and hits player once
                {
                    if (wager*2 <= money + wager)
                    {
                        money = money - wager;
                        wager = wager * 2;
                        System.out.println("You bet double the original bet to $" + wager);
                        playerHand.addCard(deck.dealCard());
                        System.out.println("You hit. Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                        if (playerHand.checkBust() == true)//check player over 21
                        {
                            System.out.println("PLAYER BUST - You lose $"+wager);
                            break;
                        }
                        int breaker = 0;//int holder to break nested loops
                        while (true)
                        {
                            if (opponentHand.handSum() < 17)//computer hit if less than 17 hand
                            {
                                System.out.println("Opponent hits");
                                opponentHand.addCard(deck.dealCard());
                                if (opponentHand.handSum() > 21)//check computer over 21 
                                {
                                    System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                                    System.out.println("COMPUTER BUST - You win $"+(wager+extra));
                                    money = money + (wager*2) + extra;
                                    breaker = 1;
                                    break;
                                }
                            }
                            else
                            {
                                if (playerHand.handSum() > opponentHand.handSum())//check player hand better than computer hand
                                {
                                    System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                                    System.out.println("PLAYER WINS ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You win $"+(wager+extra));
                                    money = money + (wager*2) + extra;
                                    breaker = 1;
                                    break;
                                }
                                else if (playerHand.handSum() < opponentHand.handSum())//check computer hand better than player hand
                                {
                                    System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                                    System.out.println("COMPUTER WINS ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You lose $"+wager);
                                    breaker = 1;
                                    break;
                                }
                                else//check if tie (computer win)
                                {
                                    System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                                    System.out.println("TIE ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You lose nothing");
                                    money = money + wager;
                                    breaker = 1;
                                    break;
                                }
                            }
                        }
                        if (breaker == 1)//break second loop
                        {
                            breaker = 0;
                            break;
                        }
                    }
                    else//double bet greater than total money - can't double down
                    {
                        System.out.println("You don't have enough money to double down");
                        System.out.println("HIT[1], STAY[2], or QUIT[3]?");
                        answer = Keyboard.readString();
                    }
                }
                else if (answer.equals("1"))//gives player one more card
                {
                    firstTurn++;//add to first turn counter - next turn won't allow double down option
                    answer = "";
                    playerHand.addCard(deck.dealCard());
                    System.out.println("You hit. Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                    if (playerHand.checkBust() == true)//check if player over 21
                    {
                        System.out.println("PLAYER BUST - You lose $"+wager);
                        break;
                    }
                    if (opponentHand.handSum() < 17)//computer hit if less than 17 hand
                    {
                        System.out.println("Opponent hits");
                        opponentHand.addCard(deck.dealCard());
                        if (opponentHand.handSum() > 21)//check if computer over 21
                        {
                            System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                            System.out.println("COMPUTER BUST - You win $"+(wager+extra));
                            money = money + (wager*2) + extra;
                            break;
                        }
                    }
                }
                else if (answer.equals("2"))//player does nothing and waits for computer to finish
                {
                    int breaker = 0;//int holder to break nested loops
                    while (true)
                    {
                        if (opponentHand.handSum() < 17)//computer hit if less than 17 hand
                        {
                            System.out.println("Opponent hits");
                            opponentHand.addCard(deck.dealCard());
                            if (opponentHand.handSum() > 21)//check computer over 21
                            {
                                System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                                System.out.println("COMPUTER BUST - You win $"+(wager+extra));
                                money = money + (wager*2) + extra;
                                breaker = 1;
                                break;
                            }
                        }
                        else
                        {
                            if (playerHand.handSum() > opponentHand.handSum())//check player hand better than computer hand
                            {
                                System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                                System.out.println("Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                                System.out.println("PLAYER WINS ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You win $"+(wager+extra));
                                money = money + (wager*2) + extra;
                                breaker = 1;
                                break;
                            }
                            else if (playerHand.handSum() < opponentHand.handSum())//check computer hand better than player hand
                            {
                                System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                                System.out.println("Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                                System.out.println("COMPUTER WINS ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You lose $"+wager);
                                breaker = 1;
                                break;
                            }
                            else//check if tie (computer win)
                            {
                                System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                                System.out.println("Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                                System.out.println("TIE ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You lose nothing");
                                money = money + wager;
                                breaker = 1;
                                break;
                            }
                        }
                    }
                    if (breaker == 1)//break second loop
                    {
                        breaker = 0;
                        break;
                    }
                }
            }
            
            
            else//every turn after first turn (no double down option)
            {
                System.out.println("HIT[1], STAY[2], or QUIT[3]?");
                answer = Keyboard.readString();
            }
            if (answer.equals("1"))//gives player one more card
            {
                playerHand.addCard(deck.dealCard());
                System.out.println("You hit. Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                if (playerHand.checkBust() == true)//check player over 21
                {
                    System.out.println("PLAYER BUST - You lose $"+wager);
                    break;
                }
                if (opponentHand.handSum() < 17)//computer hit if less than 17
                {
                    System.out.println("Opponent hits");
                    opponentHand.addCard(deck.dealCard());
                    if (opponentHand.handSum() > 21)//check computer over 21
                    {
                        System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                        System.out.println("COMPUTER BUST - You win $"+(wager+extra));
                        money = money + (wager*2) + extra;
                        break;
                    }
                }
            }
            else if (answer.equals("2"))//player does nothing and waits for computer to finish
            {
                int breaker = 0;//int holder to break nested loops
                while (true)
                {
                    if (opponentHand.handSum() < 17)//computer hit if less than 17 hand
                    {
                        System.out.println("Opponent hits");
                        opponentHand.addCard(deck.dealCard());
                        if (opponentHand.handSum() > 21)//check computer over 21
                        {
                            System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                            System.out.println("COMPUTER BUST - You win $"+(wager+extra));
                            money = money + (wager*2) + extra;
                            breaker = 1;
                            break;
                        }
                    }
                    else
                    {
                        if (playerHand.handSum() > opponentHand.handSum())//check player hand better than computer hand
                        {
                            System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                            System.out.println("Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                            System.out.println("PLAYER WINS ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You win $"+(wager+extra));
                            money = money + (wager*2) + extra;
                            breaker = 1;
                            break;
                        }
                        else if (playerHand.handSum() < opponentHand.handSum())//check computer hand better than player hand
                        {
                            System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                            System.out.println("Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                            System.out.println("COMPUTER WINS ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You lose $"+wager);
                            breaker = 1;
                            break;
                        }
                        else//check if tie (computer win)
                        {
                            System.out.println("Computer reveals hand: "+ opponentHand + "(Sum: "+ opponentHand.handSum()+")");
                            System.out.println("Player hand: " + playerHand + "(Sum: "+ playerHand.handSum()+")");
                            System.out.println("TIE ("+playerHand.handSum()+"-"+opponentHand.handSum()+") - You lose nothing");
                            money = money + wager;
                            breaker = 1;
                            break;
                        }
                    }
                }
                if (breaker == 1)//break second loop
                {
                    breaker = 0;
                    break;
                }
            }
            else if (answer.equals("3"))//quit blackjack to play again menu
            {
                System.out.println("PLAYER QUITS - You lose $"+wager);
                break;
            }
        }
    }
    /*
     * The computer will only stop hitting if the value of its hand is 17 or over (18 including an ace)
     */
}
    
