package codility;
// you can also use imports, for example:

// import java.util.*;

import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution3 {
	public static int solution(int[] A, int k, int l) {
		// write your code in Java SE 8
		System.out.println(Arrays.toString(A));

		if (A.length < (k + l)) {
			return -1;
		}
		
		
		int one = 0, two =0 ;
		 
		for(int i =0, j=i+k; i< A.length-2 && (i+k)<=A.length && (i+k+l)<=A.length  ;i++) {
	//		System.out.println(i+"  "+(i+k));
			int sum1 = Arrays.stream(A, i, (i+k)).sum();
			int sum2 = Arrays.stream(A, (i+k), i+k+l).sum();
			
		      
			System.out.println("s1   "+ sum1);
			System.out.println("s2   "+ sum2);
		
			if(one<sum1)
			one =sum1;
			if(two<sum2)
			two =sum2;
			
		}
		
		
		
		

		return one+two;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 6, 1, 4, 6, 3, 2, 7, 4 };
		int K = 3, L = 2;
		
	//	long sum1 = Arrays.stream(arr, 0, 2).sum();
		
	//	System.out.println(sum1);

		System.out.println(solution(arr, K, L));

	}
}


/*
 * for(int i =0, j=i+k; i< A.length-2 && (i+k)<=A.length && (i+k+l)<=A.length
 * ;i++) { // System.out.println(i+"  "+(i+k)); int sum1 = Arrays.stream(A, i,
 * (i+k)).sum(); int sum2 = Arrays.stream(A, (i+k), i+k+l).sum();
 * 
 * 
 * // System.out.println("s1   "+ sum1); // System.out.println("s2   "+ sum2);
 * // int sums = Math.max(sum, (sum1+sum2)); if(one<sum1) one =sum1;
 * if(two<sum2) two =sum2;
 * 
 * }
 */

