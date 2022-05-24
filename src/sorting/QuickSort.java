package sorting;

//Java program for implementation of QuickSort 
class QuickSort 
{ 
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	int partition(int arr[], int start, int end) 
	{ 
		int i = start + 1;
	    int piv = arr[start] ;            //make the first element as pivot element.
	    for(int j =start + 1; j <= end ; j++ )  {
	    /*rearrange the array by putting elements which are less than pivot
	       on one side and which are greater that on other. */

	          if ( arr[ j ] < piv) {
	        	  System.out.println(i+" " + j); 
	        	  int temp = arr[i]; 
	              arr[i] = arr[j]; 
	              arr[j] = temp; 
	              i += 1;
	        }
	          printArray(arr); 
	   }
	   
	    int temp = arr[i-1]; 
        arr[i-1] = arr[start]; 
        arr[start] = temp;   //put the pivot element in its proper place.
	    return i-1;                      //return 
	} 

	
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
			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
		//	sort(arr, low, pi-1); 
		//	sort(arr, pi+1, high); 
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
		QuickSort ob = new QuickSort(); 
		ob.sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		printArray(arr); 
	} 
} 
/*This code is contributed by Rajat Mishra */
