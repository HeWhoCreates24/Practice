public class RodCutting{
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int rod = 8;

        int n = length.length;
        int[][] dp = new int[n+1][rod+1];

        // for (int i = 0; i < n+1; i++){
        //     dp[i][0] = 0;
        // }
        // for (int i = 0; i < rod+1; i++){
        //     dp[0][i] = 0;
        // }

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < rod+1; j++){
                if (length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][rod]);
    }
}