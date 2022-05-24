import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum {

	public static int[] twoSum(int[] nums, int target) {

		 Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        map.put(nums[i], i);
		    }


		System.out.println(map);

		for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
		
		 throw new IllegalArgumentException("No two sum solution");

		//return ind;
	}
	
	public static int[] twoSums(int[] nums, int target) {
    	
        List<Integer> num = new ArrayList<Integer>();

		int[] ind = new int[2];

		for (int n : nums) {
			num.add(n);
		}


		for (int i = 0; i < nums.length; i++) {

			if (nums[i] <= target) {

				int left = target - nums[i];
				

				if (num.contains(left) && i != num.indexOf(left)) {
			
					ind[1] = num.indexOf(left);
					ind[0] = i;
					
					break;
				}

			}

		}

		
		return ind;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 0;

		int[] nums = {-3, 4, 3, 90 };
		
	
		/*
		 * for(int n : nums) { System.out.println(n); }
		 */

	//	twoSum(nums, target);

		for (int j : twoSums(nums, target)) {
			System.out.println(j);
		}

	}

}
