
public class Car extends Vehicle
{
    public Car(int x, String y, String z)
    {
        super.year = x;
        super.make = y;
        super.model = z;
    }
    public boolean canGo()
    {
        return true;
    }
    
    public boolean canTurn()
    {
        return true;
    }
    public boolean canGoFast()
    {
        if (year >= 2000 || make.equals("Ferrari"))
        {
            return true;
        }
        return false;
    }
}
