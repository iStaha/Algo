package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Overlap {

	public static int[][] merge(int[][] intervals) {

	//	System.out.println(intervals.length);

		int len = intervals.length;

		

		if (intervals.length <= 1) {		 
			return intervals;		
			
		}

		Arrays.sort(intervals, (arr1, arr2) ->  Integer.compare(arr1[0], arr2[0]));
		
		List<int[]> inter = new ArrayList<>();
		
		int[] current_interval  = intervals[0];
		
		inter.add(current_interval);
		
		
		
		for(int [] interval : intervals) {
	//		System.out.println(interval[0]+ " " + interval[1]);
			int current_begin = current_interval[0];
			int current_end = current_interval[1];
			int next_begin = interval[0];
			int next_end = interval[1];
			
	//		System.out.println(current_begin + " " + current_end);
	//		System.out.println(next_begin + " " + next_end);
			
			if(current_end >= next_begin) {
				current_interval[1] = Math.max(current_end, next_end);
			}
			else {
				current_interval = interval;
				inter.add(current_interval);
			}
			
		}
		
		return inter.toArray(new int[inter.size()][]);

		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inter[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
	//	int inter[][] = { { 1, 4 }, { 2, 3 } };

		
	//	System.out.print(merge(inter));
		
		for(int [] interval : merge(inter))
			System.out.println(interval[0]+ " " + interval[1]);

	}

}
