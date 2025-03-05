public class TargetSumSubset{
    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 1, 3};
        int target = 10;

        int n = nums.length;

        boolean[][] dp = new boolean[n+1][target+1];
        for (int i = 0; i < n+1; i++){
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int num = nums[i - 1];
                if (j < num) {
                    // Can't include current number, take result without it
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Either exclude current number or include it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }

        System.out.println(dp[n][target]);
    }
}