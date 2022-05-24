package graphs;

import java.util.*;
import java.util.Map.Entry;



class Vertex {
    String label;
    Vertex(String label) {
        this.label = label;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
 
    
}

class Graph {
	
    private Map<Vertex, List<Vertex>> adjVertices;
    
    
    public Graph() {
    	 adjVertices = new HashMap<Vertex, List<Vertex>>();
	}


	public Map<Vertex, List<Vertex>> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}
	

    
	void addVertex(String label) {
	    adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}
	 
	void removeVertex(String label) {
	    Vertex v = new Vertex(label);
	    adjVertices.values().stream().forEach(e -> e.remove(v));
	    adjVertices.remove(new Vertex(label));
	}
	
	void addEdge(String label1, String label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    adjVertices.get(v1).add(v2);
	//    adjVertices.get(v2).add(v1);
	}
	
	void removeEdge(String label1, String label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    List<Vertex> eV1 = adjVertices.get(v1);
	    List<Vertex> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
	
	 public void printGraph(){
	        //I printed it like this. You can print it however you want though
	        for(Entry<Vertex, List<Vertex>> s : adjVertices.entrySet()){
	             System.out.println("KEY-->>  "  + s.getKey().label);
	             for(Vertex sVer : s.getValue()) {
	            	 System.out.println("VALUE-->>  "  + sVer.label);
	             }
	        }
	    }
	 
	 List<Vertex> getAdjVertices(String label) {
		    return adjVertices.get(new Vertex(label));
		}
	 
	 
	 Set<String> depthFirstTraversal(Graph graph, String root) {
		    Set<String> visited = new LinkedHashSet<String>();
		    Stack<String> stack = new Stack<String>();
		    stack.push(root);
		    while (!stack.isEmpty()) {
		        String vertex = stack.pop();
		        if (!visited.contains(vertex)) {
		            visited.add(vertex);
		            for (Vertex v : graph.getAdjVertices(vertex)) {              
		                stack.push( v.label);
		                System.out.println("NEIBOURS ->> "  + v.label + " ");
		            }
		        }
		        System.out.println("VISITED ->> "  + visited);
		        System.out.println("stack ->> "  + stack);
		    }
		    return visited;
		}
	 
	 Set<String> breadthFirstTraversal(Graph graph, String root) {
		    Set<String> visited = new LinkedHashSet<String>();
		    Queue<String> queue = new LinkedList<String>();
		    queue.add(root);
		    visited.add(root);
		    while (!queue.isEmpty()) {
		        String vertex = queue.poll();
		        for (Vertex v : graph.getAdjVertices(vertex)) {
		            if (!visited.contains(v.label)) {
		                visited.add(v.label);
		                queue.add(v.label);
		            }
		        }
		        System.out.println("queue ->> "  + queue);
		        System.out.println("VISITED ->> "  + visited);
		    }
		    return visited;
		}
	 
    
    
}

public class Graphs {

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    Graph graph = new Graph();
		    graph.addVertex("Bob");
		    graph.addVertex("Alice");
		    graph.addVertex("Mark");
		    graph.addVertex("Rob");
		    graph.addVertex("Maria");
		    graph.addEdge("Bob", "Alice");
		    graph.addEdge("Bob", "Rob");
		    graph.addEdge("Alice", "Mark");
		    graph.addEdge("Rob", "Mark");
		    graph.addEdge("Alice", "Maria");
		    graph.addEdge("Rob", "Maria");		
		//    graph.printGraph();
		    
		    
		 
		    
		//    System.out.println(graph.breadthFirstTraversal(graph, "Bob").toString());
		    
		    System.out.println(graph.depthFirstTraversal(graph, "Bob").toString());

	}
	
	

}
