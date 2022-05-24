package pattern;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		permutations("", "abc");
	//	permutationsReplace("abc", 0, "abc".length() - 1);
		int[] nums = { 1, 2, 3 };
		// permute(nums);

//       ArrayList<String> ans = permutationsList("", "abc");
		// System.out.println(ans);

		// System.out.println(permutationsCount("", "abcd"));
	}

	private static void permutationsReplace(String string, int left, int right) {
		// TODO Auto-generated method stub
		if (left == right) {
			System.out.println(string);
		} else {
			for (int i = left; i <= right; i++) {
				String swapped = swap(string, left, i);
				permutationsReplace(swapped, left + 1, right);
			}
		}

	}

	private static String swap(String string, int left, int i) {
		// TODO Auto-generated method stub

		char temp;
		char[] charArray = string.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[left];
		charArray[left] = temp;

		return String.valueOf(charArray);
	}

	static void permutations(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);
		for (int i = 0; i <= p.length(); i++) {
			String f = p.substring(0, i);
			String s = p.substring(i, p.length());
	//		System.out.println(f + "   +++    " + ch + "   +++    " + s);
			permutations(f + ch + s, up.substring(1));
		}
	}

	static ArrayList<String> permutationsList(String p, String up) {
		if (up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		char ch = up.charAt(0);

		// local to this call
		ArrayList<String> ans = new ArrayList<>();

		for (int i = 0; i <= p.length(); i++) {
			String f = p.substring(0, i);
			String s = p.substring(i, p.length());
			ans.addAll(permutationsList(f + ch + s, up.substring(1)));
		}
		return ans;
	}

	static int permutationsCount(String p, String up) {
		if (up.isEmpty()) {
			return 1;
		}
		int count = 0;
		char ch = up.charAt(0);
		for (int i = 0; i <= p.length(); i++) {
			String f = p.substring(0, i);
			String s = p.substring(i, p.length());
			count = count + permutationsCount(f + ch + s, up.substring(1));
		}
		return count;
	}

	static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		permuteReamain(new ArrayList<>(), nums, used, result);
		System.out.println(result);
		return result;
	}

	public static void permuteReamain(List<Integer> composed, int[] nums, boolean[] used, List<List<Integer>> result) {
		// base case, stop
		if (composed.size() == nums.length) {
			result.add(composed);
			return;
		}

		// resursion
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}

			int number = nums[i];
			// add number
			composed.add(number);
			used[i] = true;
			// one more step
			permuteReamain(new ArrayList<>(composed), nums, used, result);
			// remove number
			composed.remove(composed.size() - 1);
			used[i] = false;
		}
	}

}