public class ClimbingStairs{
    public static int climbStair(int n, int[] dp){
        if (n == 0 || n == 1) return 1;
        if (n == 2 || n == 3) return n;
        if (dp[n] == 0) dp[n] = climbStair(n-1, dp) + climbStair(n-2, dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;

        int[] dp = new int[n+1];
        // dp[i] = ways to reach ith stair

        System.out.println(climbStair(n, dp));
    }
}