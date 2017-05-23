import java.util.ArrayList;
public class ItemDriver
{
    public static int countWeapons(Item[] x)
    {
        for (int i = 0; i < x.length ; i++)
        {
           // if (x[i] 
        }
        return 1;
    }
    public static double totalWeight(Item[] x)
    {
        double total = 0;
        for (int i = 0; i < x.length ; i++)
        {
            total = total + x[i].getWeight();
        }
        return total;
    }
    public static int attack(Weapon a,Armor b)
    {
        return b.getAttacked(a.attackDamage());
    }
    public static int countPotions(ArrayList<Item> x)
    {
        int count = 0;
        for (Item s : x)
        {
            if (s.getName().equals("potion"))
            {
                count++;
            }
        }
        return count;
    }
}
