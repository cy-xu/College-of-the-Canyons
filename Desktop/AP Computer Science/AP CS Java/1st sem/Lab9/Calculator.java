
public class Calculator
{

    public static void main(String[] args)
    {
        System.out.println(sum(3,6));
    }

    public static double sum(double a, double b)
    {
        double sum = (double)(a+b);
        return sum;
    }

    public static double quotientDouble(int a, int b)
    {
        double quotientDouble = (double)(a)/(double)(b);
        return quotientDouble;
    }

    public static int cube(int a)
    {
        int cube = (int)(Math.pow(a,3));
        return cube;
    }

    public static double distance(double x1, double y1, double x2, double y2)
    {
        double distance = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
        return distance;
    }   

    public static double nRoot(double x, int n)
    {
        double nRoot = (double)(Math.pow((double)x,(double)1/n));
        return nRoot;
    }

    public static double abs(double x)
    {
        double abs = (double)(Math.abs(x));
        return abs;
    }

    public static double absDifference(double a, double b)
    {

        return abs(a-b);
        

    }

    public static int factorial(int x)
    {
        int factorial = x;
        for (int i = 1; i < x; i++)
        {
            factorial *= i;
        }
        return factorial;
    }

    public static void isAwesome(int x)
    {
        
        for (x = x; x > 0; x--)
        {
            System.out.println("computer science is awesome!");
        }
        if (x < 0)
        {
            System.out.println("DUMMY DAT IS NEGATIVE");
        }
    }

    public static int max(int a, int b)
    {
        int max = 0;
        if (a > b)
        {
            max = a;
        }
        else if (b > a)
        {
            max = b;
        }
        else if (b==a)
        {
            System.out.println(a+ " and " + b + " are the same!");
        }
        return max;
    }

    public static int min(int a, int b)
    {
        int min = 0;
        if (a > b)
        {
            min = b;    
        }
        else if (a < b)
        {
            min = a;
        }
        else if (b==a)
        {
            System.out.println(a+ " and " + b + " are the same!");
        }
        return min;
    }   

    public static double average(double a, double b)
    {
        double average = ((double)(a) + (double)(b))/2;
        return average;
    }

    public static String oddOrEven(int a)
    {
        String oddOrEven = ("Please input positive number <3");
        int i = a%2;
        if (i == 0)
        {
            oddOrEven = new String ("even");
        }
        else if (i == 1)
        {
            oddOrEven = new String ("odd");
        }
        return oddOrEven;
    }   

    public static boolean isMult10(int a)
    {
        
        
        boolean isMult10 = true;
        if (a%10 == 0)
        {
            isMult10 = true;

        }
        else
        {
            isMult10 = false;
        }
        
        return isMult10;
    }
}
 

 