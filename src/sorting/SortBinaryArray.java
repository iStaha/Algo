package sorting;
import java.util.Arrays;
 
class SortBinaryArray
{
    // Function to sort a binary array in linear time
    public static void sort(int[] A)
    {
    	  // `k` stores index of next available position
        int k = 0;
 
        // do for each element
        for (int i: A)
        {
            // if the current element is zero, put 0 at the next free
            // position in the array
            if (i == 0) {
                A[k++] = 0;
          
            }
        }
 
        // fill all remaining indices by 1
        for (int i = k; i < A.length; i++) {
            A[k++] = 1;
        }
    }
 
    public static void main (String[] args)
    {
        int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };
 
        sort(A);
 
        // print the rearranged array
        System.out.println(Arrays.toString(A));
    }
}