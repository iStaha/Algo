package sorting;

//Java program for implementation of QuickSort 
class SelectionSort 
{ 
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */

	void sort(int array[]) 
	{ 
		for(var i = 0; i < array.length; i++){
		    //set min to the current iteration of i
		    var min = i;
		    
		    for(var j = i+1; j < array.length; j++){
		      if(array[j] < array[min]){
		       min = j;
		      }
		    }
		    
		    int temp = array[i];
		    
		    array[i] = array[min];
		    
		    array[min] = temp;
		    
		//    [array[i], array[min]] = [array[min], array[i]];
		  
		    printArray(array); 
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
		SelectionSort ob = new SelectionSort(); 
		ob.sort(arr); 

		System.out.println("sorted array via Selection Sort"); 
		printArray(arr); 
	} 
} 
/*This code is contributed by Rajat Mishra */
