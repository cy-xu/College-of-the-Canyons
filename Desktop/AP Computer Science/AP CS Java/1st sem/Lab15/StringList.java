import java.util.ArrayList;
public class StringList
{
    public static void main(String[] args)
    {
        ArrayList<String> x = new ArrayList<String>();
        x.add("billy");
        x.add("jimmy");
        x.add("kelly");
        System.out.println(addOrder(x, "xena"));
        
    }
    public static int length(ArrayList<String> words)
    {
        return words.size();
    }
    public static int totalLength(ArrayList<String> x)
    {
        int count = 0;
        for (int i = 0; i < x.size(); i++)
        {
            count = count + (x.get(i)).length();
        }
        return count;
    }
    public static ArrayList add(ArrayList<String> words, String newWord)
    {
        words.add(newWord);
        return words;
    }
    public static int indexOf(ArrayList<String> x, String y)
    {
        for (int i = 0; i < x.size() ; i++)
        {
            if (x.get(i).equals(y))
            {
                return i;
            }
        }
        return -1;
    }
    public static int count(ArrayList<String> x, String y)
    {
        int count = 0;
        for (int i = 0; i < x.size() ; i++)
        {
            if (x.get(i).equals(y))
            {
                count++;
            }
        }
        return count;
    }
    public static ArrayList addOrder(ArrayList<String> words, String newWord)
    {
        for (int i = 0; i < words.size() ; i++)
        {
            if (newWord.compareTo(words.get(i)) < 0)
            {
                words.add(i, newWord);
                break;
            }
            else
            {
                words.add(words.size(), newWord);
                break;
            }
        }
        return words;
    }
    
}
