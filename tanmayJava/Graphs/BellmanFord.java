import java.util.*;

public class BellmanFord{
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            src = s;
            dest = d;
            wt = w;
        }
    }
    @SuppressWarnings("unchecked")
    public static class Graph{
        ArrayList<Edge>[] graph;

        public Graph(int n){
            graph = new ArrayList[n];

            for (int i = 0; i < graph.length; i++){
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int s, int d, int w){
            graph[s].add(new Edge(s, d, w));
        }
    }
    public static void bellmanFord(Graph g, int src){
        int[] sd = new int[g.graph.length];

        for (int i = 0; i < sd.length; i++){
            if (i != src) sd[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < g.graph.length; i++){
            for (ArrayList<Edge> node : g.graph) {
                for (Edge e : node) {
                    if (e.src != Integer.MAX_VALUE && sd[e.src] + e.wt < sd[e.dest]){
                        sd[e.dest] = sd[e.src] + e.wt;
                    }
                }
            }
        }

        for (int dist : sd){
            System.out.print(dist + " ");
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, -4);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 4, 4);
        g.addEdge(4, 1, -1);

        bellmanFord(g, 0);
    }
}