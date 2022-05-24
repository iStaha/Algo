package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;





class MinimumCost {
	
    static List<List<Pair<Integer, Integer>>> adjList;
    static int[] timeTaken;
    public static int networkDelayTime(int[][] times, int n, int k) {
        //initialize the graph and timeTaken array
        adjList = new ArrayList<>();
        timeTaken = new int[n+1];
        
        //build the graph and fill the timetaken arraty with int_max(i.e. infy)
        buildGraph(n, times);
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        //find shortest path from the current vertex to every ohter vertex
        djikstras(k);
        
        //get the maximum time travelled for network to travel
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++)
            max = Math.max(timeTaken[i], max);
        
        
        System.out.println(Arrays.toString(timeTaken));
        
        //return the max if its a valid ansewer or -1(i.e we could not connect with every vertex from starting vertex)
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    
    private static void buildGraph(int vertices, int[][] edges){
        //for each vertex, add the empty list
        for(int i=0; i<=vertices; i++)
            adjList.add(new ArrayList<>());
        
        //connect the edges between the adjacent nodes/vertices
        for(int i=0; i<edges.length; i++)
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
    }
    
	private static void djikstras(int source){
        //build a min heap, as we want to get maximum time
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair :: getValue));
        
        //add the starting vertex(i.e. source) with timeTaken 0
        minHeap.add(new Pair(source, 0));
        timeTaken[source] = 0; // mark source vertex in timeTaken as 0(no time taken for the same vertex)
        
        while(!minHeap.isEmpty()){
            //remove the minimum node/pair from the heap
            Pair<Integer, Integer> pair = minHeap.remove();
            int currentNode = pair.getKey(); //get the node/vertex
            int time = pair.getValue();//get the weight/time of the edge
            
            //traverse through every adjacent node/vertex for current node/vertex 
            for(Pair<Integer,Integer> neibhour : adjList.get(currentNode)){
                int neibhour_node = neibhour.getKey();
                int neibhour_time = neibhour.getValue();
                
                //update the minimium distance in timeTaken
                if(time + neibhour_time < timeTaken[neibhour_node]){
                    timeTaken[neibhour_node] = time + neibhour_time;
                    //add the UPDATED pair of vertex and new distance in minHeap
                    minHeap.add(new Pair(neibhour_node, timeTaken[neibhour_node]));
                }
            }
        }
    }
    
    
    public static void main(String args[]) 
	{ 
    	int [][] times = { {2,1,1} , {2,3,1}, {3,4,1 } };
    	int n = 4, k = 2;
    	
    	int max = networkDelayTime(times, n , k);
    	
    	System.out.println(max);
	} 
    
}