package groking.patternslidingwindow;

public class MinSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Minimum sum of subarray "
				+ MinSizeSubArraySum.findMinSumSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 }));

	}

	private static int findMinSumSubArray(int S, int[] js) {
		// TODO Auto-generated method stub
		int windowSum = 0, minLength = Integer.MAX_VALUE;
		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < js.length; windowEnd++) {

			windowSum += js[windowEnd];

			while(windowSum >= S) {
				
				minLength= Math.min(minLength, (windowEnd - windowStart + 1));
				
				windowSum -= js[windowStart];

				windowStart++;
			}

		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength ;
	}

}
