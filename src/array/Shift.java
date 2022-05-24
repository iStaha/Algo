package array;

import java.util.Arrays;
import java.util.Scanner;

public class Shift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int list[] = {1, 2, 3, 4, 5, 6, 7  };
		int no = 3;

		Scanner scan = new Scanner(System.in);
		int n = list.length;
		int d = no;
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
	//		System.out.print((i + n - d) % n + " >> ");
			array[(i + n - d) % n] = list[i];
		}
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}

	  //   System.out.print(Arrays.toString(shift(list , 2)));

	}

	private static int[] shift(int[] list, int n) {
		// TODO Auto-generated method stub

		for (int i = 0; i < list.length; i++) {
			int j = (i + n);
			if (j < list.length)
				list[i] = list[i + n];

		}

		for (int k = list.length - n, s = 1; k < list.length; k++, s++) {
			if (k < list.length) {
				list[k] = s;
			}
		}

		return list;
	}

}
