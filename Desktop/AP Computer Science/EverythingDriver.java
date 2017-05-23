
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EverythingDriver
{
    public static void main()
    {
        Enemy ran = new Enemy("Rohan");
        //which version of printMaxHP will it call?
        //this calls the overwritten version
        ran.printMaxHP();
        
        //I can make an array or ArrayList of Characters and put enemies and allies in it
        //I can put in characters and any subclass of characters
        Character[] dogs = new Character[3];
        dogs[0] = new Enemy("Rohan");
        dogs[1] = new Ally("Adam");
        dogs[2] = new Character();
    }
}
