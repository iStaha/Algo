package sorting;

import java.util.Arrays;

//Java program for implementation of QuickSort 
class MergeSort 
{ 
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */



	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	void sort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */

		
	       int mid = (low + high) /2; 
		
	        

			// Recursively sort elements before 
			// partition and after partition 
			
			
			System.out.println("left sort("+ Arrays.toString(arr) +", "+ low  +", "+ mid); 
			sort(arr, low, mid); 
			System.out.println("right sort("+ Arrays.toString(arr) +", "+ (mid+1)  +", "+ high); 
			sort(arr, mid+1, high); 
	//		System.out.println(low +" "+ high); 
			System.out.println("merge("+ Arrays.toString(arr)+", "+ low +", "+ mid  +", "+ high); 
			merge(arr, low, mid, high);
		} 
	} 

	private void merge(int[] Arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		
		// create a temp array
		int temp[] = new int[end - start + 1];

		// crawlers for both intervals and for temp
		int i = start, j = mid+1, k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp 
		while(i <= mid && j <= end) {
			if(Arr[i] <= Arr[j]) {
				temp[k] = Arr[i];
				k += 1; i += 1;
			}
			else {
				temp[k] = Arr[j];
				k += 1; j += 1;
			}
		}

		// add elements left in the first interval 
		while(i <= mid) {
			temp[k] = Arr[i];
			k += 1; i += 1;
		}

		// add elements left in the second interval 
		while(j <= end) {
			temp[k] = Arr[j];
			k += 1; j += 1;
		}

		// copy temp to original interval
		for(i = start; i <= end; i += 1) {
			System.out.println(start +" " + i+ " " + Arrays.toString(temp));
			Arr[i] = temp[i - start];

		}
	}


	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		int arr[] = {10, 7, 8, 11, 1, 5}; 
		int n = arr.length; 

		printArray(arr); 
		MergeSort ob = new MergeSort(); 
		ob.sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		printArray(arr); 
	} 
} 
/*This code is contributed by Rajat Mishra */
