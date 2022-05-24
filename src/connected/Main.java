package connected;

import java.util.*;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Data structure to store graph edges
class Edge
{
	public final int source, dest;

	private Edge(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}

	// Factory method for creating a Edge immutable instance
	public static Edge of(int a, int b) {
		return new Edge(a, b);		// calls private constructor
	}
}

// Class to represent a graph object
class Graph
{
	// A List of Lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int N) {
		adjList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge edge: edges) {
			adjList.get(edge.source).add(edge.dest);
		}
	}
}

class Main
{
	// Function to perform DFS traversal in a directed graph to find the
	// complete path between source and destination vertices
	public static boolean isConnected(Graph graph, int src, int dest,
									  boolean[] discovered, Stack<Integer> path)
	{
		// mark current node as discovered
		discovered[src] = true;

		// include current node in the path
		path.add(src);

		// if destination vertex is found
		if (src == dest) {
			return true;
		}

		// do for every edge (src -> i)
		for (int i: graph.adjList.get(src))
		{
			// u is not discovered
			if (!discovered[i])
			{
				// return true if destination is found
				if (isConnected(graph, i, dest, discovered, path)) {
					return true;
				}
			}
		}

		// backtrack: remove current node from the path
		path.pop();

		// return false if destination vertex is not reachable from src
		return false;
	}

	public static void main(String[] args)
	{
		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(Edge.of(0, 3), Edge.of(1, 0), Edge.of(1, 2),
				Edge.of(1, 4), Edge.of(2, 7), Edge.of(3, 4),
				Edge.of(3, 5), Edge.of(4, 3), Edge.of(4, 6),
				Edge.of(5, 6), Edge.of(6, 7));

		// Number of nodes in the graph (labelled from 0 to N-1)
		int N = 8;

		// create a graph from given edges
		Graph graph = new Graph(edges, N);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		// source and destination vertex
		int src = 0, dest = 7;

		// To store the complete path between source and destination
		Stack<Integer> path = new Stack<>();

		// perform DFS traversal from the source vertex to check the connectivity
		// and store path from the source vertex to the destination vertex
		if (isConnected(graph, src, dest, discovered, path))
		{
			System.out.println("Path exists from vertex " + src + " to vertex " + dest);
			System.out.println("The complete path is: " + path);
		}
		else {
			System.out.println("No path exists between vertices " + src + " and " + dest);
		}
	}
}