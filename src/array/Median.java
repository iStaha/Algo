package array;

import java.util.Arrays;

public class Median {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		
		Median med = new Median();
		
		int one[] = {1, 3};
		int two[] = {2, 4};
		
		System.out.println(Arrays.toString(med.merge(one, two)));
		
		int merged[] = med.merge(one, two);
		
		int median;
		
		if(merged.length%2 == 0) {
		 
			int f=  (merged.length-1)/2;
			int s = f+1;
			
			median = (merged[f]+ merged[s])/2;
	
		
		} else {
			int s=  (merged.length-1)/2;

			
			median = merged[s];
		}

	}

	private int[] merge(int[] one, int[] two) {
		// TODO Auto-generated method stub
		
		int temp[] = new int[one.length + two.length ];
		
		int x=0, y=0, k=0;
		
		while(x<one.length && y<two.length ) {
			if(one[x] < two[y] ) {
				temp[k] = one[x];
				k++; x++;
			}
			else {
				temp[k] = two[y];
				k += 1; y += 1;
			}
			
			
		}
		
		
		// add elements left in the first interval 
				while(x <one.length) {
					temp[k] = one[x];
					k += 1; x += 1;
				}

				// add elements left in the second interval 
				while(y < two.length) {
					temp[k] = two[y];
					k += 1; y += 1;
				}

			
				
				return temp;
		
		
		
	}

	

}
