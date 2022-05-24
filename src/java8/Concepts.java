package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Concepts {

	public static void main(String[] args) {
		
	//	Collections are eagerly constructed i.e all the elements are computed at the beginning itself. 
	//	But, streams are lazily constructed i.e intermediate operations are not evaluated until terminal operation is invoked.
		
		
		
		List<Integer> number = Arrays.asList(4, 2, 8, 9, 5, 6, 7);
        
		number.stream().filter(i -> i >= 5).limit(4).forEach(System.out::println);
		
	
		
		
	//	Streams are traversable only once. If you traverse the stream once, it is said to be consumed. 
	//	To traverse it again, you have to get new stream from the source again. But, collections can be traversed multiple times.
		
	
		List<Integer> numbers = Arrays.asList(4, 2, 8, 9, 5, 6, 7);
        
		Stream<Integer> numbersGreaterThan5 = numbers.stream().filter(i -> i > 5);
		         
		//Traversing numbersGreaterThan5 stream first time
		         
		numbersGreaterThan5.forEach(System.out::println);
		         
		//Second time traversal will throw error
		         
		//Error : stream has already been operated upon or closed
		         
	//	numbersGreaterThan5.forEach(System.out::println);
		
		
	
     //Internal Iteration		
		
		
		List<String> names = new ArrayList<>();
        
		names.add("Charlie");
		                 
		names.add("Douglas");
		                 
		names.add("Sundaraman");
		                 
		names.add("Charlie");
		                 
		names.add("Yuki");
		         
		//External iteration of collections
		         
		for (String name : names) 
		{
		    System.out.println(name);
		}
		         
		//Output :
		         
		//Charlie
		//Douglas
		//Sundaraman
		//Charlie
		//Yuki
		         
		//Internal iteration of streams. No for loops
		 
		names.stream().map(String::toUpperCase).forEach(System.out::println);
		
		
		
		
		
		
		
		Runnable r = () -> System.out.println("Runnable Implementation Using Lambda Expressions");
		
		
		r.run();
		
		
		
		
		
	}

}
