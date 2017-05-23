import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Rock());
        world.add(new Flower());
        world.add(new Bug());
        world.add(new Jumper());
        
        world.show();
    }
}
