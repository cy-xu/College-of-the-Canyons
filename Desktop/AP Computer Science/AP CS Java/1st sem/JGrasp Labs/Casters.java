import cs1.Keyboard;

public class Casters
{
   public static void main(String[] args)
   {
      double a;
      double b;
      System.out.println("First Number:");
      a = Keyboard.readDouble();
      System.out.println("Second Number");
      b = Keyboard.readDouble();
      double c = a*b;
      c = (int) c;
      System.out.println("a*b printed as an int = " + c);
      double d = c/5;
      System.out.println("c/5 printed as a double = " + d);
      
      
   
   
   }



}