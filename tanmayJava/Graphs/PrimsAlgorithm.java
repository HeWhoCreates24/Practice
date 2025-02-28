import java.util.*;

public class PrimsAlgorithm{
    public static class Edge{
        int dest;
        int wt;

        public Edge(int d, int w){
            dest = d;
            wt = w;
        }
    }
    @SuppressWarnings("unchecked")
    public static class Graph{
        ArrayList<Edge>[] graph;

        public Graph(int n){
            graph = new ArrayList[n];

            for (int i = 0; i < n; i++){
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int s, int d, int w){
            graph[s].add(new Edge(d, w));
            graph[d].add(new Edge(s, w));
        }
    }
    public static class Node implements Comparable<Node>{
        int vertex;
        int dist;

        public Node(int v, int d){
            vertex = v;
            dist = d;
        }

        @Override
        public int compareTo(Node n2){
            return this.dist - n2.dist;
        }
    }
    public static void primsAlgo(Graph g, int src){
        boolean[] visited = new boolean[g.graph.length];
        int mstCost = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()){
            Node curr = pq.poll();
            if (!visited[curr.vertex]){
                visited[curr.vertex] = true;

                mstCost += curr.dist;
                for (Edge e : g.graph[curr.vertex]){
                    if (!visited[e.dest]) pq.add(new Node(e.dest, e.wt));
                }
            }
        }

        System.out.println("MST cost : " + mstCost);
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 15);
        g.addEdge(0, 3, 30);
        g.addEdge(1, 3, 40);
        g.addEdge(2, 3, 50);

        primsAlgo(g, 0);
    }
}