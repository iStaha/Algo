package array;

import java.util.Arrays;

public class ArrayMan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;

		int arr[][] = { { 2, 6, 8 }, { 3, 5, 7 }, { 1, 8, 1 }, { 5, 9, 15 } };

		System.out.println(arrayManipulation(n, arr));

	}

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int N, int[][] queries) {

		/*
		 * int nos[] = new int[n];
		 * 
		 * int max = -9999;
		 * 
		 * // System.out.println(queries.length);
		 * 
		 * int i =0;
		 * 
		 * while (i < queries.length) { int a = queries[i][0]; int b = queries[i][1];
		 * int k = queries[i][2];
		 * 
		 * // System.out.println(a + " " + b + " " + k);
		 * 
		 * 
		 * i++;
		 * 
		 * for (int j = a-1; j < b; j++) {
		 * 
		 * // if(j >= a && j<=a ) { nos[j]= Math.abs(nos[j]) + Math.abs(k);
		 * 
		 * if(nos[j]>max) { max = nos[j]; }
		 * 
		 * // } }
		 * 
		 * System.out.println(Arrays.toString(nos)); System.out.println(max);
		 * 
		 * 
		 * }
		 */

		int nos[] = new int[N+2];

		long max = Long.MIN_VALUE;

		// System.out.println(queries.length);

		int m = 0;

		while (m < queries.length) {
			int lo = queries[m][0];
			int hi = queries[m][1];
			int val = queries[m][2];

			nos[lo] += val;
			if (hi != N - 1)
				nos[hi + 1] -= val;

			

			m++;

		}
		
		for (int i = 1; i < N; i++) {
			nos[i] += nos[i - 1];
			max = Math.max(max, nos[i]);
		}

		return max;

	}

}
