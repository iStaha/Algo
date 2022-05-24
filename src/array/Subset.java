package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subset {

	public static void main(String... d) {

		int nums[] = { 1, 2, 2 };
		List<Integer> o = new ArrayList<>();

		subsetsWithDup(o, nums);
	}

//	 static List<List<Integer>> list =  new ArrayList<>(); 

	// static List<Integer> o = new ArrayList<>();

	public static List<Integer> subsetsWithDup(List<Integer> o, int[] nums) {

		if (nums.length == 0) {
			System.out.println(o);
			List<Integer> list = new ArrayList<>();
			list.addAll(o);
			return list;
		}

		int element = nums[0];

		int newArray[] = Arrays.copyOfRange(nums, 1, nums.length);
		/// System.out.print(Arrays.toString(newArray));

		o.add(element);

		List<Integer> left = subsetsWithDup(new ArrayList<>(o), newArray);

		List<Integer> right = subsetsWithDup(new ArrayList<>(), newArray);

		left.addAll(right);

		return left;

	}
}