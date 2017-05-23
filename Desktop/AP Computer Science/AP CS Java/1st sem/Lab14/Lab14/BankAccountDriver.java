import cs1.Keyboard;
public class BankAccountDriver
{
    public static void main(String[] args)
    {
        BankAccount sweg = new BankAccount();
        
        sweg.deposit(100.0);
        System.out.println(sweg.getBalance());
        sweg.deposit(-100.0);
        System.out.println(sweg.getBalance());
        
        System.out.println();
        
        sweg.withdraw(100.0);
        System.out.println(sweg.getBalance());
        sweg.withdraw(-100.0);
        System.out.println(sweg.getBalance());
        sweg.withdraw(1000000000);
        System.out.println(sweg.getBalance());
        
        System.out.println();
        
        sweg.addInterest();
        System.out.println(sweg.getBalance());
        
        System.out.println();
        
        sweg.addMultipleInterest(2);
        System.out.println(sweg.getBalance());
        /*
        System.out.println(sweg.getBalance());
        System.out.println(sweg.accountStatement());
        System.out.println(sweg.overdraw());
        System.out.println(sweg.toString());
        */
    }
    
    
}
