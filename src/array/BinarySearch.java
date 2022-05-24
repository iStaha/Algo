package array;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int list[] = { 1, 2, 3, 4, 5 };

		int n = 5;

		System.out.print(binarySearchRecursive(list, n, 0, list.length - 1));
	}

	private static boolean binarySearchRecursive(int[] list, int n, int left, int right) {
		// TODO Auto-generated method stub

		if (left > right) {
			return false;
		}
		
		int mid = left + ((right-left) / 2);

		if (list[mid] == n) {
			return true;
		}
		
		else if(n<list[mid]) {
			 return binarySearchRecursive(list , n , left , mid-1);
		} else {
			 return  binarySearchRecursive(list , n , mid+1 , right);
		}
			 

	}

}
