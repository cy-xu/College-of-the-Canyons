import cs1.Keyboard;
public class Roulette
{
    private double money;//stores money during roulette game
    
    //input cash to move money from casino to roulette
    public Roulette(double cash)
    {
        money = cash;
    }
    
    //gets money from roulette
    public double getMoney()
    {
        return money;
    }
    
    //plays game of roulette
    public void gameRoulette()
    {
        double bet;
        while(true)
        {
            System.out.println("You have $"+money+". How much would you like to bet($)?");
            bet = Keyboard.readDouble();//input amount to bet
            if (bet >= 0)
            {
                break;
            }
        }
        String oddOrEven;
          while (true)
          {
              System.out.println("ODD[1], EVEN[2]?");
              oddOrEven = Keyboard.readString();
              if (oddOrEven.equals("1") || oddOrEven.equals("2"))
              {
                  break;
                }
            }
          String even = new String ("2");
          String odd = new String ("1");
          String playOrQuit = new String();
          int random = (int)(37*Math.random());
          System.out.println(random);
          
          while (true)
          if (random%2 == 0 && (oddOrEven.equals(even)))//even win
          {
             System.out.println("It is even. You just won $" + bet + ".");
             money = money + bet;
             
             System.out.println("You have $"+money+". PLAY[1] or QUIT[2]?");
             playOrQuit = Keyboard.readString();
             if (playOrQuit.equals("1"))
             {
                 
                }
                else if (playOrQuit.equals("2"))
                {
                    System.out.println("PLAYER QUITS. You just lost $" + bet + ".");
                    break;
                }
               
                
             System.out.println("How much bet($)?");
             bet = Keyboard.readInt();
             System.out.println("ODD[1], EVEN[2], or QUIT[3]?");
             oddOrEven = Keyboard.readString();
             if (oddOrEven.equals("3"))
             {
                 System.out.println("PLAYER QUITS. You just lost $" + bet + ".");
                break;
             }
             random = (int)(37*Math.random());
          }
          else if (random%2 != 0 && (oddOrEven.equals(odd)))//odd win
          {
             System.out.println("It is odd.  You just won $" + bet + ".");
             money = money + bet;
             System.out.println("You have $"+money+". PLAY[1], or QUIT[2]?");
             playOrQuit = Keyboard.readString();
             if (playOrQuit.equals("1"))
             {
                 
                }
                else if (playOrQuit.equals("2"))
                {
                    System.out.println("PLAYER QUITS. You just lost $" + bet + ".");
                    break;
                }
             System.out.println("How much bet($)?");
             bet = Keyboard.readInt();
             System.out.println("ODD[1], EVEN[2], or QUIT[3]?");
             oddOrEven = Keyboard.readString();
             if (oddOrEven.equals("3"))
             {
                 System.out.println("PLAYER QUITS. You just lost $" + bet + ".");
                break;
             }
             random = (int)(37*Math.random());
          }
          else if (random%2 == 0 && (oddOrEven.equals(odd)))//even lose
          {
             System.out.println("It is even. You just lost $" + bet + ".");
             money = money - bet;
             System.out.println("You have $"+money+". PLAY[1], or QUIT[2]?");
             playOrQuit = Keyboard.readString();
             if (playOrQuit.equals("1"))
             {
                 
                }
                else if (playOrQuit.equals("2"))
                {
                    System.out.println("PLAYER QUITS. You just lost $" + bet + ".");
                    break;
                }
             System.out.println("How much bet($)?");
             bet = Keyboard.readInt();
             System.out.println("ODD[1], EVEN[2], or QUIT[3]?");
             oddOrEven = Keyboard.readString();
             if (oddOrEven.equals("3"))
             {
                System.out.println("PLAYER QUITS. You just lost $" + bet + ".");
                break;
             }
             random = (int)(37*Math.random());
          }   
          else if (random%2 != 0 && (oddOrEven.equals(even)))//odd lose
          {
             System.out.println("It is odd.  You just lost $" + bet + ".");
             money = money - bet;
             System.out.println("You have $"+money+". PLAY[1], or QUIT[2]?");
             playOrQuit = Keyboard.readString();
             if (playOrQuit.equals("1"))
             {
                 
                }
                else if (playOrQuit.equals("2"))
                {
                    System.out.println("PLAYER QUITS. You just lost $" + bet + ".");
                    break;
                }
             System.out.println("How much bet($)?");
             bet = Keyboard.readInt();
             System.out.println("ODD[1], EVEN[2], or QUIT[3]?");
             oddOrEven = Keyboard.readString();
             if (oddOrEven.equals("3"))
             {
                System.out.println("PLAYER QUITS. You just lost $" + bet + ".");
                break;
             }
             random = (int)(37*Math.random());
          }
    }
}