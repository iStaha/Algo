package array;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 0;

		for (int i = 2; i < 10; i++) {

			count += countPrimes(i);
			// System.out.println(countPrimes(i));
		}
		// System.out.println(count);
		
		int n =4999;

		System.out.println(recursionCountPrime(--n));

	}

	private static int recursionCountPrime(int n) {
		// TODO Auto-generated method stub

		int count = 0;
		

		boolean bool = true;

		if (n == 0 || n == 1) {
			return 0;
		}

		for (int i = 2; i < n; i++) {

			if (n == i) {
				count++;
			}

			if (n % i == 0) {
				bool = false;
				break;
			}
		}

		if (bool)
			return 1 + recursionCountPrime(--n);
		
		
		return recursionCountPrime(--n);

	}

	public static int countPrimes(int n) {

		int count = 0;

		if (n == 0 || n == 1) {
			return 0;
		}

		for (int i = 2; i < n; i++) {

			if (n == i) {
				return 1;
			}

			if (n % i == 0) {
				return 0;
			}
		}

		count++;

		return count;

	}

}
