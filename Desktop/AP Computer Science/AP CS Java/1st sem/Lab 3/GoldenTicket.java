
public class GoldenTicket implements Priority
{
    private String personName;
    private int priority;
    public GoldenTicket(String name, int initialSpotInLine)
    {
        personName = name;
        priority = initialSpotInLine;
    }
    public int getPriority()
    {
        return priority;
    }
    
    public void setPriority(int a)
    {
        System.out.println("no");
    }
    public void nextUp()
    {
        priority--;
        if (priority <= 1)
        {
            System.out.println("yay - 1 or less priority");
        }
    }
}
