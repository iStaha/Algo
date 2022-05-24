package array;

public class Water {
	
	
	 public static int maxArea(int[] height) {
	        
	        int area = 0;
	        
	        
	        for(int i=0; i< height.length; i++){
	            
	            for(int j=i+1;j <height.length; j++){
	            
	            area = Math.max(area , Math.min(height[i], height[j])  * (j-i));
	                
	                         
	            }
	            
	        }
	        
	        
	        return area;
	        	       
	        
	    }
	 
	 public static int maxAreas(int[] height) {
	        
	        int area = 0;
	        
	        int i = 0;
	        
	        int j = height.length-1;
	        
	        
		      while(i < j ) {
		    	  if(height[i] < height[j]) {
		    		  area = Math.max(area , height[i]  * (j-i));
		    		  i++;
		    	  }
		    	  else {
		    		  area = Math.max(area , height[j]  * (j-i));
		    		  j--;
		    	  }
		      }
	        
	        
	        
	        return area;
	        	       
	       
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int container[] = {1,8,6,2,5,4,8,3,7 } ;

		
		 System.out.println(maxAreas(container));
	
	
	}

}
