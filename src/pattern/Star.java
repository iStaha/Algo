package pattern;

public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    diamond(5);
		rectangle(10);
		triangle(10);

	}

	private static void triangle(int n) {
		// TODO Auto-generated method stub
		
		for (int rows = 0; rows <   n; rows++) {

			int totalColsInRow = rows > n ?  n - rows : rows;

			int noOfSpaces = n - totalColsInRow;

			for (int s = 0; s < noOfSpaces; s++) {
				System.out.print(" ");
			}

			for (int col = 0; col < totalColsInRow; col++) {
				System.out.print("* ");
			}

			System.out.println("");

		}
		
	}

	private static void rectangle(int n) {
		// TODO Auto-generated method stub

		for (int rows = 0; rows < n; rows++) {

			for (int col = 0; col < n; col++) {

				if (rows == 0 || rows == n - 1) {
				//	System.out.print("ROWS " + rows);
					System.out.print("*");
				} else {
					if(col ==0  || col == n-1) {
					//	System.out.print(col);
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}

			System.out.println("");

		}

	}

	private static void diamond(int n) {
		// TODO Auto-generated method stub
		for (int rows = 0; rows < 2 * n; rows++) {

			int totalColsInRow = rows > n ? 2 * n - rows : rows;

			int noOfSpaces = n - totalColsInRow;

			for (int s = 0; s < noOfSpaces; s++) {
				System.out.print(" ");
			}

			for (int col = 0; col < totalColsInRow; col++) {
				System.out.print("* ");
			}

			System.out.println("");

		}

	}

}
