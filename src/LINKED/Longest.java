package LINKED;

import java.util.ArrayList;
import java.util.List;

public class Longest {

	public static int lengthOfLongestSubstring(String s) {

		char[] arr = s.toCharArray();

		List<Character> lisArr = null;

		
		int len = 0;
		
		for (int m = 0; m < arr.length; m++) {
			lisArr = new ArrayList<Character>();
			for (int k = m; k < arr.length; k++) {
				if (!lisArr.contains(arr[k])) {
					lisArr.add(arr[k]);
							
				}
				else {
					break;
				}
			}
			if(len<lisArr.size()) {
				len = lisArr.size();
			}	
		}

		return len;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "pwwkew";

		System.out.print(lengthOfLongestSubstring(s));

	}

}
