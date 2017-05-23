import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class Question extends Space
{
    public Question()
    {
        super();
    }
    public void question()
    {
        Location loc = getLocation();
        Space b = new Space();
        b.putSelfInGrid(getGrid(),loc);
    }
}
