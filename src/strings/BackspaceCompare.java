package strings;

import java.util.Stack;

class BackspaceCompare {
	
	
	 public static boolean backspaceCompareUsingStack(String S, String T) {
	        return build(S).equals(build(T));
	    }

	    public static String build(String S) {
	        Stack<Character> ans = new Stack();
	        for (char c: S.toCharArray()) {
	            if (c != '#')
	                ans.push(c);
	            else if (!ans.empty())
	                ans.pop();
	        }
	        return String.valueOf(ans);
	    }
	
	
	public static boolean backspaceCompare(String s, String t) {

		StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        
        if(s == null || t == null) return false;
        
        for(char t1 : s.toCharArray()) {
            if(t1 != '#') {
                first.append(t1);
            }
            else if(first.length() > 0) {
                first.setLength(first.length() - 1);
            }
        }
        
        for(char t1 : t.toCharArray()) {
            if(t1 != '#') {
                second.append(t1);
            }
            else if(second.length() > 0) {
                second.setLength(second.length() - 1);
            }
        }
        
        s = first.toString();
        t = second.toString();
        
        if(s.length() != t.length() || !s.equals(t)) {
            return false;
        }
        
        return true;

	}

	public static void main(String[] args) {
		String s = "ab##";
		String t = "c#d#";
	
		System.out.println(backspaceCompare(s, t));
		
		System.out.println(backspaceCompareUsingStack(s, t));
	}
}