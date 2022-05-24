package array;

public class MaxSumSubArray {
	
	public static int maxSubArray(int[] nums) {
		 
	    int n = nums.length;
	    int maximumSubArraySum = Integer.MIN_VALUE;
	    int start = 0;
	    int end = 0;
	 
	    for (int left = 0; left < n; left++) {
	 
	        int runningWindowSum = 0;
	 
	        for (int right = left; right < n; right++) {
	            runningWindowSum += nums[right];
	 
	            if (runningWindowSum > maximumSubArraySum) {
	                maximumSubArraySum = runningWindowSum;
	                start = left;
	                end = right;
	            }
	            
	            System.out.println(left +" "+ right + "  "+ start +" "+ end + "  " + maximumSubArraySum);
	        }
	       
	    }
	    
	  

	    return maximumSubArraySum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	//	int maxSum[] = { -2, 3, 2 , -1};
		int maxSums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		
		System.out.println(maxSubArray(maxSums));

	}

}
