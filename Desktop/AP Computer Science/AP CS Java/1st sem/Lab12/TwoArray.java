public class TwoArray
{
    public static int[][] zeroNags(int[][] array)
    {
   
        int[][] sub = new int[array.length][array[0].length];
        for (int i = 0; i < array.length ; i++)
        {
            for (int j = 0; j < array[i].length ; j++)
            {
                if (array[i][j] < 0)
                {
                    array[i][j] = 0;
                }

            }
        }
        return array;
    }
    public static int sumAll(int[][] array)
    {
        int sum = 0;

        for (int i = 0; i < array.length ; i++)
        {
            
            for (int j = 0; j < array[i].length ; j++)
            {
                sum = sum + array[i][j];
            }
        }
        return sum;
    }
    public static int[][] timesTable(int m, int n)
    {
        int[][] sub = new int[m+1][n+1];
        for (int i = 1 ; i < m+1; i++)
        {

            for (int j = 1; j < n+1; j++)
            {
                
                sub[i][j] = i*j;

            }
        }
        return sub;
    }
}
