
public class PalindromeMakerDriver
{
    public static void main(String[] args)
    {
        
        PalindromeMaker x = new PalindromeMaker("car");
        PalindromeMaker y = new PalindromeMaker("cr");
        //System.out.println(x.toString());
        //System.out.println(x.originalString());
        //System.out.println(x.length());
        
        
        System.out.println(x.equals(y));
        
        //System.out.println(x.reverse());
    }
}
