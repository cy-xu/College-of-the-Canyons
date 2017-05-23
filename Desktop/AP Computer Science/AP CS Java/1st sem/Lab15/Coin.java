
public class Coin
{
    private String face;
    private double bias;
    
    public Coin()
    {
        face = "Heads";
        bias = 0.5;
    }
    public Coin(double inputBias)
    {
        face = "Heads";
        bias = inputBias;
    }
    public boolean isHeads()
    {
        if (face.equals("Heads"))
        {
            return true;
        }
        return false;
    }
    public boolean isTails()
    {
        if (face.equals("Tails"))
        {
            return true;
        }
        return false;
    }
    public void flip()
    {
        double random = Math.random();
        if (random <= bias)
        {
            face = "Heads";
        }
        else
        {
            face = "Tails";
        }
        System.out.println(face);
    }
    public int flip(int n)
    {
        int count = 0;
        for (int i = 0; i < n ; i++)
        {
            double random = Math.random();
            if (random <= bias)
            {
                face = "Heads";
                count++;
            }
            else
            {
                face = "Tails";
            }
            
        }
        return count;
    }
    public String toString()
    {
        return face;
    }
    public boolean equals(Coin b)
    {
        if (face.equals(b.face) && bias == b.bias)
        {
            return true;
        }
        return false;
    }
}
