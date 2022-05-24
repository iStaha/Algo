package slidingwindows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MaxSlidingWindow {

	public int[] maxSlidingWindw(int[] nums, int k) {

		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < k; i++) {
			map.put(nums[i], i);
			que.offer(nums[i]);
		}

		int[] res = new int[n - k + 1];
		res[0] = que.peek();

		int max = Integer.MIN_VALUE;
		for (int i = k; i < n; i++) {
			int num = nums[i];
			while (!que.isEmpty() && map.get(que.peek()) <= i - k) {
				que.poll();
			}
			if (!que.isEmpty()) {
				max = que.peek();
			}

			res[i - k + 1] = Math.max(max, num);
			map.put(num, i);
			que.offer(num);
		}
		return res;
	}

	public int[] maxSlidingWindows(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count++;
			System.out.println(i + " " + "" + nums[i] + " " + dq + " " + list + " " + count);
			// If the current element is greater than the last inserted element in the deque
			// then remove the smaller elements in the deque from last
			while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
				// System.out.println(i + " " + nums[i]+ " " + nums[dq.peekLast()] +" "+ dq +"
				// "+ list);
				dq.removeLast();
			}
			// add the current element to the deque
			dq.add(i);
			// remove the elements from the front if the dont fall under the current window
			while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
				System.out.println("sdsd");
				dq.removeFirst();
			}
			if (count == k) { // if the count of iterated elements are same as the window size
				// System.out.println(nums[dq.peekFirst()]+ " " + dq);
				list.add(nums[dq.peekFirst()]);
				count--;
			}
		}
		// convert list to int array
		return list.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxSlidingWindow mSWind = new MaxSlidingWindow();

		int[] nums = { 5, 3, 4 };
		int k = 1;

		//

		System.out.println(Arrays.toString(mSWind.maxSlidingWindow(nums, k)));

	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		List<Integer> ints = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int max = Integer.MIN_VALUE;

		
		for (int i = 0; i <= nums.length && i <= (i + k) && (i + k) <= nums.length; i++) {

			// long max = Arrays.stream(nums, i, i+k).sum();
	

			 max = Arrays.stream(nums, i, i + k).max().getAsInt();
			
			 
			 System.out.println(i + " " + (i + k - 2) + " " + (i + k - 1) + " " + max);
			 
			 ints.add(max);

			}
		

		

		nums = ints.stream().mapToInt(i -> i).toArray();
		return nums;

	}

}
