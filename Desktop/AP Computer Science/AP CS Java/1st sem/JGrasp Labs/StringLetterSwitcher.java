import cs1.Keyboard;
public class StringLetterSwitcher
{
   public static void main(String[] args)
   {
      System.out.println("Please input a sentence:");//places main string
      String name = new String();
      name = Keyboard.readString();
      
      System.out.println("First letter:");//first letter to be swapped
      String first = new String();
      first = Keyboard.readString();
      System.out.println("Second letter:");//second letter to be swapped
      String second = new String();
      second = Keyboard.readString();
      
      String substitute = new String();//replaces second letter with a substitute variable
      substitute = name.replace(second,"1");
      
      String swap = substitute.replace(first,second);//replaces first letter with the second letter
      
      String done = swap.replace("1",first);//replaces the substitute variable with the first letter
      
      System.out.println(done);
/*
5. Write a program (StringLetterSwitcher.java) that will input 
a sentence, and then two letters, and then switch all instances 
of those letters. It will then print out the switched sentence. 
For instance, they could input “I like to eat bananas” and then 
“e” and “a,” and your program would print “I lika to aet benenes". 
Assume that the user will enter a string without any numbers. 
When you are done, submit StringLetterSwitcher.java
 
Hint: this one is hard too
Hint: just because the user is not going to use numbers, 
doesn’t mean that you don’t have to in order to help you 
switch the letters.

*/
   }
}