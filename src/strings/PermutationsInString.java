package strings;

import java.util.HashMap;

public class PermutationsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print(findPermutation("oidcf", "dc"));

	}

	private static boolean findPermutation(String str, String pattern) {
		// TODO Auto-generated method stub
		int windowStart = 0, matched = 0;
		HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

		for (char chr : pattern.toCharArray()) {
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
		}

		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);

			if (charFrequencyMap.containsKey(rightChar)) {
				charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);

				if (charFrequencyMap.get(rightChar) == 0) {
					matched++;
				}

				if (matched == charFrequencyMap.size()) {
					return true;
				}

			}

			if (windowEnd >= pattern.length() - 1) {

				char leftChar = str.charAt(windowStart++);

				if (charFrequencyMap.containsKey(leftChar)) {
					if (charFrequencyMap.get(rightChar) == 0) {
						matched--;
					}

					charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
				}

			}

		}

		return false;

	}

}
