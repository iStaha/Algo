package array;

import java.util.Arrays;

public class SquareSortedArray {
	
	
	
	 public static int[] sortedSquare(int[] arr) {
	        
	        int n = arr.length;
	        int[] result = new int[n];
	        int i = 0;
	        int j = n-1;
	        
	        for(int k = n-1; k>=0; k--){
	            
	            if(Math.abs(arr[i]) > Math.abs(arr[j])){
	                result[k] = arr[i] * arr[i];
	                i++;
	            }else{
	                result[k] = arr[j] * arr[j];
	                j--;
	            }
	            
	        }
	        
	        return result;
	    }

	public static int[] sortedSquares(int[] nums) {
		int length = nums.length;
		int[] output = new int[length];
		int start = 0;
		int end = length - 1;
		int cnt = length - 1;

		while (start <= end) {
			int val1 = (int) Math.pow(nums[start], 2);
			int val2 = (int) Math.pow(nums[end], 2);

			if (val1 > val2) {
				output[cnt] = val1;
				start++;
			} else {
				output[cnt] = val2;
				end--;
			}
			cnt--;

		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int  sortedSquares [] = {-4,-1,0,3,10};
		
		
		System.out.println(Arrays.toString(sortedSquare(sortedSquares)));
		
		
	}

}
