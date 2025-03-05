public class Fibonacci{
    public static void main(String[] args) {
        int n = 9;

        int[] dp = new int[n+1];
        // dp[i] = ith fibonacci
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }
}