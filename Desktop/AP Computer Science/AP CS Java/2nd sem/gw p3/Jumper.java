import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
public class Jumper extends Actor
{
    public Jumper()
    {
        super();
    }
    public void act()
    {
        if (canMove())
        {
            move();
        }
        else 
        {
            turn();
        }
    }

    public void turn()
    {
        setDirection(getDirection() + 45);
    }

    public void move()
    {
        Grid<Actor> grid= getGrid();
        Location current = getLocation();
        Location one = current.getAdjacentLocation(getDirection());
        Location two = one.getAdjacentLocation(getDirection());

        if (grid.isValid(two) == true)
        {
            moveTo(two);
        }
        else
        {
            removeSelfFromGrid();
        }
    }

    public boolean canMove()
    {
        Grid<Actor> grid = getGrid();
        Location current = getLocation();
        Location one = current.getAdjacentLocation(getDirection());
        Location two = one.getAdjacentLocation(getDirection());
        
        if (grid == null)
        {
            return false;
        }
        
        
        if (grid.isValid(one) == false)
        {
            return false;
        }
            
        Actor neighbor = grid.get(one);
        if (((neighbor != null) && (neighbor instanceof Flower == false) && (neighbor instanceof Rock == false))) 
        {
            return false;
        }
        
        if (grid.isValid(two) == false)
        {
            return false;
        }
        neighbor = grid.get(two);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
}