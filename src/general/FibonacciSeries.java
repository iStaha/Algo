package general;

public class FibonacciSeries {

	
	public static int nthFibonacciTerm(int n) {
	    if (n == 1 || n == 0) {
	        return n;
	    }
	    return nthFibonacciTerm(n-1) + nthFibonacciTerm(n-2);
	}
	
	 // Function to find the fibonacci Series 
    static int fib(int n) 
    { 
  
        // Declare an array to store 
        // Fibonacci numbers. 
        // 1 extra to handle case, n = 0 
        int f[] = new int[n + 2]; 
  
        int i; 
  
        // 0th and 1st number of 
        // the series are 0 and 1 
        f[0] = 0; 
        f[1] = 1; 
  
        for (i = 2; i <= n; i++) { 
  
            // Add the previous 2 numbers 
            // in the series and store it 
            f[i] = f[i - 1] + f[i - 2]; 
        } 
  
        // Nth Fibonacci Number 
        return f[n]; 
    } 
	
	public static int nthFibonaciTerm(int n) {
	    if(n == 0 || n == 1) {
	        return n;
	    }
	    int n0 = 0, n1 = 1;
	    int tempNthTerm;
	    for (int i = 2; i <= n; i++) {
	        tempNthTerm = n0 + n1;
	        n0 = n1;
	        n1 = tempNthTerm;
	        System.out.print(n1 + " ");
	    }
	   
	    return n1;
	}
	
	public static void FibSeries(int  n) {
		  int t1 = 0, t2 = 1;
	        System.out.print("First " + n + " terms: ");

	        for (int i = 1; i <= n; ++i)
	        {
	            System.out.print(t1 + "  ");

	            int sum = t1 + t2;
	            t1 = t2;
	            t2 = sum;
	        }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	System.out.println(nthFibonacciTerm(5));
		
	//	System.out.println(nthFibonaciTerm(5));
		
		
		FibSeries(5);
		
		
	//	for(int i=0; i<10; i++) {
	//		 System.out.print(fib(i) + " "); 
	//	}
		
	}

}
