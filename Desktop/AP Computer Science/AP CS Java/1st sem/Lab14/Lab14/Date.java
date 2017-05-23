public class Date
{
    private int month;
    private int day;
    private int year;
    public Date(int monthx, int dayx, int yearx)
    {
        month = monthx;
        day = dayx;
        year = yearx;
    }
    public int getDay()
    {
        return day;
    }
    public int getMonth()
    {
        return month;
    }
    public int getYear()
    {
        return year;
    }
    public int nextYear()
    {
        year++;
        return year;
    }
    public int nextDay()
    {
        day++;
        if (month == 4 || month == 6 || month == 9 || month == 11)
        {
            if (day == 31)
            {
                month++;
                day = 1;
                return day;
            }
        }
        if (month == 2)
        {
            if (day == 29)
            {
                month++;
                day = 1;
                return day;
            }
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            if (day == 32)
            {
                month ++;
                day = 1;
                return day;
            }
        }
        return day;
    }
    public int nextDays(int n)
    {
        for (n=n; n > 0; n--)
        {
            nextDay();
        }
        return day;
    }
    public boolean equals(Date other)
    {
        if (month==(other.month) && day==(other.day) && year==(other.year))
        {
            return true;
        }
        return false;
    }
    public String toString()
    {
        String americanDate = new String(month+"/"+day+"/"+year);
        return americanDate;
    }
}
