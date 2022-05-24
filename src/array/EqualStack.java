package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class EqualStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> h1 = new ArrayList<Integer>();
		List<Integer> h2 = new ArrayList<Integer>();
		List<Integer> h3 = new ArrayList<Integer>();

		h1.add(3);
		h1.add(2);
		h1.add(1);
		h1.add(1);
		h1.add(1);

		h2.add(4);
		h2.add(3);
		h2.add(2);

		h3.add(1);
		h3.add(1);
		h3.add(4);
		h3.add(1);

		int result = equalStacks(h1, h2, h3);

		System.out.println(result);

	}

	private static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		// TODO Auto-generated method stub

		// CopyOnWriteArrayList c1 = new CopyOnWriteArrayList(h1);
		// CopyOnWriteArrayList c2 = new CopyOnWriteArrayList(h2);
		// CopyOnWriteArrayList c3 = new CopyOnWriteArrayList(h3);

		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();

		s1.addAll(reverse(h1));
		s2.addAll(reverse(h2));
		s3.addAll(reverse(h3));

		int sum1 = sum(h1);
		int sum2 = sum(h2);
		int sum3 = sum(h3);

		int i = 0, j = 0, k = 0;
		
		/*
		 * System.out.println(sum1); System.out.println(sum2); System.out.println(sum3);
		 */

		while (!(sum1 == sum2 && sum2 == sum3)) {

			if (sum1 > sum2 || sum1 > sum3) {
				// Decrement it
				while (sum1 > sum2 || sum1 > sum3)
					sum1 -= h1.get(i++);
			} else if (sum2 > sum1 || sum2 > sum3) {
				while (sum2 > sum1 || sum2 > sum3)
					sum2 -= h2.get(j++);
			} else if (sum3 > sum1 || sum3 > sum2) {
				while (sum3 > sum1 || sum3 > sum2)
					sum3 -= h3.get(k++);
			}

		}

		/*
		 * System.out.println(s1); System.out.println(s2); System.out.println(s3);
		 */

		return sum1;
	}

	private static List<? extends Integer> reverse(List<Integer> h) {
		// TODO Auto-generated method stub

		List<Integer> reverse = new ArrayList<Integer>();

		for (int i = h.size() - 1; i >= 0; i--) {
			reverse.add(h.get(i));

		}
		return reverse;
	}

	private static int sum(List<Integer> h) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i : h) {
			sum = sum + i;

		}

		return sum;

	}

}
