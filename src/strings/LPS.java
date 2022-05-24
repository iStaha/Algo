package strings;

import java.util.HashMap;

class LPS {

	public int findLPSLength(String st) {
		// return findLPSLengthRecursive(st, 0, st.length() - 1);
		Integer[][] dp = new Integer[st.length()][st.length()];
		return findLPSLengthMemoization(st, 0, st.length() - 1, dp);
	}

	private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return 0;

		// every string with one character is a palindrome
		if (startIndex == endIndex)
			return 1;

		// case 1: elements at the beginning and the end are the same
		if (st.charAt(startIndex) == st.charAt(endIndex)) {
			int remainingLength = endIndex - startIndex - 1;
			// check if the remaining string is also a palindrome
			if (remainingLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1))
				return remainingLength + 2;
		}

		// case 2: skip one character either from the beginning or the end
		int c1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
		int c2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
		return Math.max(c1, c2);
	}

	private int findLPSLengthMemoization(String st, int startIndex, int endIndex, Integer[][] dp) {
		if (startIndex > endIndex)
			return 0;

		// every string with one character is a palindrome
		if (startIndex == endIndex)
			return 1;

		if (dp[startIndex][endIndex] == null) {

			// case 1: elements at the beginning and the end are the same
			if (st.charAt(startIndex) == st.charAt(endIndex)) {
				int remainingLength = endIndex - startIndex - 1;
				// check if the remaining string is also a palindrome
				if (remainingLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1))
					return remainingLength + 2;
			}

			// case 2: skip one character either from the beginning or the end
			int c1 = findLPSLengthMemoization(st, startIndex + 1, endIndex, dp);
			int c2 = findLPSLengthMemoization(st, startIndex, endIndex - 1, dp);

			dp[startIndex][endIndex] = Math.max(c1, c2);
		}

		return dp[startIndex][endIndex];
	}

	public static void main(String[] args) {
		LPS lps = new LPS();
		System.out.println(lps.findLPSLength("abdbca"));
		System.out.println(lps.findLPSLength("cddpd"));
		System.out.println(lps.findLPSLength("pqr"));
	}
}