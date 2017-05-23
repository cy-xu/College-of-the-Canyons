
public class Fraction
{
    private int numerator;
    private int denominator;
    private int gcf;
    public Fraction(int numer, int denomin)
    {
        numerator = numer;
        denominator = denomin;
    }
    public String toString()
    {
        //System.out.println(numerator+"/"+denominator);
        return numerator+"/"+denominator;
    }
    
    public int getNumerator()
    {
        return numerator;
    }
    public int getDenominator()
    {
        return denominator;
    }
    
    public void simplify()
    {
        int gcf = gcf(numerator,denominator);
        numerator = numerator/gcf;
        denominator = denominator/gcf;
    }
    public static int gcf(int x, int y)
    {
        if (x==y)
        return x;
        if (x > y)
        {
            x=x-y;
            return gcf(x,y);
        }
        else
        {
            y=y-x;
            return gcf(x,y);
        }
    }
    public Fraction multiply(Fraction b)
    {
        Fraction product = new Fraction(numerator,denominator);
        product.denominator = denominator * b.getDenominator();
        product.numerator = numerator * b.getNumerator();
        product.simplify();
        product = new Fraction(product.numerator,product.denominator);
        return product;
        
        
    }
    public Fraction divide(Fraction b)
    {
        Fraction quotient = new Fraction(numerator,denominator);
        quotient.numerator = numerator * b.getDenominator();
        quotient.denominator = denominator * b.getNumerator();
        quotient.simplify();
        quotient = new Fraction(quotient.numerator, quotient.denominator);
        return quotient;
    }
    public Fraction add(Fraction b)
    {
        Fraction sum = new Fraction(numerator,denominator);
        sum.numerator = (numerator * b.getDenominator()) + (b.getNumerator() * denominator);
        sum.denominator = (denominator * b.getDenominator());
        sum.simplify();
        sum = new Fraction(sum.numerator, sum.denominator);
        return sum;
    }
    public Fraction subtract(Fraction b)
    {
        Fraction difference = new Fraction(numerator,denominator);
        difference.numerator = (numerator * b.getDenominator()) - (b.getNumerator() * denominator);
        difference.denominator = denominator * b.getDenominator();
        difference.simplify();
        difference = new Fraction(difference.numerator, difference.denominator);
        return difference;
    }
    public boolean equals(Fraction b)
    {
        simplify();
        b.simplify();
        if (numerator == (b.numerator) && denominator == (b.denominator))
        {
            return true;
        }
        return false;
    }
    
}