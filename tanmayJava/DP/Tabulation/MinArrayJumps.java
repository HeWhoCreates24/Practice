
import java.util.Arrays;

public class MinArrayJumps{
    public static int minJumps(int[] arr){
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++){
            int jumps = dp[i-1] + 1;
            for (int j = 0; j < i; j++){
                if (j + arr[j] == i){
                    jumps = Math.min(jumps, dp[j] + 1);
                }
            }
            dp[i] = jumps;
        }

        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};

        System.out.println(minJumps(arr));
    }
}