

public class ArrayOfLight
{
    public static void main(String[] args)
    {
        //declare a group of 5 integers
        //declare as an array, do it like so:
        //length of 5
        int[] nums = new int[5];
        
        //to set individual entries
        nums[0] = 4;
        nums[1] = 4896245;
        nums[4] = -135;
        
        //change an entry
        nums[0] = -4;
        int x = 2;
        nums[x] = 7;
        
        //print out nums[2]
        //System.out.println(nums[2]);
        
        //to print out the length (NO PARENTHESES!)
        //System.out.println(nums.length );
        
        //array of strings
        String[] words = new String[2];
        words[0] = new String("Ross");
        words[1] = new String("Boss");
        
        //set up an array all at once, all the squares from 0^2 to 9^2
        nums = new int[10];
        //start at 0, go < length
        for (int i = 0; i < nums.length ; i++)
        {
            //set up
            nums[i] = i*i;
        }
        //print out 8th entry
        //System.out.println(nums[8]);
        
        //print out the entire array!
        //this doesnt work, prints memory location
        System.out.println(nums);
        
        for (int i = 0; i < nums.length; i++)
        {
            //print out on same line
            System.out.print(nums[i] + " ");
        }
        
        //test two arrays
        nums = new int[2];
        nums[0] = 6;
        nums[1] = 9;
        
        int[] nums2 = new int[2];
        nums2[0] = 6;
        nums2[1] = 9;
        
        System.out.println(nums2.toString());
        
        //tried to access out of bounds
        //compiling because java doesnt know how long nums2 is
        //System.out.println(nums2[3000]);
        
        //this does not print because it compares memory locations
        //lets write our own comparison
        if (nums == nums2)
        {
            System.out.println("THIS CRAP IS THE SAME");
        }
        
        
    }
    
    
    
    //methods can have arrays as inputs or outputs
    public static boolean arrayEquals(int[] arr1, int[] arr2)
    {
        //if they are different lengths, return false
        if (arr1.length != arr2.length)
        {
            return false;
        }
        
        //want to make sure EVERYTHING is the same
        //see if every item is the same. IF NOT, return false
        //if i get thru all the way, return true
        
        for (int i = 0; i < arr1.length ; i++)
        {
            //comparing the ints in entry i
            if (arr1[i] != arr2[i])
            {
                //if these entries are different, leave the method, false
                //dont need to check
                return false;
            }
            
        }
        //we only return true if we get through the whole loop
        //successfully
        return true; 
    
    
    }
    
    //this method outputs an array
    public static String[] tripString(String entry)
    {
        String[] dee2 = new String[3];
        dee2[0] = entry;
        dee2[1] = entry;
        dee2[2] = entry;
        
        return dee2;
    }
    
   
}
