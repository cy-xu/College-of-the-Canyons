import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import cs1.Keyboard;
public class Minesweeper
{
    public static ArrayList<Location> bombLocs = new ArrayList<Location>();
    public static void main(String[] args)
    {
        System.out.println("Welcome to Minesweeper.\nDifficulty: monkey [1], chump [2], Pulok [3], Borish [4]");
        int difficulty = Keyboard.readInt();
        if (difficulty == 1)
        {
            System.out.println("Difficulty set to \"monkey\" (easy)");
            int row = 5;
            int col = 5;
            int bombs = 4;
            Grid<Actor> g = new BoundedGrid<Actor>(row,col); 
            ActorWorld world = new ActorWorld(g);
            for (int i = 0 ; i < bombs ; i++)
            {
               world.add(new Bomb());
            }
            bombLocs = g.getOccupiedLocations();
            int spots = row * col - bombs;
            for (int i = 0; i < spots ; i++)
            {
                world.add(new Space());
            }
            world.show();
        }
        else if (difficulty == 2)
        {
            System.out.println("Difficulty set to \"chump\" (medium)");
            int row = 10;
            int col = 10;
            int bombs = 15;
            Grid<Actor> g = new BoundedGrid<Actor>(row,col); 
            ActorWorld world = new ActorWorld(g);
            for (int i = 0 ; i < bombs ; i++)
            {
               world.add(new Bomb());
            }
            bombLocs = g.getOccupiedLocations();
            int spots = row * col - bombs;
            for (int i = 0; i < spots ; i++)
            {
                world.add(new Space());
            }
            world.show();
        }
        else if (difficulty == 3)
        {
            System.out.println("Difficulty set to \"Pulok\" (hard)");
            int row = 20;
            int col = 20;
            int bombs = 100;
            Grid<Actor> g = new BoundedGrid<Actor>(row,col); 
            ActorWorld world = new ActorWorld(g);
            for (int i = 0 ; i < bombs ; i++)
            {
               world.add(new Bomb());
            }
            bombLocs = g.getOccupiedLocations();
            int spots = row * col - bombs;
            for (int i = 0; i < spots ; i++)
            {
                world.add(new Space());
            }
            world.show();
        }
        else if (difficulty == 4)
        {
            System.out.println("Difficulty set to \"Borish\" (intense)");
            int row = 25;
            int col = 25;
            int bombs = 200;
            Grid<Actor> g = new BoundedGrid<Actor>(row,col); 
            ActorWorld world = new ActorWorld(g);
            for (int i = 0 ; i < bombs ; i++)
            {
               world.add(new Bomb());
            }
            bombLocs = g.getOccupiedLocations();
            int spots = row * col - bombs;
            for (int i = 0; i < spots ; i++)
            {
                world.add(new Space());
            }
            world.show();
        }
        else
        {
            System.out.println("Invalid Difficulty. Defaulting to \"monkey\" (easy) difficulty. \nIf you need help counting your fingers, ask Pulok for help.");
            int row = 5;
            int col = 5;
            int bombs = 4;
            Grid<Actor> g = new BoundedGrid<Actor>(row,col); 
            ActorWorld world = new ActorWorld(g);
            for (int i = 0 ; i < bombs ; i++)
            {
               world.add(new Bomb());
            }
            bombLocs = g.getOccupiedLocations();
            int spots = row * col - bombs;
            for (int i = 0; i < spots ; i++)
            {
                world.add(new Space());
            }
            world.show();
        }
    }
        
    
    
}
