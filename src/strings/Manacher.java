package strings;

public class Manacher {

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromMiddle(s, i, i);
			int len2 = expandFromMiddle(s, i, i + 1);

	
			int len = Math.max(len1, len2);

			if (len > end - start) {
				// System.out.println(i + " " + (end-start) + " " + (len) );
				start = i - ((len - 1) / 2);
				end = i + (len / 2);
			}

		}

		return s.substring(start, end + 1);
	}

	private static int expandFromMiddle(String s, int left, int right) {
		// TODO Auto-generated method stub
		if (s == null || left > right)
			return 0;

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return right - left - 1;
	}
	
	 public static String longestPalindrome(String s) {
	        int strLength = s.length();
	        if (strLength < 2) {
	            return s;
	        }
	        int resultLength = 0;
	        String result = "";
	        for (int i =0; i< s.length(); i++) {
	            // Odd length
	            int l = i, r = i;
	            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
	                if ((r - l + 1) > resultLength) {
	                    result = s.substring(l,r+1);
	                    resultLength = r - l + 1;
	                }
	                l -= 1;
	                r += 1;
	            }

	            // Even length
	            l = i;
	            r = i + 1;
	            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
	                if ((r - l + 1) > resultLength) {
	                    result = s.substring(l,r+1);
	                    resultLength = r - l + 1;
	                }
	                l -= 1;
	                r += 1;
	            }
	        }
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "MADDAM";
		System.out.println("Length is: " + longestPalindrome(str));
	}

}
