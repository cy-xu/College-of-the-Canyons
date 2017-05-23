import java.util.ArrayList;
public class HomeworkDriver
{
    public static void main(String[] args)
    {
        Homework x = new Homework("1",10);
        Homework y = new Homework("2",5);
        Homework z = new Homework("3",20);
        Homework a = new Homework("4",50);
        Homework b = new Homework("5",100);

        System.out.println(x.getDescription());
        System.out.println(x.getPoints());
        x.changePoints(5);
        System.out.println(x.getPoints());
        Homework.printAssignments();
        System.out.println(Homework.numAssignments());
        System.out.println(Homework.getTotalPoints());
        System.out.print(x);
    }
}
