public class CycleDetection {
    public static boolean hasCycle(GraphImplementation.Graph g) {
        boolean[] visited = new boolean[g.size]; // Keeps track of visited nodes

        // Check for cycles in each connected component
        for (int i = 0; i < g.size; i++) {
            if (!visited[i]) {  // Only start DFS if node is not visited
                if (hasCycleUtil(g, visited, i, -1)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle found
    }

    private static boolean hasCycleUtil(GraphImplementation.Graph g, boolean[] visited, int curr, int parent) {
        visited[curr] = true;  // Mark the current node as visited

        for (GraphImplementation.Edge e : g.getEdges(curr)) {  
            int neighbor = e.end;

            if (!visited[neighbor]) {  
                // Recur for unvisited nodes
                if (hasCycleUtil(g, visited, neighbor, curr)) {
                    return true;
                }
            } else if (neighbor != parent) {  
                // If visited node is not the parent, a cycle is found
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphImplementation.Graph g = new GraphImplementation.Graph(5);

        g.addEdge(0, 1, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(3, 4, 1);

        // Uncommenting the line below will introduce a cycle
        // g.addEdge(2, 0, 1);

        if (hasCycle(g)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("Cycle NOT detected");
        }
    }
}
