
public class Person implements Comparable<Person>
{
    private String name;
    private int age;
    public Person (String iname,  int iage)
    {
    this.name = iname;
    this.age = iage;
    }
    public void changeName(String newName)
    {
    name = newName;
    }
    public void changeAge (int newAge)
    {
    age = newAge;
    }
    public String toString()
    {
    return name + " - Age " + age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public int compareTo(Person b)
    {
        if (name.compareTo(b.getName()) < 0)
        {
            return -1;
        }
        else if (name.compareTo(b.getName()) > 0)
        {
            return 1;
        }
        else if (name.compareTo(b.getName()) == 0)
        {
            if (age < b.getAge())
            {
                return -2;
            }
            else if (age > b.getAge())
            {
                return 2;
            }
            else
                return 0;
        }
        return 69;
    }
}
