package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Solution {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs.length == 0)
			return res;
		HashMap<String, List<String>> map = new HashMap();
		for (String s : strs) {
		
			char[] hash = new char[26];
			for (char c : s.toCharArray()) {
				hash[c - 'a']++;
		//		System.out.println(hash[c - 'a']);
			}
					
			String str = new String(hash);
			
		//	System.out.println(hash.toString());
			
			if (map.get(str) == null) {
				map.put(str, new ArrayList<>());
			}
			map.get(str).add(s);
		}
		res.addAll(map.values());
		
		System.out.println(map);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] anagrams = { "eat", "tea", "tan", "ate", "nat", "bat" };
		
		groupAnagrams( anagrams);
	}
}