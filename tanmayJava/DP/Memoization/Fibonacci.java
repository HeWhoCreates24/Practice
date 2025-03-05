public class Fibonacci{
    public static int fib(int n, int[] dp){
        if (n == 0 || n == 1){
            return n;
        }

        if (dp[n] == 0){
            dp[n] = fib(n-1, dp) + fib(n-2, dp);
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n+1];
        // dp[i] = ith fibonacci
        System.out.println(fib(n, dp));
    }
}