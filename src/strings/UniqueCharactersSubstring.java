package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// LeetCode 828. Count Unique Characters of All Substrings of a Given String

public class UniqueCharactersSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		uniqueLetterSubstring("ABC");
		
		
	}

	private static void uniqueLetterSubstring(String string) {
		// TODO Auto-generated method stub
		
		HashMap<Character, List<Integer>> all_indexes = new HashMap<>();
		
		for(int i =0; i<string.length();++i)
		all_indexes.computeIfAbsent(string.charAt(i), key -> new ArrayList<>()).add(i);
		
		int sum = 0;
		for(List<Integer>  indexes : all_indexes.values() ) {
			for(int j=0; j<indexes.size(); j++) {
				int left = j == 0 ?  indexes.get(j) + 1 : indexes.get(j) -indexes.get(j - 1);
				int right = j == indexes.size()-1  ? string.length() - indexes.get(j) : indexes.get(j+1)- indexes.get(j); 
				
				sum += left * right;
				
				
			}
		}
		
		System.out.print(sum);
		
	}

}
