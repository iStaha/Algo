import java.util.Arrays;

public class MinSum {

	static int minimumAbsoluteDifference(int[] arr) {

		 Arrays.sort(arr);
		
		 System.out.println(Arrays.toString(arr));
		
		int minimumDifference = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length - 1; i++) {
		    int difference = Math.abs(arr[i + 1] - arr[i]);
		    
		  //  System.out.println(arr[i + 1] + " " + arr[i] );
		    
		    if (difference < minimumDifference) {
		        minimumDifference = difference;
		        
		        if (minimumDifference == 0) {
		            return 0;
		        }
		    }
		}

		return minimumDifference;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sort[] = { -59 , -36 ,  -13 ,  1 , -53 , -92 , -2 , -96 , -54 , 75 };

		System.out.println(minimumAbsoluteDifference(sort));

	}

}
