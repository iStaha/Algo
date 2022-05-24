import java.util.Arrays;

public class MinSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sort[] = { 2, 3, 4, 1, 5 };

		minimumSwap(sort);

		System.out.println(Arrays.toString(sort));

	}

	private static void minimumSwap(int[] sort) {
		// TODO Auto-generated method stub
		int swaps = 0, i = 0;

		for (i = 0; i < sort.length - 1; i++) {

			if (sort[i] == i + 1) {
				System.out.print(sort[i]+ " ");
				continue;
			}

			int temp = sort[sort[i] - 1];
			sort[sort[i] - 1] = sort[i];
			sort[i] = temp;

			System.out.println(Arrays.toString(sort));
			swaps++;
			i--;

		}

		System.out.println(swaps);

	}

}
