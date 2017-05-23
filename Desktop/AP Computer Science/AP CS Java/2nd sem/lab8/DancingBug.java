import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;
public class DancingBug extends Bug
{
    private int[] entries;
    private int spot;
    
    public DancingBug(int[] x)
    {
        entries = x;
        spot = -1;
    }
    public int entryTurn()
    {
        int turn = 0;
        spot++;
        turn = entries[spot]*45;
        if (spot == entries.length-1)
        {
            spot = -1;
        }
        return turn;
        
    }
    public void act()
    {
        setDirection(getDirection() + entryTurn());
        if (canMove())
        {
            move();
        }
        else
        {
            turn();
        }
    }
}
