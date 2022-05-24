package sorting;

import java.util.*;
import java.io.*;

class GFG {
	// Function returns the
	// minimum number of swaps
	// required to sort the array
	public static int minSwaps(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++)
			map.put(nums[i], i);

		Arrays.sort(nums);

		System.out.println(map);
		System.out.println(Arrays.toString(nums));

		// To keep track of visited elements. Initialize
		// all elements as not visited or false.
		boolean[] visited = new boolean[len];
		Arrays.fill(visited, false);

		// Initialize result
		int ans = 0;
		for (int i = 0; i < len; i++) {

			// already swapped and corrected or
			// already present at correct pos
			if (visited[i] || map.get(nums[i]) == i)
				continue;

			int j = i, cycle_size = 0;
			while (!visited[j]) {
				visited[j] = true;

				// move to next node
				j = map.get(nums[j]);
				cycle_size++;
			}

			// Update answer by adding current cycle.
			if (cycle_size > 0) {
				ans += (cycle_size - 1);
			}
		}

		System.out.println(Arrays.toString(visited));
		return ans;
	}

	// Return the minimum number
	// of swaps required to sort the array
	public int minSwaps(int[] arr, int N) {

		int ans = 0;
		int[] temp = Arrays.copyOfRange(arr, 0, N);

		// Hashmap which stores the
		// indexes of the input array
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

		Arrays.sort(temp);
		for (int i = 0; i < N; i++) {
			h.put(arr[i], i);
		}
		for (int i = 0; i < N; i++) {

			// This is checking whether
			// the current element is
			// at the right place or not
			if (arr[i] != temp[i]) {
				ans++;
				int init = arr[i];

				// If not, swap this element
				// with the index of the
				// element which should come here
				swap(arr, i, h.get(temp[i]));

				// Update the indexes in
				// the hashmap accordingly
				h.put(init, h.get(temp[i]));
				h.put(temp[i], i);
			}
		}
		return ans;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

// Driver class
class MinSwaps {
	// Driver program to test the above function
	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 3, 2 };
		GFG g = new GFG();
	//	System.out.println(g.minSwaps(a));
		
		int n = a.length;
        // Output will be 5
        System.out.println(g.minSwaps(a, n));
	}
}
// This code is contributed by Saurabh Johari
