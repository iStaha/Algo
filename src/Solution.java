

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
	
    public int[] SlidingsWindow(int[] nums, int k) {
        
    	
    	System.out.println("HERE");
    	

  	  // validate the inputs;
          if (nums == null || nums.length == 0 || k <= 0 || k > nums.length){
              return new int[]{};
          }
          // define the size of the result array
          int[] result = new int[nums.length - k + 1];
          int ri = 0;
          // use a monotonic decreasing queue to find the local maximum
          // for each k sized subarray
          // the item in this queue will be represented by their index;
          // so we can use the index to check whether its in the current k-sized
          // subarray;
          LinkedList<Integer> mdq = new LinkedList<>();
          
          
          for (int i = 0; i < nums.length; i++){
              // pop the first elment if its out of bound
              if (!mdq.isEmpty() && mdq.peek() < i - k + 1){
                  mdq.poll();
              }
              
              // keep comparing the current number to the last item of the queue
              // pop the last item if it is less than the current number
              while (!mdq.isEmpty() && nums[mdq.peekLast()] < nums[i]){
                  mdq.pollLast();
              }
              // we now have the correct spot to add the current 
              mdq.offer(i);
              
              // record the local maximum for each k sized subarray
              if (i >= k - 1){
                  result[ri++] = nums[mdq.peek()];
              }
          }
          
          System.out.println(Arrays.toString(result));
          return result;
          
        
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Solution sol = new Solution();

    	int[] nums = {1,3,-1,-3,5,3,6,7 };
    	int k = 1;

    	//

		sol.SlidingsWindow(nums, k);

	}
    
    

}