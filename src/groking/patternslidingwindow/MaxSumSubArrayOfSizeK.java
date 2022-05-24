package groking.patternslidingwindow;

public class MaxSumSubArrayOfSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Maximum sum of subarray of size K "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		
		System.out.println("Maximum sum of subarray of size K "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] {2 , 3, 4, 1, 5 }));
		
		
		System.out.println("Maximum sum of subarray of size K "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArrayOptimized(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		
		

	}

	private static int findMaxSumSubArrayOptimized(int k, int[] js) {
		
		int maxSum = 0, windowSum = 0;
		
		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < js.length; windowEnd++) {
			
			windowSum += js[windowEnd];
			
			if(windowEnd >= k-1) {
				maxSum= Math.max(maxSum, windowSum);
				windowSum -= js[windowStart];
				
				windowStart++;
			}
			
			

		}

		return maxSum;
	}

	private static int findMaxSumSubArray(int k, int[] js) {

		int maxSum = 0, windowSum;

		for (int i = 0; i <= js.length - k; i++) {
			windowSum = 0;
			for (int j = i; j < i + k; j++) {
				windowSum += js[j];
			}
			
			maxSum= Math.max(maxSum, windowSum);

		}

		return maxSum;
	}

}
