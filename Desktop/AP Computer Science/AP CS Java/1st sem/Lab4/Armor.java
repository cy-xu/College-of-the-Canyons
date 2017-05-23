
public class Armor extends Item implements Comparable<Armor>
{
    public int armorClass;
    public double durability;
    public Armor(String nam, double weigh, int aClass)
    {
        super(nam,weigh);
        armorClass = aClass;
        durability = armorClass*super.getWeight();
    }
    public int getArmorClass()
    {
        return armorClass;
    }
    public double getDurability()
    {
        return durability;
    }
    public boolean isBroken()
    {
        if (durability <= 0)
        {
            armorClass = 0;
            return true;
        }
        return false;
    }
    public int getAttacked(int x)
    {
        int total = x - armorClass;
        if (total < 0)
        {
            total = 0;
        }
        durability = durability - total;
        isBroken();
        return total;
    }
    public String toString()
    {
        return super.toString() + "(" + armorClass + ")"; 
    }
    public boolean equals(Armor b)
    {
        if (super.equals(b) && armorClass == b.getArmorClass() ) 
        {
            return true;
        }
        return false;
    }
    public int compareTo(Armor other)
    {
        return armorClass - other.getArmorClass();
        
    }
    
    
}
