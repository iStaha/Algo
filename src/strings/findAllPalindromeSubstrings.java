package strings;

public class findAllPalindromeSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabbbaa";
		int count = findAllPalindromeSubstrings(str);
		System.out.println("Total palindrome substrings: " + count);
	}

	private static int findAllPalindromeSubstrings(String str) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		for(int i =0; i< str.length(); i++) {
			count += findAllPalindromeSubstrings(str, i-1, i+1);
			count += findAllPalindromeSubstrings(str, i, i+1);
		}
		
		return count;
	}

	private static int findAllPalindromeSubstrings(String str, int left, int right) {
		// TODO Auto-generated method stub
		
		
		int count =0;
		
		
		for(;left>=0 && right < str.length(); --left, ++right) {
			if(str.charAt(left) != str.charAt(right)) {
				break;
			}
			System.out.println(str.substring(left, right+1));
		     count++;
		}
		
		
		return count;
	}

}
