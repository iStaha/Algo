package array;

import java.util.ArrayList;
import java.util.List;

class NonDecreasingArray {

	public static void main(String... d) {

		int nums[] = {  4, 2, 3 };
//		System.out.println(checkPossibility(nums));
		System.out.println(chekPossibility(nums));
	}

	public static boolean checkPossibility(int[] nums) {

		int count = -1;
 
		int max = nums[0];
		
		for (int i = 1; i < nums.length - 1; i++) {

			if (!(  max  < nums[i] )   ) {
				count++;
			} else
			max= Math.max(max, nums[i]);

		}

		if (count > 1) {
			return false;
		}
		
		System.out.println(count);

		return true;
	}
	
	public static boolean chekPossibility(int[] nums) {
        int violation = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] > nums[i]){
                
                if(violation == 1){
                    return false;
                }
                violation++;
               
                if(i<2 || nums[i-2] <= nums[i])
                    nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
                
            }
        }
        
        return true;
    }
	
	
	public static boolean checPossibility(int[] nums) {
        int pos = -1;
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(pos!=-1){
                    return false;
                }
                pos=i;
            }
        }
        
        return pos==-1 || pos==0 || pos == nums.length-2 || nums[pos-1]<=nums[pos+1] || nums[pos]<=nums[pos+2];
    }
}