public class Character
{
    private String name;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int minDamage;
    private int maxDamage;
    
    public Character(String nam)
    {
        name = nam;
        health = 100;
        maxHealth = 100;
        mana = 100;
        maxMana = 100;
        minDamage = 12;
        maxDamage = 16;
    }
    public Character()
    {
        name = "CPU";
        health = 120;
        maxHealth = 120;
        mana = 0;
        maxMana = 0;
        minDamage = 15;
        maxDamage = 20;
    }
    public void heal(int n)
    {
        if (n < 0)
        {
            n = 0;
        }
        health = health + n;
        if (health > maxHealth)
        {
            health = maxHealth;
        }
        
    }
    public void heal()
    {
        health = maxHealth;
    }
    public void takeDamage(int n)
    {
        health = health - n;
    }
    public boolean isDead()
    {
        if (health <= 0)
        {
            System.out.println("This nub is dead.");
            return true;
        }
        return false;
    }
    public void attack(Character enemy)
    {
        int dmg = (int)(minDamage + (maxDamage - minDamage+1)*Math.random());
        enemy.health = enemy.health - dmg;
        if (name.equals("CPU"))
        {
            System.out.println("Computer deals "+dmg+" damage");
            System.out.println();
        }
        else
        {
            System.out.println("Player deals "+dmg+" damage");
            System.out.println();
        }
        
    
    }
    public void fireball(Character enemy)
    {
        if (mana >= 43)
        {
            mana = mana -43;
            enemy.health = enemy.health - 30;
            System.out.println("Player deals 30 damage");
            System.out.println();
        }
        else 
        {
            System.out.println("Not enough mana!");
            System.out.println();
        }
    }
    public void healSpell()
    {
        if (mana >= 18)
        {
            mana = mana -18;
            health = health + 30;
            System.out.println("Player's health healed by 30");
            System.out.println();
            if (health > maxHealth)
            {
                health = maxHealth;
                System.out.println("Can't go above max health!");
                System.out.println();
            }
        }

        else
        {
            System.out.println("Not enough mana!");
            System.out.println();
        }
    }
    
    //extra!!!!
    public String toString()
    {
        return name + ": " + health + " hp / " + mana + " mp";
    }
    
    public void mana(int n)
    {
        if (n < 0)
        {
            n = 0;
        }
        mana = mana + n;
        if (mana > maxMana)
        {
            mana = maxMana;
            System.out.println("Can't go above max mana!");
            System.out.println();
        }
        
    }
    public void tito(Character enemy)
    {
        if (mana >= 100)
        {
            mana = mana -100;
            enemy.health = enemy.health - 60;
            System.out.println("Tito says, \"I don't always surf the internet, but when I do eyebrows\"\nPlayer deals 60 damage");
            System.out.println();
        }
        else 
        {
            System.out.println("Not enough mana!");
            System.out.println();
        }
    }
    public void pulok()
    {
        health = health - 50;
        System.out.println("Pulok smashes his head against a wall\nPlayer loses 50 health.");
        System.out.println();
    }
    public void borish(Character enemy)
    {
        enemy.health = 0;
        System.out.println("A wild Borish appears and tells a terrible pun\nBorish deals " + Integer.MAX_VALUE + " damage");
    }
    public void manaPotion()
    {
        mana = mana + 50;
        System.out.println("Player drinks mana potion. +50 mp.");
        if (mana > maxMana)
        {
            mana = maxMana;
            System.out.println("Can't go above max mana!");
        }
        System.out.println();
    }
    public void healthPotion()
    {
        health = health + 50;
        System.out.println("Player drinks health potion. +50 hp");
        if (health > maxHealth)
        {
            health = maxHealth;
            System.out.println("Can't go above max health!");
        }
        System.out.println();
    }
}
