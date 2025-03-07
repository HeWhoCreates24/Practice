import java.util.*;

public class MCM{
    public static int mcm(int[] arr, int i, int j, int[][] dp){
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++){
            int temp = arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans, temp + mcm(arr, i, k, dp) + mcm(arr, k+1, j, dp));
        }

        return dp[i][j] = ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        int n = arr.length;

        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        System.out.println(mcm(arr, 1, 4, dp));
    }
}