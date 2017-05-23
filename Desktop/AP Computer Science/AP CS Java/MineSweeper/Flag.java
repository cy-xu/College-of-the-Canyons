import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class Flag extends Space
{
    public Grid<Actor> gr;
    public Flag(Grid<Actor> g)
    {
        super();
        gr = g;
    }
    public void flag()
    {
        Location loc0 = getLocation();
        Space a = new Space();
        a.putSelfInGrid(getGrid(),loc0);
        
        int count1 = 0;
        for (int y = 0; y < gr.getNumRows() ; y++)
        {
            for (int x = 0; x < gr.getNumCols() ; x++)
            {
                Location loc1 = new Location(y,x);
                if (gr.get(loc1) instanceof BombFlag && gr.isValid(loc1))
                {
                        count1++;
                }
            }
        }
        int count2 = 0;
        for (int y = 0; y < gr.getNumRows() ; y++)
        {
            for (int x = 0; x < gr.getNumCols() ; x++)
            {
                Location loc2 = new Location(y,x);
                if ((gr.get(loc2) instanceof Bomb) && gr.isValid(loc2))
                {
                    count2++;
                }
            }
        }
        int count3 = 0;
        for (int y = 0; y < gr.getNumRows() ; y++)
        {
            for (int x = 0; x < gr.getNumCols() ; x++)
            {
                Location loc3 = new Location(y,x);
                if (gr.get(loc3) instanceof Flag && gr.isValid(loc3))
                {
                        count3++;
                }
            }
        }
        if (count1 == count2 && count3 == 0)
        {
            done = true;
            for (int y = 0; y < gr.getNumRows() ; y++)
            {
                for (int x = 0; x < gr.getNumCols() ; x++)
                {
                    Location loc4 = new Location(y,x);
                    if (gr.get(loc4) instanceof Space && gr.isValid(loc4))
                    {
                            ((Space)gr.get(loc4)).reveal();
                    }
                }
            }
        }
    }
    
}
