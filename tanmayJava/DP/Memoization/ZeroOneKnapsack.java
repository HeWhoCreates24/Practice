

public class ZeroOneKnapsack{
    public static int knapsack(int[] val, int[] wt, int w, int n, int[][] dp){
        if (w == 0 || n == 0) return 0;

        if (dp[w][n] != 0){
            return dp[w][n];
        }

        if (w >= wt[n-1]){
            int ans1 = val[n-1] + knapsack(val, wt, w-wt[n-1], n-1, dp);
            int ans2 = knapsack(val, wt, w, n-1, dp); 
            dp[w][n] = Math.max(ans1, ans2);
            return dp[w][n];
        }

        dp[w][n] = knapsack(val, wt, w, n-1, dp);
        return dp[w][n];
    }
    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int w = 7;

        int[][] dp = new int[w+1][val.length+1];

        System.out.println(knapsack(val, wt, w, 5, dp));
    }
}