package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 Set hash_Set = new HashSet();
		 
		 List list = new LinkedList();
		 
		 
		 Employee e1 = new Employee(1, "Taha");
		 Employee e2 = e1;
		 
		 
		 hash_Set.add(e1);
		 hash_Set.add(e2);
		 
		 list.add(e1);
		 list.add(e2);
		 
		 
		 System.out.println(hash_Set.size());
		 System.out.println(list.size());

	}

}
