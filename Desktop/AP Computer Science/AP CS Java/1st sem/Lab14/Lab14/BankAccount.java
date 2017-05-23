import cs1.Keyboard;
public class BankAccount
{
    private String person;
    private double rate;
    private double balance;
    public BankAccount()
    {
        System.out.println("Please type in your name:");
        String name = Keyboard.readString();
        person = name;
        
        System.out.println("Initial Deposit:");
        double deposit = Keyboard.readDouble();
        balance = deposit;
        
        rate = 0.05;
    }
    public void deposit(double x)
    {
        if (x < 0)
        {
            System.out.println("ERROR");
        }
        else
        {
            balance = balance + x;
        }
    }
    public void withdraw(double x)
    {
        if (x < 0 || x > balance)
        {
            System.out.println("ERROR");
        }
        else
        {
            balance = balance - x;
        }
    }
    public void addInterest()
    {
        balance = balance + (balance*rate);
    }
    public void addMultipleInterest(int n)
    {
        for (n = n ; n > 0 ; n--)
        {
            balance = balance + (balance*rate);
        }
    }
    public double getBalance()
    {
        return balance;
    }
    public double accountStatement()
    {
        balance = balance - 1;
        System.out.println("Balance: $" + balance + "\nOwner: " + person);
        return balance;
    }
    public double overdraw()
    {
        if ( balance < 0)
        {
            balance = balance - 10;
            return balance;
        }
        return balance;
    }
    public String toString()

    {
        return "[ " + person + ", " + balance + "]";
    }

            
}
