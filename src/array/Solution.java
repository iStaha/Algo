package array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {

		int no = (int) Math.pow(arr.length - 2, arr.length - 2);

		int sum = 0;

		for (int x = 0; x < arr.length - 2; x++) {
			for (int y = 0; y < arr.length - 2; y++) {

				int sums =0;
			/*	int count = 1, sums = 0;
                  
				int xceil = y +3;
				int yceil = x +3;
				for (int j = x; j < yceil; j++) {
					for (int k = y; k < xceil; k++) {*/
				////		if (count != 4 && count != 6) {
					//		System.out.println(j +  " " + k + " :  ");
				//			System.out.println("count-->> " + count);
				//				System.out.println("value-->" +arr[j][k] + " ");
				sums = sums + arr[x][y]+arr[x][y+1]+arr[x][y+2]+arr[x+1][y+1]+arr[x+2][y]+arr[x+2][y+1]+arr[x+2][y+2];
						
							
				//		}
				//		count++;
				//	}

				//}
				
				
				
				

				
				 if (sum <= sums) { sum = sums; }
				 

			}
		}

		return sum;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int arr[][] = { { 1, 1, 1, 0, 0 , 0 }, 
				       { 0, 1, 0, 0  , 0 , 0 }, 
				       { 1, 1, 1, 0, 0 , 0 }, 
				       { 0, 0, 2, 4 , 4, 0 } ,
				       { 0, 0, 0, 2 , 0, 0 } ,
				       { 0, 0, 1, 2 , 4, 0 } 
				       
		};

		/*
		 * for (int i = 0; i < 6; i++) { String[] arrRowItems =
		 * scanner.nextLine().split(" ");
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * for (int j = 0; j < 6; j++) { int arrItem = Integer.parseInt(arrRowItems[j]);
		 * arr[i][j] = arrItem; } }
		 */

		int result = hourglassSum(arr);
		
		System.out.print(result);

//		bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}
}
