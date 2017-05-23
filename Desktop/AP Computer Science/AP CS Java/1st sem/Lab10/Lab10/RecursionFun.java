

public class RecursionFun
{
    
    public static int count7(int n)
    {
        if (n < 1)
        {
            return 0;
        }
        if (n%10 == 7)
        {
            return 1 + count7(n/10);
        }
        else
        {
            return 0 + count7(n/10);
        }
    }
    public static int powerN(int base, int n)
    {
        if (n==0)
        {
            return 1;
        }
        return base * powerN(base,n-1);
    }

    public static int strCount(String str, String sub)
    {
 
        if (str.length() < sub.length())
        {
            return 0;
        }
        else
        {
            String x = str.substring (0, sub.length());
            if (x.equals (sub))
            {
                return 1 + strCount (str.substring (x.length()), sub);
            }
            else
            {
            return strCount (str.substring(1), sub);
        }
    }
}
        
    public static boolean power2(int x)
    {
        
        System.out.print(x+ " ");
        
        if (x == 1)
        {
            return true;
        }
        if (x%2 == 1)
        {
            return false;
        }
        else if (x < 1)
        {
            return false;//return 2 * power2(x-1);
        }x = (x/2);
        return power2(x);
    }
    public static int fibonacci(int n)
    {
        
        if (n== 1)
        {
            return 1;
        }
        else if ( n== 0)
        {
            return 0;
        }
        return (fibonacci(n-1) + fibonacci(n-2));
    }
    public static int gcf(int x, int y)
    {
        if (x==y)
        return x;
        if (x > y)
        {
            x=x-y;
            return gcf(x,y);
        }
        else
        {
            y=y-x;
            return gcf(x,y);
        }
    }

}