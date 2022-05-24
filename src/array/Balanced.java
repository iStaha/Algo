package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Balanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String bal = "()[]{}{";

		System.out.println(isValids(bal));

	}
	
	
	public static String isValids(String s) {
		int n = -1;
		while (s.length() != n) {
			n = s.length();
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}
		if (s.length() == 0)
			return "YES";
		else 
			return "NO";

	}
 
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	

}
