

public class CoinDriver
{
    public static void main(String[] args)
    {
        Coin x = new Coin();
        System.out.println(x.isHeads());
        System.out.println(x.isTails());
        x.flip();
        System.out.println(x.flip(200));
        System.out.println();
        Coin y = new Coin(.75);
        System.out.println(y.isHeads());
        System.out.println(y.isTails());
        y.flip();
        System.out.println(y.flip(200));
        System.out.println();
    }
}
