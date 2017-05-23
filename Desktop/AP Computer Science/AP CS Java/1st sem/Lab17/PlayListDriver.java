import java.util.ArrayList;

public class PlayListDriver
{
    public static void main(String[] args)
    {
        PlayList mysongs = new PlayList();
        
        mysongs.add(new Song("Metallica", "Master of Puppets", 8.23));
        
        mysongs.add(new Song("Pantera", "Walk", 5));
        
        mysongs.add(new Song("Eminem", "Almost Famous", 4.5) );
        
        System.out.println(mysongs);
        
        mysongs.shuffle();
        
        System.out.println(mysongs); //shuffle and test it out
    }
}
