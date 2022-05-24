package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class FIb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fib(5));

	}

	public static HashMap<Integer, Integer> hm = new HashMap<>();

	private static Integer fib(Integer i) {
		// TODO Auto-generated method stub

		if (hm.containsKey(i))
			return hm.get(i);

		if (i < 2)
			return  1;

		Integer nthValue = fib(i - 1) + fib(i - 2);

		hm.put(i, nthValue);

		return nthValue;

	}

}