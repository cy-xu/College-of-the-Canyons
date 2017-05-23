
public class Weapon extends Item
{
    public int minDamage;
    public int maxDamage;
    public Weapon(String nam, double weigh, int minDmg, int maxDmg)
    {
        super(nam,weigh);
        minDamage = minDmg;
        maxDamage = maxDmg;
    }
    public int getMinDamage()
    {
        return minDamage;
    }
    public int getMaxDamage()
    {
        return maxDamage;
    }
    public int attackDamage()
    {
        return (int)(minDamage + ((maxDamage-minDamage)+1) * Math.random());
    }
    public String toString()
    {
       return super.toString() + "(" + minDamage + " - " + maxDamage+ ")"; 
    }
    public boolean equals(Weapon b)
    {
        if (super.equals(b) && minDamage == b.getMinDamage() && maxDamage == b.getMaxDamage()) 
        {
            return true;
        }
        return false;
    }
}
