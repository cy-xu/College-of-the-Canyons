public class Vehicle
{
    public int year;
    public String make;  
    public String model;
    
    public Vehicle()
    {
        make = new String();
        year = 0;
        model = new String();
    } 
        
    boolean canGo() 
    {
        return false;
    }
    boolean canStop() 
    {
        return true;
    }
    boolean canTurn() 
    {
        return false;
    }
} 