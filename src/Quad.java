import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
         List<Integer>  aL = new ArrayList<Integer>(); 
         List<Integer>  bL = new ArrayList<Integer>(); 
         List<Integer>  nL = new ArrayList<Integer>(); 
		
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            aL.add(a);
            bL.add(b);
            nL.add(n);
                               
        }
        
        for(int i=0;i < t;i++){
        	
        	  int s = aL.get(i) , d = 0;
              
              for(int j = 0; j <= nL.get(i); j++) {
                 
                d =  (int) (d + (Math.pow(2, j)) * bL.get(i));
                
                System.out.print((s+d) +" ");
              }
              System.out.println( "");
            
         
          
        }
        
        
        
        in.close();

	}

}
