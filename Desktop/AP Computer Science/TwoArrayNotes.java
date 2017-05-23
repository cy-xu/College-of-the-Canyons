
public class TwoArrayNotes
{
    public static void main(String[] args)
    {
        int[][] ray = new int[3][4];
        
        //number of rows
        System.out.println(ray.length ) ;
        
        //number of columns, find the length of one of the inner
        //arrays. safest to use ray[0], the first row
        //length of row 0
        System.out.println(ray[0].length ) ;
        
        //set up our 2d array (matrix)
        //each entry be the row number + col number
        
        //loop through the rows
        for (int i = 0; i < ray.length ; i++)
        {
            //loop through each column in row i
            for (int j = 0 ; j < ray[i].length ; j++)
            {
                //set up each entry
                ray[i][j] = i + j;
        
            }
        }
        
        //to print this out, print out each entry
        //loop through the rows
        for (int i = 0; i < ray.length ; i++)
        {
            //loop through each column in row i
            for (int j = 0 ; j < ray[i].length ; j++)
            {
                //set up each entry
                //no extra line after each entry
                System.out.print(ray[i][j] + " ");
        
            }
            
            //after finishing one row, loop through the columns
            //then print a blank line
            System.out.println();
        }
    }
    
    //use these as inputs, outputs
    //return true in each location with an even number
    //false if each number is odd
    public static boolean[][] trueEven(int[][] nums)
    {
        //set up a 2d boolean array, same dimensions as nums
        boolean[][] truth = new boolean[nums.length][nums[0].length];
        
         //loop through the rows
        for (int i = 0; i < truth.length ; i++)
        {
            //loop through each column in row i
            for (int j = 0 ; j < truth[i].length ; j++)
            {
                if (nums[i][j] % 2 == 0) //if even
                {
                    truth[i][j] = true;
                }
                else
                truth[i][j] = false;
        
            }
        }
        
        return truth;
        
        
    }
    
    
    
    
}
