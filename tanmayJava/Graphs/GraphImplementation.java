import java.util.*;
public class GraphImplementation{

    public static class Edge{

        int start;
        int end;
        int weight;

        public Edge(int st, int en, int w){
            start = st;
            end = en;
            weight = w;
        }
    }

    public static class Graph{

        ArrayList<Edge>[] graph;

        @SuppressWarnings("unchecked")
        public Graph(int n){

            graph = new ArrayList[n];

            for (int i = 0; i < n; i++){
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge (int st, int en, int w){

            graph[st].add(new Edge(st, en, w));
        }

        public void printBFS(){

            Queue<Integer> q = new LinkedList<>();
            q.add(0);

            boolean[] visited = new boolean[graph.length];

            while (!q.isEmpty()){

                int curr = q.remove();
                if (!visited[curr]){
                    System.out.print(curr + " ");
                    visited[curr] = true;
                    for (Edge e : graph[curr]){
                        if (!visited[e.end]) q.add(e.end);
                    }
                }
            }
        }

        public void printDFS(){

            boolean[] visited = new boolean[graph.length];

            Stack<Integer> s = new Stack<>();
            s.push(0);

            while (!s.isEmpty()){
                int curr = s.pop();

                if (!visited[curr]){
                    System.out.print(curr + " ");
                    visited[curr] = true;
                    for (int i = graph[curr].size()-1; i >= 0; i--){
                        Edge e = graph[curr].get(i);
                        if (!visited[e.end]) s.add(e.end);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // graph
        /*  0 ----- 1 ----- 3
            |             /   \
            |            /     \
            |           /       \
            |          /         \
            2 ------- 4 --------- 5 ------ 6
        */

       Graph g = new Graph(7);

       g.addEdge(0, 1, 1);
       g.addEdge(0, 2, 1);
       g.addEdge(1, 0, 1);
       g.addEdge(1, 3, 1);
       g.addEdge(2, 0, 1);
       g.addEdge(2, 4, 1);
       g.addEdge(3, 1, 1);
       g.addEdge(3, 4, 1);
       g.addEdge(3, 5, 1);
       g.addEdge(4, 2, 1);
       g.addEdge(4, 3, 1);
       g.addEdge(4, 5, 1);
       g.addEdge(5, 3, 1);
       g.addEdge(5, 4, 1);
       g.addEdge(5, 6, 1);
       g.addEdge(6, 5, 1);

       System.out.print("BFS : ");
       g.printBFS();
       System.out.println();
       System.out.print("DFS : ");
       g.printDFS();
    }
}