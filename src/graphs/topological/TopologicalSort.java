package graphs.topological;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Edge {
	int src, dest;

	public Edge(int src, int dest) {
		super();
		this.src = src;
		this.dest = dest;
	}

}

class Graph {
	// A list of lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// stores indegree of a vertex
	List<Integer> indegree = null;

	// Constructor
	Graph(List<Edge> edges, int n) {
		adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// initialize indegree of each vertex by 0
		indegree = new ArrayList<>(Collections.nCopies(n, 0));

		// add edges to the directed graph
		for (Edge edge : edges) {
			int src = edge.src;
			int dest = edge.dest;

			// add an edge from source to destination
			adjList.get(src).add(dest);

			// increment in-degree of destination vertex by 1
			indegree.set(dest, indegree.get(dest) + 1);
		}
	}
}

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List of graph edges as per the above diagram
		List<Edge> edges = Arrays.asList(new Edge(0, 6), new Edge(1, 2), new Edge(1, 4), new Edge(1, 6), new Edge(3, 0),
				new Edge(3, 4), new Edge(5, 1), new Edge(7, 0), new Edge(7, 1));

		// total number of nodes in the graph (labelled from 0 to 7)
		int n = 8;

		// build a graph from the given edges
		Graph graph = new Graph(edges, n);

		// Perform topological sort
		List<Integer> L = doTopologicalSort(graph, n);

		if (L != null) {
			System.out.print(L); // print topological order
		} else {
			System.out.println("Graph has at least one cycle. " + "Topological sorting is not possible");
		}
	}

	private static List<Integer> doTopologicalSort(Graph graph, int n) {
		// TODO Auto-generated method stub

		List<Integer> topList = new ArrayList<>();

		List<Integer> indegree = graph.indegree;

		Stack<Integer> S = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (indegree.get(i) == 0) {
				S.add(i);
			}
		}

		while (!S.isEmpty()) {

			int i = S.pop();

			topList.add(i);

			for (int m : graph.adjList.get(i)) {

				indegree.set(m, indegree.get(m) - 1);

				if (indegree.get(m) == 0) {
					S.add(m);
				}
			}

		}

		// if a graph has edges, then the graph has at least one cycle
		for (int i = 0; i < n; i++) {
			if (indegree.get(i) != 0) {
				return null;
			}
		}

		return topList;

		}

}
