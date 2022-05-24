package graphs;

//Java program to print BFS traversal from a given source vertex. 
//BFS(int s) traverses vertices reachable from s. 
import java.io.*; 
import java.util.*; 

//This class represents a directed graph using adjacency list 
//representation 
class BFS 
{ 
    private Map<Integer, List<Integer>> adj; //Adjacency Lists 

	// Constructor 
	BFS() 
	{ 
		 adj = new HashMap<Integer, List<Integer>>();
	
	} 

	// Function to add an edge into the graph 
	void addEdge(int v,int w) 
	{ 
		    adj.get(v).add(w);
		    adj.get(w).add(v); 
	}
	
	void addVertex(int vert) 
	{ 
		adj.putIfAbsent(vert, new ArrayList<>());
	}
	
	 List<Integer> getAdjVertices(int label) {
		    return adj.get(label);
		}
	 

	// prints BFS traversal from a given source s 
	void BFS(BFS g, int s) 
	{ 
		// Mark all the vertices as not visited(By default 
		// set as false) 
		Set<Integer> visited = new LinkedHashSet<Integer>();

		// Create a queue for BFS 
		LinkedList<Integer> queue = new LinkedList<Integer>(); 

		// Mark the current node as visited and enqueue it 
		visited.add(s); 
		queue.add(s); 

		while (queue.size() != 0) 
		{ 
			// Dequeue a vertex from queue and print it 
			s = queue.poll(); 
			System.out.print(s+" "); 

			// Get all adjacent vertices of the dequeued vertex s 
			// If a adjacent has not been visited, then mark it 
			// visited and enqueue it 
		  for (int in : g.getAdjVertices(s)) {
				int n = in; 
				if (!visited.contains(n)) 
				{ 
					visited.add(n); 
					queue.add(n); 
				} 
			} 
		} 
	} 

	// Driver method to 
	public static void main(String args[]) 
	{ 
		BFS g = new BFS();
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(4);
		g.addVertex(3);
		
		g.addEdge(0, 1); 
		g.addEdge(0, 4); 
		g.addEdge(1, 4); 
		g.addEdge(4, 0); 
		g.addEdge(4, 3); 
		g.addEdge(3, 3); 

		System.out.println("Following is Breadth First Traversal "+ 
						"(starting from vertex 2)"); 

		g.BFS(g, 4); 
	} 
} 
//This code is contributed by Aakash Hasija 
