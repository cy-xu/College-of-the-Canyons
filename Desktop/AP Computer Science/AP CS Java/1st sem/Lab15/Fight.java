import cs1.Keyboard;
public class Fight
{
    public static void main(String[] args)
    {
        Character player = new Character ("player");
        Character computer = new Character ();
        int firstTurn = (int)(2*Math.random());
        int x = 69;
        int manaPotion = 1;
        int healthPotion = 1;
        System.out.println("Welcome to the Fight program.\nYour goal is to defeat your opponent using different abilities.\nYou have 3 main moves: attack [1], healSpell [2], and fireball [3]");
        System.out.println("You have 3 special moves: tito [4], pulok [5], and borish [6]");
        System.out.println("You have 1x mana potion [7] and 1x health potion [8]");
        System.out.println("If you wish to exit, press 9\n");
        if (firstTurn == 0)
        {
            System.out.println("PLAYER MOVES FIRST");
            done: while (x == 69)
            {
                //print data
                System.out.println("--------------------\n"+player.toString());
                System.out.println(computer.toString()+"\n--------------------");
                System.out.println();
                
                //player move
                while (true)
                {
                    System.out.println("Please enter 1-9\nattack[1] healSpell[2] fireball[3] tito[4] pulok[5] borish[6]\nmanaPotion[7] healthPotion[8] exit[9]");
                    String move = Keyboard.readString();
                    System.out.println();
                    if (move.equals("1"))
                    {
                        player.attack(computer);
                        break;
                    }
                    if (move.equals("2"))
                    {
                        player.healSpell();
                        break;
                    }
                    if (move.equals("3"))
                    {
                        player.fireball(computer);
                        break;
                    }
                    if (move.equals("4"))
                    {
                        player.tito(computer);
                        break;
                    }
                    if (move.equals("5"))
                    {
                        player.pulok();
                        break;
                    }
                    if (move.equals("6"))
                    {
                        player.borish(computer);
                        break;
                    }
                    if (move.equals("7"))
                    {
                        if (manaPotion == 1)
                        {
                            manaPotion--;
                            player.manaPotion();
                            break;
                        }
                        else
                        {
                            System.out.println("No mana potions left.");
                        }
                    }
                    if (move.equals("8"))
                    {
                        if (healthPotion == 1)
                        {
                            healthPotion--;
                            player.healthPotion();
                            break;
                        }
                        else
                        {
                            System.out.println("No health potions left");
                        }
                    }
                    if (move.equals("9"))
                    {
                        System.out.println("GAME OVER");
                        break done;
                    }
                }
            
                //check dead
                if (player.isDead())
                {
                    System.out.println("Computer is the winner!");
                    break;
                }
                if (computer.isDead())
                {
                    System.out.println("Player is the winner!");
                    break;
                }

                //print data
                System.out.println(player.toString());
                System.out.println(computer.toString());
                System.out.println();
                
                //computer move
                computer.attack(player);
                
                //check dead
                if (player.isDead())
                {
                    System.out.println("Computer is the winner!");
                    break;
                }
                if (computer.isDead())
                {
                    System.out.println("Player is the winner!");
                    break;
                }
                
                //increase health/mana
                player.heal(2);
                player.mana(2);
                computer.heal(2);
                System.out.println("Both players' health/mana increased by 2!");
                System.out.println();
                
            }
        
            
        }
        else
        {
            System.out.println("COMPUTER MOVES FIRST");
            done: while (x == 69)
            {
                //print data
                System.out.println(player.toString());
                System.out.println(computer.toString());
                System.out.println();
                
                //computer move
                computer.attack(player);
                
                //check dead
                if (player.isDead())
                {
                    System.out.println("Computer is the winner!");
                    break;
                }
                if (computer.isDead())
                {
                    System.out.println("Player is the winner!");
                    break;
                }
                
                //print data
                System.out.println(player.toString());
                System.out.println(computer.toString());
                System.out.println();
                
                //player move
                while (true)
                {
                    System.out.println("Please enter 1-9\nattack[1] healSpell[2] fireball[3] tito[4] pulok[5] borish[6]\nmanaPotion[7] healthPotion[8] exit[9]");
                    String move = Keyboard.readString();
                    System.out.println();
                    if (move.equals("1"))
                    {
                        player.attack(computer);
                        break;
                    }
                    if (move.equals("2"))
                    {
                        player.healSpell();
                        break;
                    }
                    if (move.equals("3"))
                    {
                        player.fireball(computer);
                        break;
                    }
                    if (move.equals("4"))
                    {
                        player.tito(computer);
                        break;
                    }
                    if (move.equals("5"))
                    {
                        player.pulok();
                        break;
                    }
                    if (move.equals("6"))
                    {
                        player.borish(computer);
                        break;
                    }
                    if (move.equals("7"))
                    {
                        if (manaPotion == 1)
                        {
                            manaPotion--;
                            player.manaPotion();
                            break;
                        }
                        else
                        {
                            System.out.println("No mana potions left.");
                        }
                    }
                    if (move.equals("8"))
                    {
                        if (healthPotion == 1)
                        {
                            healthPotion--;
                            player.healthPotion();
                            break;
                        }
                        else
                        {
                            System.out.println("No health potions left");
                        }
                    }
                    if (move.equals("9"))
                    {
                        System.out.println("GAME OVER");
                        break done;
                    }
                }
               
                //check dead
                if (player.isDead())
                {
                    System.out.println("Computer is the winner!");
                    break;
                }
                if (computer.isDead())
                {
                    System.out.println("Player is the winner!");
                    break;
                }
                
                //increase health/mana
                player.heal(2);
                player.mana(2);
                computer.heal(2);
                System.out.println("Both players' health/mana increased by 2!");
                System.out.println();
                
            }
        }
    }
}
