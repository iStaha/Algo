package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

	static boolean hasArrayTwoCandidates(int A[], int arr_size, int sum) {
		int l, r;

		/* Sort the elements */

		Arrays.sort(A);

		System.out.println(Arrays.toString(A));

		/*
		 * Now look for the two candidates in the sorted array
		 */
		l = 0;
		r = arr_size - 1;
		while (l < r) {
			if (A[l] + A[r] == sum) {
				System.out.println(l + " " + r);
				return true;
			} else if (A[l] + A[r] < sum)
				l++;
			else // A[i] + A[j] > sum
				r--;
		}

		return false;
	}

	static void printpairs(int arr[], int sum) {
		HashSet<Integer> s = new HashSet<Integer>();
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (s.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			s.add(arr[i]);
		}
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> hash = new HashMap<>();
		
		for(int i = 0; i<numbers.length; i++) {
			int required = target - numbers[i];
			if(hash.containsKey(required)) {
				return new int [] {hash.get(required), i};
			}
			hash.put(numbers[i], i);
		}
		
		return null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = { 1, 4, 45, 6, 10, -8 };
		int n = 16;
		int arr_size = A.length;

		// Function calling
		if (hasArrayTwoCandidates(A, arr_size, n))
			System.out.println("Array has two " + "elements with given sum");
		else
			System.out.println("Array doesn't have " + "two elements with given sum");
		
		
		
		printpairs(A, n);
		
		System.out.println( Arrays.toString(twoSum(A, 16)));

	}

}

