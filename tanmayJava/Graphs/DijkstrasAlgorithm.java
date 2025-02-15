import java.util.*;

public class DijkstrasAlgorithm {
    // Edge class representing a weighted edge
    @SuppressWarnings("unused")
    public static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    // Graph class with adjacency list representation
    public static class Graph {
        ArrayList<Edge>[] edges;

        @SuppressWarnings("unchecked")
        public Graph(int n) {
            edges = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
        }

        public void addEdge(int s, int d, int w) {
            edges[s].add(new Edge(s, d, w));
            edges[d].add(new Edge(d, s, w)); // Ensuring bidirectional edges
        }
    }

    // Pair class for priority queue (Min-Heap)
    public static class Pair implements Comparable<Pair> {
        int node, path;

        public Pair(int n, int p) {
            node = n;
            path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return Integer.compare(this.path, p2.path);
        }
    }

    // Dijkstra's Algorithm Implementation
    public static void dijkstra(Graph g, int src) {
        int n = g.edges.length;
        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[src] = 0; // Set source distance to 0

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Pair closest = pq.poll();
            int u = closest.node;

            if (visited[u]) continue; // Skip already processed nodes
            visited[u] = true;

            for (Edge e : g.edges[u]) {
                int v = e.dest;
                int newDist = shortestPath[u] + e.wt;

                if (!visited[v] && newDist < shortestPath[v]) {
                    shortestPath[v] = newDist;
                    pq.add(new Pair(v, newDist)); // Push updated path
                }
            }
        }

        // Print shortest paths
        System.out.println("Shortest Paths from Source " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println(src + " -> " + i + " = " + (shortestPath[i] == Integer.MAX_VALUE ? "∞" : shortestPath[i]));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 7);
        g.addEdge(2, 4, 3);
        g.addEdge(4, 3, 2);
        g.addEdge(4, 5, 5);
        g.addEdge(3, 5, 1);

        dijkstra(g, 0);
    }
}
