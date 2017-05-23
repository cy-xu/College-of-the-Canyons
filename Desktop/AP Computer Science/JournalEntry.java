
public class JournalEntry implements Comparable<JournalEntry>, Priority
{
    private String entry;
    private int priority;
    private static int total;
    public JournalEntry(String entryInput, int priorityInput)
    {
        if (priorityInput <= 0)
        {
            throw new NullPointerException("no");
        }
        entry = entryInput;
        priority = priorityInput;
        total ++;
    }
    public void JournalEntry(String entryInput)
    {
        priority = 1;
    }
    public String getEntry()
    {
        return entry;
    }
    public void setEntry(String x)
    {
        entry = x;
    }
    public int wordCount()
    {
        int count = 0;
        for (int i = 0; i < entry.length(); i++)
        {
            if (entry.charAt(i) == (' ') || i == entry.length() - 1)
            {
                count++;
            }
        }
        return count;
        
    }
    public static int getTotalCount()
    {
        return total;
    }
    public String toString()
    {
        return entry + "-" + priority;
    }
    public int compareTo(JournalEntry b)
    {
        if (priority == b.priority)
        {
            return 0;
        }
        int total = priority - b.priority;
        return total;
    }
    public int getPriority()
    {
        return priority;
    }
    
    public void setPriority(int a)
    {
        priority = a;
    }
}
