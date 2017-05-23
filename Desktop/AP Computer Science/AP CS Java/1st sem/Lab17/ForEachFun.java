import java.util.ArrayList;
public class ForEachFun
{
    public static void main(String[] args)
    {

       ArrayList<String> words = new ArrayList<String>();
       words.add("patato");
       words.add("potatttto");
       words.add("potito");
       words.add("Anna bidolli!");
    }
    public static int positives(int[] numbers)
    {
        int count = 0;
        for (int i = 0; i < numbers.length ; i++)
        {
            if (numbers[i] > 0)
            {
                count++;
            }
        }
        return count;
    }
    public static int sumAll(int[] x)
    {
        int sum = 0;
        for (int i = 0; i < x.length ; i++)
        {
            sum = sum + x[i];
        }
        return sum;
    }
    public static int sumAll(ArrayList<Integer> x)
    {
        int sum = 0;
        for (int i = 0 ; i<x.size(); i++)
        {
            sum = sum + x.get(i);
        }
        return sum;
    }
    public static ArrayList<String> removeSub(ArrayList<String> x, String y)
    {
        for (int i = 0; i < x.size() ; i++)
        {
            if ((x.get(i)).equals(y))
            {
                x.remove(i);
                i--;
            }
        }
        return x;
    }
}