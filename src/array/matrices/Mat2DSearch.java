package array.matrices;

public class Mat2DSearch {
	
	
	  public static boolean searchMatrix(int[][] M, int T) {
	        int y = M.length, i = 0, j = M[0].length - 1;
	        while (i < y && j >= 0) {
	            int cell = M[i][j];
	            if (cell == T) return true;
	            else if (cell > T) j--;
	            else i++;
	        }
	        return false;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] M = { { 1,4,7,11,15 }, { 2,5,8,12,19 } ,{ 3,6,9,16,22 }, { 10,13,14,17,24 }, { 18,21,23,26,30}  };
		int T = 13;
		
		System.out.println(searchMatrix(M, T));

	}

}
