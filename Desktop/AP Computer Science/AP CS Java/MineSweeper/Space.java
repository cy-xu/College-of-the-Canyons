import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class Space extends Actor
{
    private ArrayList<Location> bombLocs = new ArrayList<Location>();
    public Grid<Actor> grid = getGrid();
    public boolean done;
    public Space()
    {
       done = false;
    }
    private int numBombs()
    {
        int count = 0;
        ArrayList<Actor> neighbors = new ArrayList<Actor>();
        neighbors = getGrid().getNeighbors(getLocation());
        
        for (int j = 0; j < neighbors.size() ; j++)
        {
            if (neighbors != null && (neighbors.get(j) instanceof Bomb || neighbors.get(j) instanceof RevealedBomb))
            {
                count++;
            }
        }

        return count;
    }
    public void reveal()
    {
        Location loc = getLocation();
        Grid<Actor> g = getGrid();
        if (loc == null || !(g.isValid(loc) ))
        {
            return;
        }
        else
        {
            if (isBomb())
            {
                RevealedBomb bomb = new RevealedBomb();
                bomb.putSelfInGrid(g,loc);
                if (done == false)
                {
                    System.out.println("YOU LOSE");  
                }
                end();
                setSpacesToLoss(g);
                gameOver(g);
            }
            else if (numBombs() == 1)
            {
                One a = new One();
                a.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
    
            }
            else if (numBombs() == 2)
            {
                Two b = new Two();
                b.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
            }
            else if (numBombs() == 3)
            {
                Three c = new Three();
                c.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
            }
            else if (numBombs() == 4)
            {
                Four d = new Four();
                d.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
            }
            else if (numBombs() == 5)
            {
                Five e = new Five();
                e.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
            }
            else if (numBombs() == 6)
            {
                Six f = new Six();
                f.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
            }
            else if (numBombs() == 7)
            {
                Seven i = new Seven();
                i.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
            }
            else if (numBombs() == 8)
            {
                Eight h = new Eight();
                h.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
            }
            else if (numBombs() == 0)
            {
                ArrayList<Actor> list = new ArrayList<Actor>();
                list = g.getNeighbors(loc);
                Zero i = new Zero();
                i.putSelfInGrid(g,loc);
                if (isWin(g))
                {
                    end();
                    setSpacesToLoss(g);
                    gameOver(g);
                    System.out.println("YOU WIN!");
                }
                for (int n = 0; n < list.size(); n++)
                {
                    if (list.get(n) instanceof Space)
                    {
                        ((Space)list.get(n)).reveal();
                    }
                }
            }
        }
        
    }
    private ArrayList<Location> locations()
    {
        Location loc;
        for (int i = 0; i < grid.getNumRows(); i++)
        {
            for (int j = 0; j < grid.getNumCols(); j++)
            {
                loc = new Location(i,j);
                if (grid.get(loc) instanceof Space)
                {
                    bombLocs.add(loc);
                }
            }
        }
        return bombLocs;
    }
    public void flag()
    {
        Grid<Actor> g = getGrid();
        Location loc = getLocation();
        Flag a;
        BombFlag b;
        if (isBomb())
        {
            b = new BombFlag();
            b.putSelfInGrid(g,loc);
            if (isWin(g))
            {
                end();
                setSpacesToLoss(g);
                gameOver(g);
                System.out.println("YOU WIN!");
            }
        }
        else
        {
            a = new Flag(g);
            a.putSelfInGrid(g,loc);
        }
        
    }
    private boolean isBomb()
    {
        if (this instanceof Bomb)
        {
            return true;
        }
        return false;
    }
    private void gameOver(Grid<Actor> grid)
    {
        for (int y = 0; y < grid.getNumRows() ; y++)
        {
            for (int x = 0; x < grid.getNumCols() ; x++)
            {
                Location loc = new Location(y,x);
                if (grid.get(loc) instanceof Space && grid.isValid(loc))
                {
                    ((Space)grid.get(loc)).reveal();
                }
            }
        }
    }
    private boolean isWin(Grid<Actor> g)
    {
        int count = 0;
        if (done == false)
        {
            
            if (getNumBombFlags(g) == totalBombs(g) && isNormalFlags(g) == false)
            {
                return true;
            }
            
            for (int y = 0; y < g.getNumRows() ; y++)
            {
                for (int x = 0; x < g.getNumCols() ; x++)
                {
                    Location loc = new Location(y,x);
                    if (g.get(loc) instanceof Space && !(g.get(loc) instanceof Bomb) && g.isValid(loc))
                    {
                            count++;
                    }
                }
            }
            if (count == 0)
            {
                return true;
            }
        }
        return false;
    }
    private int totalBombs(Grid<Actor> g)
    {
        int count = 0;
        for (int y = 0; y < g.getNumRows() ; y++)
        {
            for (int x = 0; x < g.getNumCols() ; x++)
            {
                Location loc = new Location(y,x);
                if ((g.get(loc) instanceof Bomb) && g.isValid(loc))
                {
                    count++;
                }
            }
        }
        return count;
    }
    private void setSpacesToLoss(Grid<Actor> g)
    {

        for (int y = 0; y < g.getNumRows() ; y++)
        {
            for (int x = 0; x < g.getNumCols() ; x++)
            {
                Location loc = new Location(y,x);
                if (g.get(loc) instanceof Space && g.isValid(loc))
                {
                        ((Space)g.get(loc)).end();
                }
            }
        }
    
    }
    private void end()
    {
        done = true;
    }
    private int getNumBombFlags(Grid<Actor> g)
    {
        int count = 0;
        for (int y = 0; y < g.getNumRows() ; y++)
        {
            for (int x = 0; x < g.getNumCols() ; x++)
            {
                Location loc = new Location(y,x);
                if (g.get(loc) instanceof BombFlag && g.isValid(loc))
                {
                        count++;
                }
            }
        }
        return count;
    }
    private boolean isNormalFlags(Grid<Actor> g)
    {
        int count = 0;
        for (int y = 0; y < g.getNumRows() ; y++)
        {
            for (int x = 0; x < g.getNumCols() ; x++)
            {
                Location loc = new Location(y,x);
                if (g.get(loc) instanceof Flag && g.isValid(loc))
                {
                        count++;
                }
            }
        }
        if (count == 0)
        {
            return false;
        }
        return true;
    }
    public void question()
    {
        Grid<Actor> g = getGrid();
        Location loc = getLocation();
        Question a;
        BombQuestion b;
        if (isBomb())
        {
            b = new BombQuestion();
            b.putSelfInGrid(g,loc);
        }
        else
        {
            a = new Question();
            a.putSelfInGrid(g,loc);
        }
        
    }
}
