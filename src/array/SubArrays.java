package array;

import java.util.Scanner;

public class SubArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t;

		String s = null;

		Scanner scan = new Scanner(System.in);

		t = scan.nextInt();

		String nArr[] = new String[t];

		for (int i = 0; i < t; i++) {

			nArr[i] = scan.next();
		}

		for (int i = 0; i < t; i++) {

			s = nArr[i];

			while (s.length() != 0) {

				if (s.contains("11")) {
					s = s.replace("11", "");
				} else if (s.contains("00")) {
					s = s.replace("00", "");
				}

				else {
					break;
				}

			}

			if (s.length() == 0) {
				System.out.println("Khali");
			} else {
				System.out.println(s);
			}

		}

	}

}
