
public class Que {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int bribes = 0;

		for (int i = q.length - 1; i >= 0; i--) {
			if ((q[i] - (i + 1)) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			for (int j = Math.max(0, q[i] - 2); j < i; j++) {

				if (q[j] > q[i])
					bribes++;
			}
		}

		if (bribes > 1) {
			System.out.println(bribes);
		}

	}

	// 2 1 5 3 4 ==> 1 1 2 1 1

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 2 3 4 5 2 1 2 2 1 4 // 1, 2, 5, 3, 7, 8, 6, 4 // 2 , 1 , 5 , 3 , 4
		int sort[] = { 2 , 1 , 5 , 3 , 4 };

		minimumBribes(sort);

	}

}
