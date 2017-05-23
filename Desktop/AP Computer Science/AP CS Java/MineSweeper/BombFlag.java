import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class BombFlag extends Bomb
{
    public BombFlag()
    {
        super();
    }
    public void flag()
    {
        Location loc = getLocation();
        Bomb b = new Bomb();
        b.putSelfInGrid(getGrid(),loc);
    }
}
