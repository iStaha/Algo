package codility;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution2 {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int minOperations = 0;
        for(int i = 0, j = 0; i < A.length; i = j) {
        while (j < A.length && A[i] == A[j]) j++;
        System.out.println("j  " + j);
        int frequency = j - i;
        System.out.println("freq  " + frequency);
        minOperations += Math.min(Math.abs(A[i] - frequency), frequency);
        System.out.println("Op  " + minOperations);
    }
    return minOperations;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 1, 3, 4, 4, 4 };

		System.out.println( solution(arr));

	}
}
