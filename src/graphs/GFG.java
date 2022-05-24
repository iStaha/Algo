package graphs;

import java.io.*;
import java.util.*;

class GFG {
	static class AdjListNode {
		int vertex, weight;

		AdjListNode(int v, int w) {
			vertex = v;
			weight = w;
		}

		int getVertex() {
			return vertex;
		}

		int getWeight() {
			return weight;
		}

		@Override
		public String toString() {
			return "AdjListNode [vertex=" + vertex + ", weight=" + weight + "]";
		}

	}

	// Function to find the shortest distance of all the
	// vertices from the source vertex S.
	public static int[] dijkstra(int V, ArrayList<ArrayList<AdjListNode>> graph, int source) {
		int[] distance = new int[V + 1];

		for (int i = 0; i <= V; i++)
			distance[i] = Integer.MAX_VALUE;

		distance[0] = 0;
		distance[source] = 0;

		PriorityQueue<AdjListNode> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());

		// PriorityQueue<AdjListNode> pq = new PriorityQueue<>(
		// Comparator.comparing(AdjListNode :: getWeight() )) ;

		pq.add(new AdjListNode(source, 0));

		while (pq.size() > 0) {

			AdjListNode current = pq.poll();
			System.out.println("poll " + current);
			for (AdjListNode n : graph.get(current.getVertex())) {
				System.out.println("n " + n);
				System.out.println(Arrays.toString(distance));
				if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
					distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
					pq.add(new AdjListNode(n.getVertex(), distance[n.getVertex()]));
				}
			}
		}
		// If you want to calculate distance from source to
		// a particular target, you can return
		// distance[target]
		return distance;
	}

	public static int networkDelayTimes(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
		for (int[] time : times) {
			g.computeIfAbsent(time[0], k -> new HashMap<>());
			g.get(time[0]).put(time[1], time[2]);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		Set<Integer> vs = new HashSet<>();
		pq.offer(new int[] { K, 0 });
		int res = 0;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			if (vs.contains(curr[0]))
				continue;
			vs.add(curr[0]);
			res = Math.max(res, curr[1]); // this must be after vs check, say[[1,2,1],[2,1,3]] 2, 2
			for (int neig : g.getOrDefault(curr[0], new HashMap<Integer, Integer>()).keySet()) {
				if (vs.contains(neig))
					continue;
				pq.offer(new int[] { neig, g.get(curr[0]).get(neig) + curr[1] });
			}
		}
		return vs.size() == N ? res : -1; // check if all nods visited; say [[1,2,1]], 2, 2
	}
	
	
	public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            if (!map.containsKey(time[0])) 
                map.put(time[0], new LinkedList<int[]>()); 
            map.get(time[0]).add(new int[]{time[1], time[2]}); 
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(K); int res = 0;
        if (map.containsKey(K)) pq.addAll(map.get(K)); 
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (seen.contains(cur[0])) continue; 
            List<int[]> outList = map.get(cur[0]); 
            if (outList != null) { 
                for (int[] neighbor : outList) {
                    if (!seen.contains(neighbor[0])) 
                        pq.add(new int[]{neighbor[0], cur[1] + neighbor[1]}); 
                }
            }
            seen.add(cur[0]); 
            res = Math.max(res, cur[1]);
        }
        return seen.size() == N ? res : -1; 
    }
	
	
	 public int networkDelayTimess(int[][] times, int N, int K) {
	        if (times == null || times.length == 0) {
	            return -1;
	        }
	        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	        for (int i = 1; i <= N; i++) {
	            map.put(i, new HashMap<>());
	        }
	        for (int[] time: times) {
	            map.get(time[0]).put(time[1], time[2]);
	        }
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
	        pq.offer(new int[]{K, 0});
	        int[] dis = new int[N + 1];
	        Arrays.fill(dis, Integer.MAX_VALUE);
	        int[] visit = new int[N + 1];
	        dis[K] = 0;
	        while (!pq.isEmpty()) {
	            int[] node = pq.poll();
	            if (visit[node[0]] == 1) continue;
	            visit[node[0]] = 1;
	            for (Map.Entry<Integer, Integer> entry: map.get(node[0]).entrySet()) {
	                if (entry.getValue() + node[1] < dis[entry.getKey()]) {
	                    dis[entry.getKey()] = entry.getValue() + node[1];
	                }
	                pq.offer(new int[]{entry.getKey(), dis[entry.getKey()]});
	            }
	        }
	        int res = 0;
	        for (int i = 1; i <= N; i++) {
	            if (dis[i] == Integer.MAX_VALUE) {
	                return -1;
	            }
	            res = Math.max(res, dis[i]);
	        }
	        return res;
	    }

	public static void main(String[] args) {
		int V = 4;
		ArrayList<ArrayList<AdjListNode>> graph = new ArrayList<>();

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		int source = 2;

		// graph.get(2).add(new AdjListNode(1, 1));
		// graph.get(2).add(new AdjListNode(3, 1));
		// graph.get(3).add(new AdjListNode(4, 1));

		int[][] edges = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };

		// connect the edges between the adjacent nodes/vertices
		for (int i = 0; i < edges.length; i++)
			graph.get(edges[i][0]).add(new AdjListNode(edges[i][1], edges[i][2]));

		// graph.get(0).add(new AdjListNode(1, 4));
		// graph.get(0).add(new AdjListNode(7, 8));
		// graph.get(1).add(new AdjListNode(2, 8));
		// graph.get(1).add(new AdjListNode(7, 11));
		// graph.get(1).add(new AdjListNode(0, 7));
		// graph.get(2).add(new AdjListNode(1, 8));
		// graph.get(2).add(new AdjListNode(3, 7));
		// graph.get(2).add(new AdjListNode(8, 2));
		// graph.get(2).add(new AdjListNode(5, 4));
		// graph.get(3).add(new AdjListNode(2, 7));
		// graph.get(3).add(new AdjListNode(4, 9));
		// graph.get(3).add(new AdjListNode(5, 14));
		// graph.get(4).add(new AdjListNode(3, 9));
		// graph.get(4).add(new AdjListNode(5, 10));
		// graph.get(5).add(new AdjListNode(4, 10));
		// graph.get(5).add(new AdjListNode(6, 2));
		// graph.get(6).add(new AdjListNode(5, 2));
		// graph.get(6).add(new AdjListNode(7, 1));
		// graph.get(6).add(new AdjListNode(8, 6));
		// graph.get(7).add(new AdjListNode(0, 8));
		// graph.get(7).add(new AdjListNode(1, 11));
		// graph.get(7).add(new AdjListNode(6, 1));
		// graph.get(7).add(new AdjListNode(8, 7));
		// graph.get(8).add(new AdjListNode(2, 2));
		// graph.get(8).add(new AdjListNode(6, 6));
		// graph.get(8).add(new AdjListNode(7, 1));

		int[] distance = dijkstra(V, graph, source);
		// Printing the Output
		System.out.println("Vertex " + " Distance from Source");
		for (int i = 0; i <= V; i++) {
			System.out.println(i + "	 " + distance[i]);
		}

		int result = Integer.MIN_VALUE;
		// Time O(V) Vertices
		for (int i = 1; i < distance.length; i++) {// Note that i = 0 is invalid because we do not have 0th node so we
													// start from 1
			Integer x = distance[i];
			if (x == null) {
				result = -1;
			}

			result = Math.max(result, x);
		}

		System.out.println(result);

		System.out.println(networkDelayTimes(edges, V, source));
	}
}
