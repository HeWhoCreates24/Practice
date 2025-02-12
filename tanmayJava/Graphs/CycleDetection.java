public class CycleDetection{
    public static boolean hasCycle(GraphImplementation.Graph g){
        boolean[] visited = new boolean[g.size];

        for (int i = 0; i < g.size; i++){
            if (hasCycleUtil(g, visited, i, -1)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycleUtil(GraphImplementation.Graph g, boolean[] visited, int curr, int parent){
        visited[curr] = true;

        for (GraphImplementation.Edge e : g.getEdges(curr)){
            if (visited[e.end] && e.end != parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        GraphImplementation.Graph g = new GraphImplementation.Graph(5);

        g.addEdge(0, 1, 1);
        // g.addEdge(0, 2, 1);
        g.addEdge(0, 3, 1);

        g.addEdge(1, 0, 1);
        g.addEdge(1, 2, 1);
        
        // g.addEdge(2, 0, 1);
        g.addEdge(2, 1, 1);
        
        g.addEdge(3, 0, 1);
        g.addEdge(3, 4, 1);
        
        g.addEdge(4, 3, 1);

        if (hasCycle(g)){
            System.out.println("cycle detected");
        }else{
            System.out.println("cycle NOT detected");
        }
    }
}