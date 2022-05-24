package array;

import java.util.Arrays;

public class ArrayProductItself {
	
	public static int[] productExceptSelf(int[] nums) {
		
		
		int prouductArray[] = new int[nums.length];
		
		
		Arrays.fill(prouductArray , 1);
		
		int prefix = 1;
		
		
		for(int i = 0; i< nums.length; i++) {
			prouductArray[i]  =  prefix;
			prefix *= nums[i];
		}
		
		
		System.out.println(Arrays.toString(prouductArray));
		
		int posfix= 1;
		
		for(int i = nums.length-1; i>=0; i--) {
			prouductArray [i] *=  posfix;
			posfix *= nums [i];
		}
		
		
		
		
		
		System.out.print(Arrays.toString(prouductArray));
		return null;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []product = {1, 2, 3, 4};
		
		productExceptSelf(product);

	}

}
