
public interface Lockable
{
    public final int password = 1713;
    public void lock(int a);
    
    public void unlock(int a);
    
    public boolean isLocked();
}
