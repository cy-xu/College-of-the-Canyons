import java.util.ArrayList;
public class Exceptional
{
    public static Homework worthMost(Homework[] projects)
    {
        double biggest = Integer.MIN_VALUE;
        Homework biggestHW = new Homework("didnt work",Integer.MIN_VALUE);
        for (int i = 0; i < projects.length ; i++)
        {
            if (projects[i].getPoints() > biggest)
            {
                biggest = projects[i].getPoints();
                biggestHW = projects[i];
            }
        }
        System.out.println((biggest/((double)(Homework.getTotalPoints())))*100+"% of your overall grade");
        return biggestHW;
    }
    public static ArrayList<Homework> removeNines(ArrayList<Homework> assignments)
    {
        ArrayList<Homework> ninePoints = new ArrayList<Homework>();
        for (int i = 0 ; i < assignments.size(); i++)
        {
            if (assignments.get(i).getPoints()%10 != 9)
            {
                ninePoints.add(assignments.get(i));
            }
        }
        return ninePoints;
    }
    public static int intPower(int x, int y)
    {
        if (y < 0)
        {
            throw new ArithmeticException("no");
        }
        return (int)Math.pow(x,y);
    }
    public static String capFirst(String input)
    {
        if (input == null)
        {
            throw new NullPointerException("no");
        }
        String word = input.substring(1,input.length());
        String firstLetter = input.substring(0,0).toUpperCase();
        return firstLetter + word;
    }
    public static String[] remove(String[] words, int x)
    {
        int count = 0;
        if (x < 0 || x > words.length)
        {
            throw new ArrayIndexOutOfBoundsException("no");
        }
        String[] sub = new String[words.length-1];
        for (int i = 0; i < words.length ; i++)
        {
            if (i == x)
            {
                count++;
            }
            else
            {
                sub[i-count] = words[i];
            }
        }
        return sub;
    }
}
