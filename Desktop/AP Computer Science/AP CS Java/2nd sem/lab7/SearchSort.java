import java.util.ArrayList;
public class SearchSort
{
    public static void main(String[] args)
    {
        //seqSearch test
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("sweg");
        stringList.add("yee");
        stringList.add("boi");
        stringList.add("man");
        stringList.add("yup");
        System.out.println(seqSearch(stringList,"yup"));
        
        
        //selSort - insertSort test
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(7);
        integerList.add(9);
        integerList.add(1);
        System.out.println(integerList);
        //selSort(integerList);
        insertSort(integerList);
        System.out.println(integerList);
        
        
        //merSort test
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
        System.out.println(merSort(intArray));
        
    }
    
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
        int spot;
        for (int i = 0; i < x.size() ; i++)
        {
            spot = i;
            smallest = x.get(i);
            for (int j = i+1; j < x.size(); j++)
            {
                if (x.get(j) < smallest)
                {
                    smallest = x.get(j);
                    spot = j;
                }
            }
            if (spot != i)
            {
                int temp = x.get(i);
                x.set(i, x.get(spot));
                x.set(spot,temp);
            }
        }
        
        return x;
    }
    
    public static ArrayList<Integer> insertSort(ArrayList<Integer> x)
    {
        int temp = 1337;
        int sub = 1337;
        for (int i = 1; i < x.size() ; i++)
        {
            temp = x.get(i);
            for (int j = i - 1; j >= 0; j--)
            {
               if (x.get(j) > temp)
               {
                   sub = x.get(j);
                   x.set(j, x.get(j+1));
                   x.set(j+1,sub);
                }
            }
        }
        return x;
    }
    
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
        int[] first = new int[x.length/2];
        int[] second = new int[x.length - x.length/2];
        if (x.length > 1)
        {
            first = takePart(x,0,x.length/2);
            second = takePart(x,x.length/2, x.length);
            return totalOrder(merSort(first),merSort(second));
        }
        else
        {
            return x;
        }
        
    }
    
    public static boolean binSearch(int[] x, int y)
    {
        int right = x.length;
        int left = 0;
        int mid = (right + left)/2;
        for (int i = 0; i < x.length/2 ; i++)
        {
            mid = (right + left)/2;
            if (x[mid] == y)
            {
                return true;
            }
            else if ( x[mid] < y)
            {
                left = mid;
            }
            else if (x[mid] > y)
            {
                right = mid;
            }
        }
        return false;
    }
}
