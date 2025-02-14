import java.util.*;

public class AllPathsSrcToDest{
    public static class Graph{
        public ArrayList<Integer>[] edges;

        @SuppressWarnings("unchecked")
        public Graph(int n){
            edges = new ArrayList[n];

            for (int i = 0; i < n; i++){
                edges[i] = new ArrayList<>();
            }
        }

        public void addEdge(int st, int en){
            edges[st].add(en);
        }
    }
    public static void allPaths(Graph g, int src, int dest){
        allPathsUtil(g, src, dest, "");
    }
    public static void allPathsUtil(Graph g, int src, int dest, String path){
        if (src == dest){
            System.out.println(path + dest);
        }

        for (int neigh : g.edges[src]){
            allPathsUtil(g, neigh, dest, path + src + " ");
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(5, 0);
        g.addEdge(5, 2);

        allPaths(g, 5, 1);
    }
}