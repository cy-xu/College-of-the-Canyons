import java.util.ArrayList;
public class ExceptionalDriver
{
    public static void main(String[] args)
    {
        Homework x = new Homework("1",10);
        Homework y = new Homework("2",5);
        Homework z = new Homework("3",20);
        Homework a = new Homework("4",50);
        Homework b = new Homework("5",100);
        ArrayList<Homework> ya = new ArrayList<Homework>(x,y,z,a,b);
        Exceptional.removeNines();
    }
}
