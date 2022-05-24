package dynamicprogramming;

public class Jump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array = {2,3,1,1,4};
		jump(array);

	}

	private static void jump(int[] nums) {
		// TODO Auto-generated method stub
		 int k = nums.length-1; 
		    int count = 0;
		    while (k!=0){
		        for (int i = 0;i<nums.length;i++){ /* in this loop we are checking if we find leftmost number from wehere we can reach end */
		            if (nums[i]>= k-i) { 
		                k = i;  /*if we find that place it becomes a subproblem of reaching to updated kth place instead of end */
		                count++;
		                System.out.println(nums[i] + "  " + k);
		                break;
		            }
		        }
		    }
		    
		    
		    System.out.println(count);
		//    return count;
	}

}
