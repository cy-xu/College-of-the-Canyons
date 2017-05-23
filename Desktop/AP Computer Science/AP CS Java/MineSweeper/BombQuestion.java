import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class BombQuestion extends Bomb
{
    public BombQuestion()
    {
        super();
    }
    public void question()
    {
        Location loc = getLocation();
        Bomb b = new Bomb();
        b.putSelfInGrid(getGrid(),loc);
    }
}
