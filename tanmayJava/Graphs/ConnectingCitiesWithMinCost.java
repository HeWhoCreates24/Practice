import java.util.*;

public class ConnectingCitiesWithMinCost {
    public static class Edge {
        int dst;
        int wt;

        public Edge(int d, int w) {
            dst = d;
            wt = w;
        }
    }

    @SuppressWarnings("unchecked")
    public static class Graph {
        ArrayList<Edge>[] graph;

        public Graph(int[][] g) {
            graph = new ArrayList[g.length];
            
            for (int i = 0; i < g.length; i++) {
                graph[i] = new ArrayList<>();
                for (int j = 0; j < g[i].length; j++) {
                    if (g[i][j] != 0) {
                        graph[i].add(new Edge(j, g[i][j]));
                    }
                }
            }
        }
    }

    public static int minCostToConnect(int[][] cities) {
        int n = cities.length;
        Graph g = new Graph(cities);
        
        // Priority queue to store edges with minimum weight
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int edgesUsed = 0;
        
        // Start with city 0
        visited[0] = true;
        for (Edge e : g.graph[0]) {
            pq.offer(e);
        }
        
        // Process until we connect all cities or run out of edges
        while (!pq.isEmpty() && edgesUsed < n - 1) {
            Edge curr = pq.poll();
            
            // If destination is already visited, skip
            if (visited[curr.dst]) continue;
            
            // Add edge to MST
            visited[curr.dst] = true;
            totalCost += curr.wt;
            edgesUsed++;
            
            // Add all edges from newly connected city to priority queue
            for (Edge next : g.graph[curr.dst]) {
                if (!visited[next.dst]) {
                    pq.offer(next);
                }
            }
        }
        
        // Check if all cities are connected
        return edgesUsed == n - 1 ? totalCost : -1;
    }

    public static void main(String[] args) {
        int[][] cities = {{0, 1, 2, 3, 4},
                         {1, 0, 5, 0, 7},
                         {2, 5, 0, 6, 0},
                         {3, 0, 6, 0, 0},
                         {4, 7, 0, 0, 0}};

        int result = minCostToConnect(cities);
        if (result != -1) {
            System.out.println("Minimum cost to connect all cities: " + result);
        } else {
            System.out.println("Impossible to connect all cities");
        }
    }
}