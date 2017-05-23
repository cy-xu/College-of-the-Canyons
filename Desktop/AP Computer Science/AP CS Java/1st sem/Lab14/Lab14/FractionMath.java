
public class FractionMath
{
    public static void main(String[] args)
    {
        Fraction a = new Fraction(5,4);
        Fraction b = new Fraction(4,4);
        Fraction c = new Fraction(-5,10);
        //System.out.println(maxDenom(a,b,c));
        //System.out.println(fadd(a,b));
        //System.out.println(fsubtract(a,b));
        //System.out.println(fmultiply(a,b));
        //System.out.println(fdivide(a,b));
        //System.out.println(fequal(a,b));
    }
    public static Fraction fadd(Fraction a, Fraction b)
    {
        return a.add(b);
       
    }
    public static Fraction fsubtract (Fraction a, Fraction b)
    {
        return a.subtract(b);
    }
    public static Fraction fmultiply(Fraction a, Fraction b)
    {
        return a.multiply(b);
    }
    public static Fraction fdivide(Fraction a, Fraction b)
    {
        return a.divide(b);
    }
    public static boolean fequal(Fraction a, Fraction b)
    {
        return a.equals(b);
    }
    public static Fraction maxDenom(Fraction[] fracs)
    {
        fracs.simplify();
        Fraction largest = fracs[0];
        for (int i = 0; i < fracs.length ; i++)
        {
            if (Math.abs(fracs[i].getDenominator()) >= Integer.MIN_VALUE);
            {
                largest = fracs[i];
            }
            
        }
        return largest;
    }
}