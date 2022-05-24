package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groupAnagramList = new ArrayList<>();
		HashMap<String, List<String>> hashmap = new HashMap<>();
		
		for(String word: strs) {
			char[] wordChars = word.toCharArray();
			Arrays.sort(wordChars);
			
			String sortedWord = String.valueOf(wordChars);
			
			hashmap.putIfAbsent(sortedWord, new ArrayList<>());
			
			hashmap.get(sortedWord).add(word);
			
			/*
			 * if(hashmap.containsKey(sortedWord)) {
			 * 
			 * List<String> currlist = hashmap.get(sortedWord);
			 * 
			 * currlist.add(word);
			 * 
			 * hashmap.put(sortedWord , currlist);
			 * 
			 * }else { List<String> wordList = new ArrayList<>();
			 * 
			 * wordList.add(word);
			 * 
			 * hashmap.put(sortedWord, wordList); }
			 */
			
		}
		
		for(String collect:   hashmap.keySet()) {
			groupAnagramList.add(hashmap.get(collect));
		}
		
		
		System.out.println(groupAnagramList);
		
		return new ArrayList<>(hashmap.values());

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] anagrams = {"eat","tea","tan","ate","nat","bat"};

		groupAnagrams(anagrams);
	}

}
