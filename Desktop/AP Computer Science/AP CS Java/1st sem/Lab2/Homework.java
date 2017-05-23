import java.util.ArrayList;
public class Homework
{
    String description;
    int point;
    static int numAssign;
    static int numPoints;
    static ArrayList<String> homework = new ArrayList<String>();
    static boolean BorishRules;
    public Homework(String desc, int points)
    {
        description = desc;
        point = points;
        homework.add(description);
        numPoints += point;
        numAssign = homework.size();
    }
    public String getDescription()
    {
        return description;
    }
    public int getPoints()
    {
        return point;
    }
    public void changePoints(int n)
    {
        
        if (point > n)
        {
            numPoints -= (point - n);
        }
        else if (point < n)
        {
            numPoints += (n - point);
        }
        point = n;
    }
    public String toString()
    {
        return description + " " + point;
    }
    public static void printAssignments()
    {
        for (int i = 0; i < homework.size() ; i++)
        {
            System.out.print(homework.get(i) + ", ");
        }
        System.out.println();
    }
    public static int numAssignments()
    {
        return numAssign;
    }
    public static int getTotalPoints()
    {
        return numPoints;
    }
    public static ArrayList<String> getArrayList()
    {
        return homework;
    }
}
