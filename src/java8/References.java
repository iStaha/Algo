package java8;

import java.util.function.Function;
import java.util.function.Supplier;


class Company
{
    String name;
     
    public Company(String name) 
    {
        this.name = name;
    }
     
    public Company() {
		// TODO Auto-generated constructor stub
	}

	public String getName()
    {
        return name;
    }
}

public class References {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// a) Method reference to static method

		// Calling parseInt() method using lambda

		Function<String, Integer> lambdaFunction = (String s) -> Integer.parseInt(s);
		System.out.println(lambdaFunction.apply("12"));

		// Calling parseInt() method using method reference

		Function<String, Integer> referenceFunction = Integer::parseInt;
		System.out.println(referenceFunction.apply("12"));

		// b) Method reference to instance method (ClassName::MethodName)

		// Calling toLowerCase() method using lambda

		Function<String, String> lambdaFunctions = (String s) -> s.toLowerCase();
		System.out.println(lambdaFunctions.apply("JAVA"));

		// Calling toLowerCase() method using method reference

		Function<String, String> referenceFunctions = String::toLowerCase;
		System.out.println(referenceFunctions.apply("JAVA"));
		
		
		
		
		
		
		
		
	//	c) Method reference to instance method (ReferenceVariable::MethodName)
		
		
		
		Company c = new Company("My_Company");
        
        //Calling getName() of c using lambda
         
        Supplier<String> lambdaSupplier = () -> c.getName();
        System.out.println(lambdaSupplier.get());
         
        //Calling getName() of c using method reference
         
        Supplier<String> referenceSupplier = c::getName;
        System.out.println(referenceSupplier.get());
        
        
        
        
        
        
        //  d) Constructor References
        
        
        
        
        //Creating objects using lambda
        
        Supplier<Company> lambdaSuppliers = () -> new Company();
        lambdaSuppliers.get();
         
        //Creating objects using constructor references
         
        Supplier<Company> referenceSuppliers = Company::new;
        referenceSuppliers.get();
        
        
        
        
        
        
        
        
        
        
        

	}

}
