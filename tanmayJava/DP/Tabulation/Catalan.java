public class Catalan{
    public static void main(String[] args) {
        int n = 4;

        int[] dp = new int[n+1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i < n+1; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        // for (int num : dp) System.out.print(num + " ");

        System.out.println(dp[n]);
    }
}