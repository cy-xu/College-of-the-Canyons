
public class PalindromeMaker
{
    private String palindrome;
    private String original;
    public PalindromeMaker(String str)
    {
        original = str;
        palindrome = reverse(str);
        
    }
    private String reverse (String str)            
    {
        String backwards = new String (str);
        for (int i = str.length()-1 ; i >= 0 ; i--)
        {
            backwards =backwards + str.charAt(i);
        }
        return backwards;
    }
                         
    public String toString ()
    {
        return palindrome;
    }

    public String originalString ()                 
    {
        return original;
    }

    public int length ()                                               
    {
        return palindrome.length();
    }

    public boolean equals (PalindromeMaker otherPalindrome)
    {

        if (palindrome.equals(otherPalindrome.palindrome))
        {
            return true;
        }
        
        return false;
    }
}