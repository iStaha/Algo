package strings;

// Java program for the above approach
import java.io.*;
import java.util.*;

class GFG {

	public static String removeKdigits(String num, int k) {
		LinkedList<Character> stack = new LinkedList<Character>();
        
	    for(char digit : num.toCharArray()) {
	      while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
	        stack.removeLast();
	        k -= 1;
	      }
	      stack.addLast(digit);
	    }
	        
	    /* remove the remaining digits from the tail. */
	    for(int i=0; i<k; ++i) {
	      stack.removeLast();
	    }
	        
	    // build the final string, while removing the leading zeros.
	    StringBuilder ret = new StringBuilder();
	    boolean leadingZero = true;
	    for(char digit: stack) {
	      if(leadingZero && digit == '0') continue;
	      leadingZero = false;
	      ret.append(digit);
	    }
	        
	    /* return the final string  */
	    if (ret.length() == 0) return "0";
	    return ret.toString();

	}

	// Driver Code
	public static void main(String[] args) {
		String s = "765028321";
		int k = 5;
		System.out.println(removeKdigits(s, 5));
	}
}
// this code is contributed by gireeshgudaparthi
