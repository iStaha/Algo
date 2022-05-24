package codility;
// you can also use imports, for example:

// import java.util.*;

import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
	public static int solution(int[] A, int k, int l) {
		// write your code in Java SE 8
		System.out.println(Arrays.toString(A));

		if (A.length < (k + l)) {
			return -1;
		}

		int one = 0, two = 0;

		for (int i = 0, j = i + k; i <= A.length - l && (j + l) <= A.length; i++) {
			System.out.println(i + "  " + (i + k) + " " + j + " " + (j + l));
			int sum1 = Arrays.stream(A, i, (i + k)).sum();
			int sum2 = Arrays.stream(A, j, j + l).sum();
			// System.out.println("sum-1 " + sum1);
			// System.out.println("sum-2 " + sum2);
			if (one < sum1)
				one = sum1;

			if (two < sum2)
				two = sum2;

			j = i + k;

		}

		// System.out.println("one-1 " + one);
		// System.out.println("two-2 " + two);

		return one + two;
	}

	public static int totalSum(int[] A, int sum , int k, int l, int i, int j) {
		// write your code in Java SE 8
		System.out.println(Arrays.toString(A));
		
	//	Arrays.sort(A);
	//	System.out.println(Arrays.toString(A));
	
		int x = i;

		if (A.length < (k + l)) {
			return -1;
		}	
		
		System.out.println(i+"            "+ j);

		
		int total = Arrays.stream(A, i, j).sum();
		
		 if(total>sum)
		 sum = total;
		 
		 x = ++i;
		int y = (x + k);
		int z = (y + l);
		
		

		if (x < A.length - l && y<= A.length-l) {
			return totalSum(A,sum, k, l, x, y) + totalSum(A,sum, k, l, y, z);
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 6, 1, 4, 6, 3, 2, 7, 4 };
		int K = 3, L = 2;
		
		
		int i =0;
		int j= i+K;
		int sum =-1;

		// long sum1 = Arrays.stream(arr, 0, 2).sum();

		// System.out.println(sum1);
		
		System.out.println(totalSum(arr, sum,  K, L, i, j));

	//	System.out.println(solution(arr, K, L));

	}
}
