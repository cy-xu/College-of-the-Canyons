
public class Item
{
    public double itemWeight;
    public String itemName;
    public Item(String iName, double iWeight)
    {
        itemName = iName;
        itemWeight = iWeight;
    }
    public double getWeight()
    {
        return itemWeight;
    }
    public String getName()
    {
        return itemName;
    }
    public void changeName(String s){
        itemName = s;
    }
    public String toString()
    {
        return itemName + " - " + itemWeight;
    }
    public boolean equals(Item other)
    {
        if (itemWeight == other.getWeight() && itemName.equals(other.getName()) )
        {
            return true;
        }
        return false;
    }
}
