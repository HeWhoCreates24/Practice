import java.util.*;

public class CheapestFlightWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create adjacency list representation
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        // Queue to store [node, cost, stops]
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{src, 0, k + 1}); // k+1 because we count stops between src and dst
        
        // Array to store minimum cost to reach each node with remaining stops
        int[][] minCost = new int[n][k + 2];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            
            // If we reached destination
            if (node == dst) {
                return cost;
            }
            
            // If we have stops remaining
            if (stops > 0) {
                for (int[] next : graph.get(node)) {
                    int nextNode = next[0];
                    int price = next[1];
                    int newCost = cost + price;
                    
                    // If we found a cheaper path with current remaining stops
                    if (newCost < minCost[nextNode][stops - 1]) {
                        minCost[nextNode][stops - 1] = newCost;
                        pq.offer(new int[]{nextNode, newCost, stops - 1});
                    }
                }
            }
        }
        
        return -1; // No path found
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;
        
        int result = findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price: " + result);
    }
}