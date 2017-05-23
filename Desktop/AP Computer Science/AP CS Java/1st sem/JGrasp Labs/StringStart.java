import cs1.Keyboard;
public class StringStart
{
   public static void main(String[] args)
   {
		System.out.println("Name of main string:");
		String name = new String();
		name = Keyboard.readString();//user inputs a string   
      
      System.out.println("Name of string part from main string:");
      String part = new String();
      part = Keyboard.readString();//user inputs string that is also contained in first string
      name = name.substring(name.indexOf(part));//reaches part where the second string is from
      System.out.println(name);

   }
}