package searching;

public class Ceiling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 4, 6, 10 };
		int key = 6;
		System.out.println(serchCeilingNumber(array, key));

		System.out.println(serchFloorNumber(array, key));

	}

	private static int serchFloorNumber(int[] array, int key) {
		// TODO Auto-generated method stub

		if (key < array[0]) {
			return -1;
		}

		int start = 0, end = array.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (key < array[mid]) {
				end = mid - 1;
			} else if (key > array[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}

		}

		return end;
	}

	private static int serchCeilingNumber(int[] array, int key) {
		// TODO Auto-generated method stub

		if (key > array[array.length - 1]) {
			return -1;
		}

		int start = 0, end = array.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (key < array[mid]) {
				end = mid - 1;
			} else if (key > array[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}

		}
		return start;

	}

}
