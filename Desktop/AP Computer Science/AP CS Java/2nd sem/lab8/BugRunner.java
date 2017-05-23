import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
public class BugRunner
{
    public static void main(String[] args)
    {
        int[] array = new int[4];
        array[0] = 4;
        array[1] = 3;
        array[2] = 2;
        array[3] = 1;
        ActorWorld world = new ActorWorld();
        world.add(new DancingBug( array ) );
        world.add(new Rock());
        world.add(new ZBug(4));
        world.add(new SpiralBug(4));
        world.add(new CircleBug(4));
        world.show();
        
    }
}
