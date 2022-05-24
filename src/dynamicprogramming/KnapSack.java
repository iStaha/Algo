package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };

	//	int maxProfit = solveKnapsack(profits, weights, 7);

		
		int maxProfit = solveKnapsackDynamic(profits, weights, 7);
		System.out.print(maxProfit);

	}

	private static int solveKnapsackDynamic(int[] profits, int[] weights, int capacity) {
		// TODO Auto-generated method stub
	    
		int n = profits.length;
		
		int dp[][] = new int[n][capacity+1];
		
		
		for(int i =0; i< n ; i++){
			dp[i][0] = 0;
		}
		
		for(int c =0; c <= capacity; c++){
			if(weights[0] <= c)
			 dp[0][c] = profits[0];
		}
		
		for(int r =1; r < n; r++){
			for(int c =1; c <= capacity; c++){
				
				int profit1 =0 , profit2 =0;
				
				
				if(weights[r] <= c ) 
					profit1 = profits[r] + dp[r-1][c-weights[r]];
				   
				
				
				    profit2 =  dp[r-1][c];
					
					dp[r][c]= Math.max(profit1, profit2);
				
				
				
			}
		}
		
		
		
	
		return dp[n-1][capacity];
	}

	private static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		// TODO Auto-generated method stub

		Map<String, Integer> knapSackMap = new HashMap<>();

		int ret = knapSackMemoization(profits, weights, capacity, 0, knapSackMap);

		return knapSackRecursive(profits, weights, capacity, 0);

	}

	private static int knapSackMemoization(int[] profits, int[] weights, int capacity, int currentIndex,
			Map<String, Integer> knapSackMap) {
		// TODO Auto-generated method stub

		if (capacity <= 0 || currentIndex >= profits.length) {
			return 0;
		}

		String key = capacity + "|" + currentIndex;

		if (!knapSackMap.containsKey(key)) {
			int include = 0;

			if (weights[currentIndex] <= capacity) {
				include = profits[currentIndex]
						+ knapSackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
			}

			int exclude = knapSackRecursive(profits, weights, capacity, currentIndex + 1);

			knapSackMap.put(key, Math.max(include, exclude));
		}

		return knapSackMap.get(key);
	}

	private static int knapSackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
		// TODO Auto-generated method stub

		if (capacity <= 0 || currentIndex >= profits.length) {
			return 0;
		}

		int include = 0;

		if (weights[currentIndex] <= capacity) {
			include = profits[currentIndex]
					+ knapSackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
		}

		int exclude = knapSackRecursive(profits, weights, capacity, currentIndex + 1);

		return Math.max(include, exclude);
	}

}
