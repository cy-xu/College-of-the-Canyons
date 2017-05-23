
public class Song
{
    
    private String artist;
    private String name;
    private double length;
    public Song(String singer, String song, double minutes)
    {
        artist = singer;
        name = song;
        length = minutes;
    }
    public String getArtist()
    {
        return artist;
    }
    public String getName()
    {
        return name;
    }
    public double getLength()
    {
        return length;
    }
    public String toString()
    {
        return artist + " - " + name + " (" + length + ")";
    }
    public boolean equals(Song x)
    {
        if (artist.equals(x.getArtist()) && name.equals(x.getName()))
        {
            return true;
        }
        return false;
    }
}