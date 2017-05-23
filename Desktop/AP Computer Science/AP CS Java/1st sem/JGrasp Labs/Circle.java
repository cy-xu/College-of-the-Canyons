public class Circle
{
   public static void main(String[] args)
   {
    
      final double PI = 3.14159;
      int radius = 10;
      double area = PI * radius * radius;
      int diameter = radius*2;//new variable
      double circumference = 2*PI*radius;//new variable
      
      System.out.println("The area of a circle with radius " + radius + " is " + area);
      System.out.println("The area of a circle with diameter " + diameter + " is " + area);
      System.out.println("The circumference of a circle with radius " + radius + " is " + circumference);
      System.out.println(); //add space
      //------------------
      radius = diameter;//radius*2 = diameter
      circumference = 2*PI*radius;
      area = PI * radius * radius;
      System.out.println("The area of a circle with radius " + radius + " is " + area);
      System.out.println("The area of a circle with diameter " + diameter*2 + " is " + area);
      System.out.println("The circumference of a circle with radius " + radius + " is " + circumference);
      
      
   
           
   }
}
