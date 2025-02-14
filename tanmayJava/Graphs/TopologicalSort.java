import java.util.*;

public class TopologicalSort{
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
    public static void topSort(Graph g){
        boolean[] visited = new boolean[g.graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < visited.length; i++){
            if (!visited[i]){
                topSortUtil(g, visited, s, i);
            }
        }

        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
    public static void topSortUtil(Graph g, boolean[] visited, Stack<Integer> s, int curr){
        visited[curr] = true;

        for (int neigh : g.graph[curr]){
            if (!visited[neigh]){
                topSortUtil(g, visited, s, neigh);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        topSort(g);
    }
}