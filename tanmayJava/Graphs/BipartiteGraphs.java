public class BipartiteGraphs {
    public static boolean isBP(GraphImplementation.Graph g) {
        Integer[] color = new Integer[g.size]; // Color array (0 or 1)

        for (int i = 0; i < g.size; i++) {
            if (color[i] == null) { // If node is not colored, start DFS
                if (!isBPUtil(g, color, i, 0)) {
                    return false; // Graph is not bipartite
                }
            }
        }
        return true; // Graph is bipartite
    }

    private static boolean isBPUtil(GraphImplementation.Graph g, Integer[] color, int curr, int myCol) {
        if (color[curr] != null) {
            return color[curr] == myCol; // If already colored, check if it matches expected
        }

        color[curr] = myCol; // Assign color

        for (GraphImplementation.Edge e : g.getEdges(curr)) { // Iterate through edges
            if (!isBPUtil(g, color, e.end, 1 - myCol)) { // Recur with opposite color
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GraphImplementation.Graph g = new GraphImplementation.Graph(4);

        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 0, 1); // Even-length cycle (Bipartite)

        if (isBP(g)) {
            System.out.println("Is Bipartite");
        } else {
            System.out.println("Is NOT Bipartite");
        }

        GraphImplementation.Graph g2 = new GraphImplementation.Graph(3);
        g2.addEdge(0, 1, 1);
        g2.addEdge(1, 2, 1);
        g2.addEdge(2, 0, 1); // Odd-length cycle (Not Bipartite)

        if (isBP(g2)) {
            System.out.println("Is Bipartite");
        } else {
            System.out.println("Is NOT Bipartite");
        }
    }
}
