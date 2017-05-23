import java.util.ArrayList;
public class DeckDriver
{
    public static void main(String[] args)
    {
        Deck sweg = new Deck();
        System.out.println(sweg);
        sweg.shuffle();
        System.out.println(sweg);
        
        Hand yup = new Hand();
        
        //yup.draw();
        //System.out.println(yup);
        //System.out.println(sweg);
    }
}
