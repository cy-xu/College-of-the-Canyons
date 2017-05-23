import java.util.ArrayList;
public class SearchSort
{
    public static void main(String[] args)
    {
        /*ArrayList<Integer> integerList = new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(7);
        integerList.add(9);
        integerList.add(1);
        System.out.println(integerList);
        selSort(integerList);
        */
        int[] intArray = new int[5];
        intArray[0] = 1;
        intArray[1] = 3;
        intArray[2] = 5;
        intArray[3] = 7;
        intArray[4] = 9;
        int[] intArray2 = new int[5];
        intArray[0] = 2;
        intArray[1] = 4;
        intArray[2] = 6;
        intArray[3] = 8;
        intArray[4] = 10;
        //System.out.println(takePart(intArray,0,3));
        
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("sweg");
        stringList.add("yee");
        stringList.add("boi");
        stringList.add("man");
        stringList.add("yup");
        System.out.println(seqSearch(stringList,"yup"));
    }
    //works!
    public static boolean seqSearch(ArrayList<String> x, String y)
    {
        for (int i = 0; i < x.size(); i ++)
        {
            if (x.get(i).equals(y))
            {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> selSort(ArrayList<Integer> x)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int smallest = Integer.MAX_VALUE;
        int spot = 0;
        for (int j = 0; j < x.size()-1 ; j++)
        {
            spot = j;
            for (int i = j+1; i < x.size(); i++)
            {
                smallest = x.get(j);
                if (x.get(i) < x.get(spot))
                {
                    
                    spot = i;
                }
            }
            x.remove(spot);
            list.add(smallest);
        }
        
        return list;
    }
    public static ArrayList<Integer> insertSort(ArrayList<Integer> x)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int temp = 1337;
        for (int j = 0; j < x.size() ; j++)
        {
            temp = x.get(j);
            for (int i = j-1; i >= 0; i--)
            {
                if (temp < x.get(i))
                {
                    //a[i+1] = a[j];
                }
            }
            
        }
        return list;
    }
    //works!
    public static int[] takePart( int[] nums, int index1, int index2)
    {
        
        int[] list = new int[0];
        if (index1 > nums.length || index2 > nums.length)
        {
            return list;
        }
        else if ( index1 < index2)
        {
            list = new int[index2-index1];
            for (int j = 0; j < (index2-index1); j++)
            {
                list[j] = nums[index1+j];
            }
        
        }
        else if (index1 > index2)
        {
            list = new int[index1-index2];
            for (int j = 0; j < (index1-index2); j++)
            {
                list[j] = nums[index2+j];
            }
            
        }
        
        return list;
    }
    //works!
    public static int[] totalOrder(int[] nums1, int[] nums2) 
    {
        int[] list = new int[nums1.length + nums2.length];
        int count1 = 0;
        int count2 = 0;
        int countList = 0;
        while ( count1 < nums1.length && count2 < nums2.length)
        {
            if ( nums1[count1] < nums2[count2])
            {
                list[countList] = nums1[count1];
                count1++;
            }
            else
            {
                list[countList] = nums2[count2];
                count2++;
            }
            countList++;
        }
        while (count1 < nums1.length)
        {
            list[countList] = nums1[count1];
            count1++;
            countList++;
        }
        while ( count2 < nums2.length)
        {
            list[countList] = nums2[count2];
            count2++;
            countList++;
        }
        return list;
    }
    public static int[] merSort(int[] x)
    {
        if (x.length <= 1)
        {
            return x;
        }
        int half = x.length/2;
        int half1[] = new int[half];
        int half2[] = new int[x.length - half];
        for (int i = 0; i < half; i++)
        {
            half1[i] = x[i];
        }
        for (int j = half; j < x.length; j++)
        {
            half2[j-half] = x[j];
        }
        return merSort(totalOrder(half1, half2));
    }
    public static boolean binSearch()
    {
        return false;
    }
    
    
}
