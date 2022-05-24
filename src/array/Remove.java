package array;

import java.util.Arrays;

class Remove {

	public static void main(String... d) {

		int nums[] = { 3, 2, 2, 3 };

		int val = 3;

		removeElement(nums, val);
	}

	public static int removeElement(int[] nums, int val) {

		int i = 0;
		int j = nums.length;

		while (i < j) {
			if (nums[i] != val) {
				i++;
			} else if (nums[i] == val && nums[i] != nums[j - 1]) {
			
				int element = nums[i];
				nums[i] = nums[j - 1];
				nums[j - 1] = element;
				j--;
				i++;
			} else {
				j--;
			}
		}

		
		return i-1;

	}
}