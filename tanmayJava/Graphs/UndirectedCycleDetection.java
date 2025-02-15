import java.util.*;
public class UndirectedCycleDetection{
    public static class Graph{
        ArrayList<Integer>[] graph;

        @SuppressWarnings("unchecked")
        public Graph(int n){
            graph = new ArrayList[n];

            for (int i = 0; i < n; i++){
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int src, int dest){
            graph[src].add(dest);
        }

        public ArrayList<Integer> getNeighbours(int node){
            return node < graph.length ? graph[node] : null;
        }
    }
    public static boolean hasCycle(Graph g){
        boolean[] visited = new boolean[g.graph.length];

        for (int i = 0; i < g.graph.length; i++){
            if (!visited[i]){
                if (hasCycleUtil(g, visited, i, -1)){
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean hasCycleUtil(Graph g, boolean[] visited, int curr, int par){
        visited[curr] = true;

        for (int neigh : g.getNeighbours(curr)){
            if (!visited[neigh]){
                if (hasCycleUtil(g, visited, neigh, curr)){
                    return true;
                }
            }else{
                if (neigh != par){
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        // g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.addEdge(0, 1);
        g.addEdge(2, 0);
        // g.addEdge(1, 2);
        g.addEdge(3, 2);
        g.addEdge(4, 3);

        if (hasCycle(g)){
            System.out.println("cycle detected");
        }else{
            System.out.println("cycle NOT detected");
        }
    }
}