package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	static boolean find3Numbers(int A[], int arr_size, int sum) {
		int l, r;

		Set<List<Integer>> hash_Set = new HashSet<List<Integer>>();

		List<Integer> setList;

		/* Sort the elements */
		Arrays.sort(A);
		
		System.out.println(Arrays.toString(A));

		/*
		 * Now fix the first element one by one and find the other two elements
		 */
		for (int i = 0; i < arr_size - 2; i++) {

			// To find the other two elements, start two index variables
			// from two corners of the array and move them toward each
			// other
			l = i + 1; // index of the first element in the remaining elements
			r = arr_size - 1; // index of the last element
			while (l < r) {
				if (A[i] + A[l] + A[r] == sum) {
					setList = new ArrayList<Integer>();

				//	System.out.println("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);

					setList.add(A[i]);

					setList.add(A[l]);

					setList.add(A[r]);

					hash_Set.add(setList);

					l++;
					r--;

				} else if (A[i] + A[l] + A[r] < sum) 
					l++;
				  else // if (A[i] + A[l] + A[r] > sum)
					r--;
			}
		}

		// If we reach here, then no triplet was found

		System.out.println(hash_Set);

		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = { -2, 0, 1, 1, 2 };
		int sum = 0;
		int arr_size = A.length;

		find3Numbers(A, arr_size, sum);

	}

}
