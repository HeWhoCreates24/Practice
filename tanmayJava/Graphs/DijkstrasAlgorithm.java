import java.util.*;
public class DijkstrasAlgorithm{
    @SuppressWarnings("unused")
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
    public static class Graph{
        ArrayList<Edge>[] edges;

        @SuppressWarnings("unchecked")
        public Graph(int n){
            edges = new ArrayList[n];
        }

        public void addEdge(int s, int d, int w){
            edges[s].add(new Edge(s, d, w));
        }
    }
    public static void dijkAlgo(Graph g, int src){
        
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 7);
        g.addEdge(2, 4, 3);
        g.addEdge(4, 3, 2);
        g.addEdge(4, 5, 5);
        g.addEdge(3, 5, 1);

        dijkAlgo(g, 0);
    }
}