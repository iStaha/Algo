import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Transferwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		
		int cId = scan.nextInt();
		
		int tId = scan.nextInt();
		
		
		
		List<Integer> cIds = new ArrayList<Integer>();
		
		for(int i=0; i < cId; i++) {
			cIds.add(scan.nextInt());
					
		}
		
	//	System.out.println(cIds);
		
		
		Map<Integer, Integer> tIds = new HashMap<Integer, Integer>();
		
		Random rand = new Random(); 
		
		
		
		
		for(int i=1; i <= tId; i++) {
	//		tIds.put(i, cIds.get(rand.nextInt(5)));
			
			tIds.put(i, scan.nextInt());
					
		}
		
	//	System.out.println(tIds.keySet());
	//   System.out.println(tIds.values());
		
	
		
	    TreeSet<Integer> tset = new TreeSet<Integer>();
	
		for(int j : cIds) {
			
			if(!tIds.containsValue(j)) {
				tset.add(j);
				
			}
			
		}
		
		if(tset.size()>=1) {
			for(int s : tset) {
				System.out.print(s+ " ");
			}
		}
		else {
			System.out.print("Empty list");
		}
		
		
		
		
		
		
		
		
		

	}

}
