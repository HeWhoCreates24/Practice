public class ZeroOneKnapsack{
    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int w = 7;

        int[][] dp = new int[w+1][val.length+1];

        for (int i = 1; i <= w; i++){
            for (int j = 1; j <= val.length; j++){
                if (i >= wt[j-1]){
                    dp[i][j] = Math.max(dp[i-wt[j-1]][j-1] + val[j-1], dp[i-1][j-1]);
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        System.out.println(dp[w][val.length]);
    }
}