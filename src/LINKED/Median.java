package LINKED;

public class Median {
	
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 
		 int siz =nums1.length + nums2.length;
		 
		 int[] combined = new int[siz];
		 
		 
		 for (int i =0; i<=nums1.length; i++ ) {
			 
			 if(nums1[i]<nums2[i]) {
				 combined[i] = nums1[i];
			 }
			 else {
				 combined[i] = nums2[i];
			 }
		 }
		 
		 
		 for(int m : combined) {
			 System.out.print(m);
		 }
		return 0;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub= 
		
		int [] one = {1, 2};
		int [] two = {3, 4};
		
		
		System.out.print(findMedianSortedArrays(one , two));

	}

}
