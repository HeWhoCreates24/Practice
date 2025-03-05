public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] values = {15, 14, 10, 45, 30};
        int[] weights = {2, 5, 1, 3, 4};
        int capacity = 7;

        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Initialize base cases
        for (int cap = 0; cap <= capacity; cap++) {
            dp[0][cap] = 0;
        }
        for (int items = 0; items <= n; items++) {
            dp[items][0] = 0;
        }

        // Fill DP table
        for (int items = 1; items <= n; items++) {
            for (int cap = 1; cap <= capacity; cap++) {
                if (weights[items - 1] <= cap) {
                    dp[items][cap] = Math.max(
                        values[items - 1] + dp[items][cap - weights[items - 1]],  // Include item
                        dp[items - 1][cap]  // Exclude item
                    );
                } else {
                    dp[items][cap] = dp[items - 1][cap];
                }
            }
        }

        int maxValue = dp[n][capacity];
        System.out.println("Maximum value: " + maxValue);
        
        // Reconstruct solution
        printSelectedItems(dp, values, weights, capacity);
    }

    private static void printSelectedItems(int[][] dp, int[] values, int[] weights, int capacity) {
        int items = values.length;
        int cap = capacity;
        System.out.println("Selected items (value, weight):");
        
        while (cap > 0 && items > 0) {
            if (dp[items][cap] != dp[items - 1][cap]) {
                System.out.println("(" + values[items - 1] + ", " + weights[items - 1] + ")");
                cap -= weights[items - 1];
            } else {
                items--;
            }
        }
    }
}