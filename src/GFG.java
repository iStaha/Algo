// Java program to find the number of
// jumps required
public class GFG {
	
	
	/* function to calculate jumps required
	to cross walls */
	static int jumpcount(int x, int y, int n,
								int height[])
	{
		int jumps = 0;
		for (int i = 0; i < n; i++) {
	
			// Since all heights are
			// greater than 1, at-least
			// one jump is always required
			jumps++;
	
			// More jumps required if height
			// is greater than x.
			if (height[i] > x)
			{
			// Since we have already counted
			// one jump
			int h = height[i] - (x - y);
			
			System.out.println(h);
	
			// Remaining jumps
			jumps += h/(x - y);
	
			// If there was a remainder greater
			// than 1. 1 is there to handle cases
			// like x = 11, y = 1, height[i] = 21.
			if (h % (x-y) > 1)
				jumps++;
			}
		}
		return jumps;
	}
	
	/* driver function */
	public static void main(String args[])
	{
		int x = 11;
		int y = 1;
		int height[] = { 21 };
		int n = height.length;
		System.out.println(jumpcount(x, y, n, height));
	}
}
// This code is contributed by Sumit Ghosh
