public class NumArray
{
    public static void main(String[] args)
    {
        int[] array1 = new int[5];
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;
        array1[3] = 4;
        array1[4] = 5;
        int[] array2 = new int[5];
        array2[0] = 1;
        array2[1] = 2;
        array2[2] = 3;
        array2[3] = 4;
        array2[4] = 5;
    }
    
    public static int[] vectorAdd(int[] array1, int[] array2)
    {

        int[] sum = new int[array1.length];
        int[] zero = new int[0];
        if (array1.length != array2.length)
        {
            System.out.println("DIFFERENT LENGTHS DUMMY");
            return zero;
        }
        for (int i = 0; i < array1.length; i++)
        {
            sum[i] = array1[i] + array2[i];
            
        }
        return sum;
    }
    public static int[] vectorSubtract(int[] array1, int[] array2)
    {

        int[] sum = new int[array1.length];
        int[] zero = new int[0];
        if (array1.length != array2.length)
        {
            System.out.println("DIFFERENT LENGTHS DUMMY");
            return zero;
        }
        for (int i = 0; i < array1.length; i++)
        {
            sum[i] = array1[i] - array2[i];
            
        }
        return sum;
    }
    public static int sumUp(int[] array)
    {
        //int[] sum = new int[array.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++)
        {
            sum = sum + array[i];
        }
        return sum;
    }
    public static int[] scalarMult(int[] array, int x)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = array[i] * x;
        }
        return array;
    }
    public static int dotProduct(int[] array1, int[] array2)
    {
        int sum = 0;
        int add = 0;
        int min = Integer.MIN_VALUE;
        if (array1.length != array2.length)
        {
            System.out.println("DIFFERENT LENGTHS DUMMY");
            return min;
        }       

        for (int i = 0; i < array1.length; i++)
            {
                sum = array1[i] * array2[i];
                add = add + sum;
            }
            return add;
    }
    public static int minArray(int[] array)
    {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++)
        {
            
            if (array[i] < min)
            {
                min = array[i];
                
            }
    
        }
        return min;
        
    }
    public static int maxArray(int[] array)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++)
        {
            
            if (array[i] > max)
            {
                max = array[i];
                
            }

        }
        return max;
        
    }
    public static void toString(int[] array)
    {
        System.out.print("{");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
            if (i != array.length - 1)
            {
                System.out.print(",");
            }

        }
        System.out.print("}");
    }
    
    

}
/*

(DOOZIE ALERT)
j. negEntries – this function should input an array of integers and return an integer array of 
just the negative integers in the same order. For instance, if the input is {4,6,-3,-4,0,9,4,-2} 
and it should return the array {-3,-4,-2}.
(hint - first try to determine the size of the array you will return)

 */