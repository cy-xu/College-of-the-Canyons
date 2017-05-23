import java.util.ArrayList;
public class Diary implements Lockable
{
    private ArrayList<JournalEntry> list;
    private boolean locked;
    public Diary()
    {
        list = new ArrayList<JournalEntry>();
        locked = true;
    }
    public void unlock(int a )
    {
        if (a == password)
        {
            locked = false;
        }
        else
        System.out.println("a mean message");
    }
    public void lock(int a)
    {
        if (a == password)
        {
            locked = true;
        }
        else System.out.println("a mean message");
    }
    
    public boolean isLocked()
    {
        return locked;
    }
    
    public void addTask(JournalEntry newone)
    {
        if (locked == false)
        {
            
            list.add(newone);
        }
        else 
        System.out.print("a mean message and do nothing");
    }
    public int numEntries()
    {
        if (locked == false)
        {
            return list.size();
        }
        else
        return -1;
    }
    public int numWords()
    {
        int count = 0;
        if (locked == false)
        {
            for (int i = 0 ; i < list.size() ; i++)
            {
                count += list.get(i).wordCount();
            }
            return count;
        }
        else 
        return -1;
    }
    public JournalEntry getHighest()
    {
        int smallestPriority = Integer.MAX_VALUE;
        JournalEntry highest = new JournalEntry("",Integer.MAX_VALUE);
        if (locked == false)
        {
            for (int i = 0; i < list.size() ; i++)
            {
                if (smallestPriority > list.get(i).getPriority())
                {
                    highest = list.get(i);
                    smallestPriority = list.get(i).getPriority();
                }
            }
            return highest;
        }
        else return null;
    }
    public void removeTasks(int n)
    {
        int newPriority = 0;
        if (locked == true)
        {
            System.out.println("a mean message then does nothing");
        }
        else 
        {
            for (int i = 0 ; i < list.size(); i++)
            {
                if (list.get(i).getPriority() <= n)
                {
                    list.remove(i);
                    i--;
                }
            }
            for (int j = 0 ; j < list.size(); j++)
            {
                newPriority = list.get(j).getPriority() - n;
                list.get(j).setPriority(newPriority);
            }
        }
    }
    public void printAll()
    {
        if (locked == true)
        {
            System.out.println("a mean message");
        }
        System.out.println(list); 
    }
}
