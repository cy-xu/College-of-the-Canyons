import java.util.ArrayList;
public class PlayList
{
    private ArrayList<Song> tunes;
    public PlayList()
    {
        tunes = new ArrayList<Song>();
    }
    public PlayList(ArrayList<Song> list)
    {
        tunes = list;
    }
    public void add(Song s)
    {
        tunes.add(tunes.size(), s);
    }
    public int numberOfSongs()
    {
        return tunes.size();
    }
    public double totalLength()
    {
        double sum = 0;
        for (int i = 0; i < tunes.size() ; i++)
        {
            sum = sum + (tunes.get(i)).getLength();
        }
        return sum;
    }
    public Song playSong()
    {
        Song playing;
        playing = tunes.get(0);
        tunes.remove(0);
        return playing;
    }
    public void removeArtist(String x)
    {
        for (int i = 0; i<tunes.size(); i++)
        {
            if ((tunes.get(i)).equals(x))
            {
                tunes.remove(i);
                i--;
            }
        }
    }
    public void removeLength(double x)
    {
        for (int i = 0; i < tunes.size() ; i++)
        {
            if ((tunes.get(i)).getLength() >= x)
            {
                tunes.remove(i);
                i--;
            }
        }
    }
    public void shuffle()
    {
        ArrayList<Song> randomList = new ArrayList<Song>();
        ArrayList<Song> compare = new ArrayList<Song>();
        while (true)
        {
            int random = (int)(tunes.size()*Math.random());
            randomList.add(tunes.get(random));
            tunes.remove(random);
            if (tunes.equals(compare))
            {
                tunes = randomList;
                break;
            }
        }
        
    }
    public String toString()
    {
        return " " + tunes;
    }
}