package array;

import java.util.ArrayList;
import java.util.List;

public class Kadane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int maxSum[] = { -2, 3, 2 , -1};
		
		
		System.out.println(kadane(maxSum));

	}

	private static int kadane(int[] arys) {
		// TODO Auto-generated method stub
		int max_global= arys[0];
		int max_current = max_global;
	
		List<Integer> in = new ArrayList<Integer>();
		
		for(int i =1 ; i<arys.length; i++) {
			in.add(max_current + arys[i]);
			max_current = Math.max(arys[i] , (max_current + arys[i]));
			System.out.println(in);
			
			if(max_current> max_global) {
				max_global = max_current;
			}
			
		}
		
		
		
		
		return max_global;
	}

}
