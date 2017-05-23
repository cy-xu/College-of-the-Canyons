
public class StringArray
{
    public static boolean allEqual(String[] x, String[] y)
    {
        if (x.length != y.length)
        {
            return false;
        }
        for (int i = 0; i < x.length; i++)
        {
            if (x[i] == y[i])
            {
                return true;
            }
        }
        return false;
    }
    public static String[] capsLock(String[] x)
    {
        for (int i = 0; i < x.length; i++)
        {
            x[i] = x[i].toUpperCase();
        }
        return x;
    }
    public static String[] reverse(String[] x)
    {
        int length = x.length;
        for (int i = 0; i < length; i++)
        {
            length--;
            String sub = x[i];
            x[i] = x[length];
            x[length] = sub;
        }
        return x;
    }
    public static void searchString(String[] x, String y)
    {
        int count = 0;
        for (int i = 0; i < x.length; i++)
        {
            if (x[i].indexOf(y) != -1)
            {
                System.out.println(x[i]);
            }
        }
    }
    public static int countLetter(String[] x, char y)
    {
        int count = 0;
        int index = 0;
        for (int i = 0; i < x.length; i++)
        {
            count++;
            String sub = x[i];
            x[i] = x[i];
            /*if (x == y)
            {
                count++;
            }*/
        }
        return count;
    }
}
