
public class StringManipulate
{

      
    public static void main(String[] args)
    {
        System.out.println("HI!");
    }
          


    public static String concat(String x, String y)
    {
        String concat = x+y;
        return concat;
    }



    public static String printX(String x, int y)
    {
        String printX = x;
        for (y = y; y >=1; y--)
        {
            System.out.println(printX);
        }
        return printX;
    }



    public static String makePlural(String x)
    {
        String makePlural = x;
        char s = 's';
        char y = 'y';
        int length = x.length()-1;
        if (x.charAt(length) == (s))
        {
            return (x+"es");
        }
        else if (x.charAt(length)==(y))
        {
            return (x.substring(0,x.length()-1)+"ies");
          
        }
        else 
        {
            return (x + "s");
  
        }

    }
 


    public static String reverse(String x)
    {

        if (x.length() <= 1)
        {
            return x;
        }

        return x.charAt(x.length()-1) + reverse(x.substring(0,x.length()-1));
    }
 


public static int countLetter(String x, char y)
{
    int countLetter = 0;
    int countSpaces = 0;
    for (int i = x.length()-1; i >= 0; i--)
    {
        if ((x.charAt(i))==(y))
        {
            countLetter++;
            countSpaces++;
        }
    }
    
    return countLetter;
}
 

public static int countSpaces(String x)
{
    
    
    char y = ' ';
    
    int countSpaces = StringManipulate.countLetter(x,y);
    
    return countSpaces;
}
 

public static boolean firstLetterEqual(String x, String y)
{
    boolean firstLetterEqual = true;
    if (x.charAt(0) != y.charAt(0))
    {
        firstLetterEqual = false;
    }
    return firstLetterEqual;
}
 


public static boolean caseEquals(String x, String y)
{
    x = x.toLowerCase();
    y = y.toLowerCase();
    boolean caseEquals = false;
    if (x.equals(y))
    {
        caseEquals = true;
    }
    return caseEquals;
}
 
}