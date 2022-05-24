import java.util.Scanner;

public class EOF {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t = scanner.nextInt();

		scanner.skip("[\r\n]+");

		for (int i = 1; i <= t; i++) {

			System.out.println(i+ " " + scanner.nextLine());

		}

	}

}
