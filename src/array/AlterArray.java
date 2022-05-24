package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlterArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, -2, 6, 4, -3, 2, -4, -3 };

		findLongestSubArray(arr);

	}

	private static void findLongestSubArray(int[] arr) {
		// TODO Auto-generated method stub

		int max_len= 1;
		int len_current = 1;
		int end_Index = 0;

	
		for(int i =1 ; i<arr.length; i++) {

			if((arr[i] < 0 && arr[i-1]>=0)  || (arr[i] >= 0 && arr[i-1]<0) ) {
				len_current++;
							

				if(len_current> max_len) {
					max_len = len_current;
					end_Index = i;
				}
			}
			
			else {
				len_current = 1 ;
			}
			
			
			

		
		}

		

	
		int[] subarray = Arrays.copyOfRange(arr,  (end_Index - max_len + 1), end_Index + 1);
		

		
		System.out.println("The longest alternating subarray is "
                + Arrays.toString(subarray));


	}

}
