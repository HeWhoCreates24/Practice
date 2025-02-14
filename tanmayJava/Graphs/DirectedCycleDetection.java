import java.util.*;

public class DirectedCycleDetection{
    public static class Graph{
        public ArrayList<Integer>[] graph;

        @SuppressWarnings("unchecked")
        public Graph(int n){
            graph = new ArrayList[n];

            for (int i = 0; i < n; i++){
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int st, int en){
            graph[st].add(en);
        }
    }
    public static boolean isCyclic(Graph g){
        boolean[] visited = new boolean[g.graph.length];
        boolean[] stack = new boolean[visited.length];

        for (int i = 0; i < visited.length; i++){
            if (!visited[i]){
                if (isCyclicUtil(g, visited, stack, i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCyclicUtil(Graph g, boolean[] visited, boolean[] stack, int curr){
        visited[curr] = true;
        stack[curr] = true;

        for (int neigh : g.graph[curr]){
            if (stack[neigh]){
                return true;
            }
            if (!visited[neigh]){
                if (isCyclicUtil(g, visited, stack, neigh)){
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        // g.addEdge(3, 1);

        if (isCyclic(g)){
            System.out.println("cycle detected");
        }else{
            System.out.println("cycle NOT detected");
        }
    }
}