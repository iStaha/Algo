package java8;

// A Java Program to detect cycle in a graph
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Graph {

	private final int V;
	private final List<List<Integer>> adj;

	public Graph(int V) {
		this.V = V;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}

	// This function is a variation of DFSUtil() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = adj.get(i);
		

		for (Integer c : children)
			if (isCyclicUtil(c, visited, recStack))
				return true;

		recStack[i] = false;
       
		System.out.println("I " + i);
		System.out.println("resST " + Arrays.toString(recStack));
		System.out.println("Visitrf " + Arrays.toString(visited));
		
		
		return false;
	}

	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	// Returns true if the graph contains a
	// cycle, else false.
	// This function is a variation of DFS() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclic() {

		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < V; i++) {
			if (isCyclicUtil(0, visited, recStack))
				return true;
		}
		return false;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0)
			return true;
		int n = numCourses;
		int[] vis = new int[n];

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; ++i)
			map.put(i, new ArrayList<Integer>());

		System.out.println(map);

		for (int[] p : prerequisites) {
			map.get(p[1]).add(p[0]);
		}

		System.out.println(map);

		for (int i = 0; i < n; ++i) {
			if (!dfs(i, vis, map))
				return false;
		}
		return true;
	}

	private static boolean dfs(int i, int[] vis, Map<Integer, List<Integer>> map) {
		if (vis[i] == 1)
			return false;
		if (vis[i] == 2)
			return true;
		vis[i] = 1;

		for (int next : map.get(i)) {
			// System.out.println(next);
			if (!dfs(next, vis, map))
				return false;
		}
		System.out.println(i);
		System.out.println(Arrays.toString(vis));
		vis[i] = 2;
		return true;
	}

	public final static boolean canFinishs(int n, Integer[][] prerequisites) {
		int[] prereq = new int[n];

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; ++i)
			graph.add(i, new ArrayList<Integer>());

		for (Integer[] pre : prerequisites) {

			prereq[pre[0]]++;

			graph.get(pre[1]).add(pre[0]);
		}

		LinkedList<Integer> q = new LinkedList<Integer>();

		// Add all nodes with no prerequisites into queue
		for (int i = 0; i < n; i++) {
			if (prereq[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.peek();
			q.poll();

			// Reduce the prerequisite count of all courses for which current course was
			// prerequisite
			for (var it : graph.get(curr)) {
				prereq[it]--;

				// if this course has no prerequisite left, we can take this course
				if (prereq[it] == 0) {
					q.offer(it);
				}
			}

			// Reduce the number of courses left to be taken
			n--;
		}

		// if we took all courses i.e. no courses left to take, return true otherwise
		// false.
		return n == 0;
	}

	// Driver code
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
	//	graph.addEdge(2, 0);
		graph.addEdge(2, 3);
	//	graph.addEdge(3, 3);

		 if (graph.isCyclic())
		 System.out.println("Graph contains cycle");
		 else
		 System.out.println("Graph doesn't " + "contain cycle");

		int numCourses = 6;
		Integer[][] prerequisites = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4, }, { 3, 4 } , { 4, 1 } };

	//	System.out.println(canFinishs(numCourses, prerequisites));
	}
}

// This code is contributed by Sagar Shah.
