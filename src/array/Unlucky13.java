package array;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unlucky13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t = 2;

		int nArr[] = { 8, 2 };

		for (int j = 0; j < t; j++) {
			
			int N = nArr[j];

			int with13 = (int) Math.pow(10, N);
			
		//	System.out.println(with13);

		//	String without13 = Double.toString(Math.pow(10, 2) - 1);

			long count = 0;

		//	 System.out.println(findCount("1312"));

			for (int i = 0; i <= with13; i++) {

				String s = Integer.toString(i);

				// System.out.println(s);
				count = count + findCount(s);

			}

			int c = (int) (with13 - count);
			System.out.println(c);

		}

	}

	private static long findCount(String s) {
		// TODO Auto-generated method stub

		String string = s;

		long count = 0;

		
		//	while (s.length() != 0) {
				if (s.contains("13")) {
			//	s = s.replaceFirst("13", "");
		//		 System.out.println(">>" + s);
				count++;
			}
		//		else {
		//			break;
		//		}
	//	}

		return count;

	}

}
