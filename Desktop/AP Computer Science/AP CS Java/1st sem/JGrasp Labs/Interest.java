import cs1.Keyboard;

public class Interest
{
   public static void main(String[] args)
   {
      System.out.println("Welcome to the interest money calculator");
      double initialMoney;
      double interestRate;
      double time;
      System.out.println("Initial amount of money ($): ");
      initialMoney = Keyboard.readDouble();
      System.out.println("Interest rate (%): ");
      interestRate = Keyboard.readDouble();
      System.out.println("Time in bank (years): ");
      time = Keyboard.readDouble();
      double percent = interestRate*.01;// converts % into decimals
      double convert = initialMoney*(Math.pow(1+percent,time));
      System.out.println("After "+time+" years, you will have $"+convert);
      
      
      
      
   
   
   
   
   
   
   
   }


}