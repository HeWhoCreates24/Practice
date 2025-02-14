import java.util.*;

public class KahnsAlgorithm{
    public static class Graph{
        public ArrayList<Integer>[] edges;
        public int[] inDeg;

        @SuppressWarnings("unchecked")
        public Graph(int n){
            edges = new ArrayList[n];
            inDeg = new int[n];

            for (int i = 0; i < n; i++){
                edges[i] = new ArrayList<>();
            }
        }

        public void addEdge(int st, int en){
            edges[st].add(en);
            inDeg[en]++;
        }
    }
    public static void topSort(Graph g){
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < g.edges.length; i++){
            if (g.inDeg[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int curr = q.remove();

            for (int neigh : g.edges[curr]){
                g.inDeg[neigh]--;
                if (g.inDeg[neigh] == 0){
                    q.add(neigh);
                }
            }

            System.out.print(curr + " ");
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(5, 0);
        g.addEdge(5, 2);

        topSort(g);
    }
}