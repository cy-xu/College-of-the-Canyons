
public class Convertible extends Car
{
    private boolean topDown;
    public Convertible(int x, String y, String z)
    {
        super(x,y,z);
        topDown = false;
    }
    public boolean canGoFast()
    {
        return true;
    }
    public boolean topDown()
    {
        return topDown;
    }
    public void raiseTop()
    {
        topDown = false;
    }
    public void lowerTop()
    {
        topDown = true;
    }
}
