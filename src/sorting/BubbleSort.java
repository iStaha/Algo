package sorting;

import java.util.Arrays;

public class BubbleSort {

	static void bubbleSort(int array[], int i) {

		// not letting i go below zero returning it when it happens so you can stop the
		// recursion.

		if (i < 0) {
			return;
		}

		// this loop continues to comparing the elements two at a time making sure one
		// element is sorted. Highest element will end up at the end.

		for (int x = 0; x < i; x++) {
			int y = x + 1;
			if (y < i && !(array[x] < array[y])) {
				int swap = array[x];
				array[x] = array[y];
				array[y] = swap;
			}

		}

		// reducing the array size by one, as the last element is already sorted.

		bubbleSort(array, --i);

	}

	static void selectionSort(int array[], int i) {

		// not letting i go below zero returning it when it happens so you can stop the
		// recursion.

		if (i == 0) {
			return;
		}

//		System.out.println("i" + i);

		// the idea is to find the positionof a may or min element and then Swap i t.
		// Now Repeat the process recursively. Ri t. Now Repeat the process recursively.
		int max = 0, x = 0;

		for (x = 0; x < i; x++) {
			int y = x + 1;
			if (y < i && !(array[max] > array[y])) {
				max = y;
			}

		}

		int swap = array[max];
		array[max] = array[i - 1];
		array[i - 1] = swap;

		System.out.println(max);

		// reducing the array size by one, as the last element is already sorted.

		selectionSort(array, --i);

	}

	static void insertionSort(int array[], int i) {

		// not letting i go below zero returning it when it happens so you can stop the
		// recursion.

		if (i >= array.length) {
			return;
		}

		// Comparing element one by one with the elements that come before it and
		// expanding the array.

		int y = i;

		for (int x = 0; x < y; x++) {
			if ((array[y] < array[x])) {
				int swap = array[x];
				array[x] = array[y];
				array[y] = swap;
			}

		}

		// reducing the array size by one, as the last element is already sorted.

		insertionSort(array, ++y);

	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 3, 7, 9, 10, 6, 5, 12, 4, 11, 2 };
		int n = arr.length;

		// printArray(arr);
		// bubbleSort(arr, n);

		// System.out.println("sorted array via Bubble Sort");
		// printArray(arr);

		// selectionSort(arr, n);

		// System.out.println("sorted array via Selection Sort");
		// printArray(arr);

		// insertionSort(arr, 0);

		// System.out.println("sorted array via Insertion Sort");
		// printArray(arr);

		// cyclciSort(arr, n);

		// System.out.println("sorted array via Insertion Sort");
		// printArray(arr);

		// quickSorts(arr, 0, n - 1);

		quiSorts(arr, 0, n - 1);

		System.out.println("sorted array via Quick Sort");
		printArray(arr);
	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub

		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		System.out.println("Pivot  " + pivot);

		int i = low, j = high;

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}
			System.out.println("o " + i + " " + j + " " + Arrays.toString(arr));

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}

			// System.out.println(" " + i + " " + j + " " + Arrays.toString(arr));

		}

		System.out.println(" " + i + " " + j + " " + Arrays.toString(arr));
//		quickSort(arr, low, j);
//	    quickSort(arr, i, high);

	}

	private static void quickSorts(int[] arr, int low, int high) {
		if (low >= high)
			return;

		partition(arr, low, high);

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void quiSorts(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low < high) {
			int pivot = partition(arr, low, high);
			quiSorts(arr, low, pivot - 1);
			quiSorts(arr, pivot + 1, high);
		}

	}

	private static int partition(int[] A, int l, int h) {

		int pivot = A[l]; // first element will be pivot
		int i = l, j = h;

		while (i < j) {

		    i += 1;
			   
			while (A[i] <= pivot && i < h) {
				i++;
			}
			while (A[j] > pivot && j >= l) {
				j--;
			}

			if (i < j)
				swap(A, i, j);
		}
		;

		swap(A, l, j);

		return j;

	}

	private static void cyclciSort(int array[], int n) {
		// TODO Auto-generated method stub

		int i = 0;
		while (i < n) {
			int correct = array[i] - 1;
			if (array[i] != array[correct]) {
				int swap = array[i];
				array[i] = array[correct];
				array[correct] = swap;
			} else {
				i++;
			}

		}

	}

}
