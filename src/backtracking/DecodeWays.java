package backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecodeWays {
	private static final List<String> LETTERS = IntStream.range(1, 27).mapToObj(Integer::toString)
			.collect(Collectors.toList());

	public static int countDecodeWays(String digits) {
		if (digits.isEmpty() || digits == null)
			return 0;
		// System.out.println(LETTERS);
		return dfs(0, new int[digits.length()], digits);
	}

	private static int dfs(int i, int[] memo, String digits) {
		if (i == digits.length())
			return 1;
		if (memo[i] != 0)
			return memo[i];

		int ways = 0;
		for (String prefix : LETTERS) {
			System.out.println(i + "    " + prefix + "    " + digits.substring(i) + "  " + Arrays.toString(memo));
			if (digits.substring(i).startsWith(prefix)) {
				ways += dfs(i + prefix.length(), memo, digits);
				System.out.println(ways);
			}
		}
		memo[i] = ways;

		System.out.println("ways");
		return ways;
	}

	public static void main(String[] args) {
	//	System.out.println(countDecodeWays("123"));
		System.out.println(numDecodings("123"));
	}

	/*
	 * Solution 1:
	 * 
	 * Here we use an array of size n + 1 to save sub-problem solutions. dp[0] means
	 * an empty string will have one way to decode, dp[1] means the number of ways
	 * to decode a string of size 1 and so on.
	 * 
	 * Then we will check one digit and two digit combination and save the results
	 * along the way. Finally, dp[n] will be the end result. Time complexity: O(n)
	 * Space Complexity: O(n)
	 */

	/*
	 * Time complexity: O(n) Space Complexity: O(n)
	 */
	public static int numDecodings(String s) {
		if (s.isEmpty() || s.charAt(0) == '0')
			return 0;

		int n = s.length();
		int[] dp = new int[s.length() + 1];
		dp[0] = dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int first = Integer.parseInt(s.substring(i - 1, i));
			int second = Integer.parseInt(s.substring(i - 2, i));

			if (first >= 1 && first <= 9)
				dp[i] += dp[i - 1];
			if (second >= 10 && second <= 26)
				dp[i] += dp[i - 2];
		}
		return dp[n];
	}

	/*
	 * Time complexity: O(n) Space Complexity: O(1)
	 */

	public static int numDecoding(String s) {
		if (s.isEmpty())
			return 0;

		int prev = 26;
		int result = 0;
		int first = 1, second = 1;

		for (int i = s.length() - 1; i >= 0; i--) {
			int digit = s.charAt(i) - '0';

			if (digit == 0)
				result = 0;
			else
				result = first + (digit * 10 + prev <= 26 ? second : 0);

			second = first;
			first = result;
			prev = digit;
		}
		return result;
	}

//	Map<String, Integer> map = new HashMap<>();
	public int numDecodinggs(String s) {
		if (s.length() > 0 && s.charAt(0) == '0')
			return 0;
		if (s.length() <= 1)
			return 1;
		// if(map.get(s) != null) return map.get(s);
		int result = 0;
		if (Integer.parseInt(s.substring(0, 2)) <= 26)
			result = numDecodings(s.substring(1)) + numDecodings(s.substring(2));
		else
			result = numDecodings(s.substring(1));
		// map.put(s, result);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	Theory
//	This problem is a convoluted version of https://leetcode.com/problems/climbing-stairs/ and https://leetcode.com/problems/fibonacci-number/.
//	The idea is that we have a choice of advancing one forward or two steps forward. We should start with a baseline recursive solution, then implement a caching solution.

//	~Credit: https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp

//	Solution (Brute Force - Recursion)
	    public int numDecdings(String s) {
	        if (s == null || s.length() == 0) return 0;
	        return decode(0, s);
	    }
	    
	    private int decode(int index, String s) {
	        if (index == s.length()) return 1;
	        if (s.charAt(index) == '0') return 0;
	        int count = decode(index + 1, s);
	        if(index < s.length() - 1) {
	            if (s.charAt(index) == '1'|| (s.charAt(index) =='2'&& s.charAt(index + 1) <'7')) count += decode(index+2,s);    
	        } 
	        return count;
	    }
//	Solution (Caching - Accepted)
	    public int numDedings(String s) {
	        if (s == null || s.length() == 0) return 0;
	        return decode(0, s, new HashMap<Integer, Integer>());
	    }
	    
		private int decode(int index, String s, Map<Integer, Integer> cache) {
	        if (index == s.length()) return 1;
	        if (s.charAt(index) == '0') return 0;
	        
	        if (cache.containsKey(index)) {
	            //System.out.println("cache hit!");
	            return cache.get(index);    
	        } 
	        
	        int count = decode(index + 1, s, cache);
	        if(index < s.length() - 1) {
	            if (s.charAt(index) == '1'|| (s.charAt(index) =='2'&& s.charAt(index + 1) <'7')) count += decode(index + 2 , s, cache);    
	        }
	        cache.put(index, count);
	        return count;
	    }	
	
	
	
	
}