package strings;

import java.util.Arrays;

public class ExpressionMatching {
	
	  public static boolean isMatch(String text, String pattern) {
		   if (pattern.isEmpty()) return text.isEmpty();
		   System.out.println("T->" +text);
		   System.out.println("P->" +pattern);
		   boolean first_match = (!text.isEmpty() &&
		        (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '?'));

		        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
		        	System.out.println("INSIDE");
		            return (isMatch(text, pattern.substring(2)) ||
		                    (first_match && isMatch(text.substring(1), pattern)));
		        } else {
		        	System.out.println("OUTSIDE");
		            return first_match && isMatch(text.substring(1), pattern.substring(1));
		        }
		    }
	  
	  public static boolean isMatching(String str, String pattern)
		{
			// get length of String and wildcard pattern
			int n = str.length();
			int m = pattern.length();

			// create a DP lookup table
			boolean[][] T = new boolean[n+1][m+1];

			// if both pattern and String is empty : match
			T[0][0] = true;

			// handle empty String case (i == 0)
			for (int j = 1; j <= m; j++) {
				if (pattern.charAt(j - 1) == '*') {
					T[0][j] = T[0][j - 1];
				}
			}
			
			System.out.println( Arrays.deepToString(T));

			// build matrix in bottom-up manner
			for (int i = 1; i <= n; i++)
			{
				for (int j = 1; j <= m; j++)
				{
					if (pattern.charAt(j-1) == '*') {
						T[i][j] = T[i - 1][j] || T[i][j - 1];
					}
					else if (pattern.charAt(j-1) == '?' ||
							str.charAt(i-1) == pattern.charAt(j-1)) {
						T[i][j] = T[i - 1][j - 1];
					}
				}
			}
			
			System.out.println( Arrays.deepToString(T));

			// last cell stores the answer
			return T[n][m];
		}
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "aa";
		String p = "a?*";
	//	System.out.println(isMatching(s, p));
		System.out.println(isMatch(s, p));

	}

}
