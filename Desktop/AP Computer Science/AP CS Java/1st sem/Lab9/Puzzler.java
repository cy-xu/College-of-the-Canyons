
public class Puzzler
{
    public static String firstHalf(String x)
    {
        String firstHalf = x;

        if ((x.length())%2 != 0)
        {
            firstHalf = firstHalf.substring(0,((x.length()/2) + 1));
        }
        else 
        {
            firstHalf = firstHalf.substring(0,(x.length()/2));
        }
        return firstHalf;
    }
    public static boolean firstTwo(String x, String y)
    {
        boolean firstTwo = false;

        if (x.length() < 2 || y.length() < 2)
        {
            firstTwo = false;
            return firstTwo;
        }
        if ((x.substring(0,2)).equals(y.substring(0,2)))
        {
            firstTwo = true;
        }



        return firstTwo;
    }
    public static int caughtSpeeding(int x, boolean y)
    {
        if (x >= 61 && x <= 80)
        {
            if (y == true)
            {
                return 0;
            }
            else
            {
                return 300;
            }
        }
        else if (x > 80)
        {
            if (y == true)
            {
                return 300;
            }
            return 1000;
        }
        else
        {
            return 0;
        }
    }
    public static int countAlike(String x, String y)
    {
        int count = 0;
        if (x.length() <= y.length())
        {
        for (int i = 0; i < x.length(); i++)
        {
            if (x.charAt(i) == y.charAt(i))
            {
                count++;
            }
        }
    }
    
        else 
        {
                for (int i = 0; i < y.length(); i++)
        {
            if (y.charAt(i) == x.charAt(i))
            {
                count++;
            }
        }
    }
    
        return count;
    }
}
