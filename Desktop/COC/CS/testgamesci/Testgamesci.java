import java.util.Arrays;

public class Testgamesci {
    public void main(){
        int[] item_array = {12,17,22,32,37,-1};
        int the_key = 27;
int i = item_array.length - 2;
while (i > 0)  {
item_array[i+1] = item_array[i];
if (the_key < item_array[i] && the_key > item_array[i-1]){
item_array[i] = the_key;
i = -69;
}
i--;
}
System.out.println(Arrays.toString(item_array));
    }
}

/*
 * i = 0;
int index = 0;
while (i < somekeys.length - 1)  {
if (some_key > somekeys[i] && some_key < somekeys[i+1]) index = i + 1;
i++;
}
int j = somekeys.length - 2;
while (j >= index){
somekeys[j+1] = somekeys[j];
j--;
}
somekeys[index] = some_key;

 */