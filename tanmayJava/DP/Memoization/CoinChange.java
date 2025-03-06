
public class CoinChange{
    public static int change(int[] coins, int sum, int i, int[][] dp){
        if (i == 0){
            return 0;
        }
        else if (i == 1){
            return sum % coins[0] == 0 ? 1 : 0;
        }
        if (dp[i][sum] != 0) return dp[i][sum];

        if (coins[i-1] <= sum){
            dp[i][sum] = change(coins, sum-coins[i-1], i, dp) + change(coins, sum, i-1, dp);
        }else{
            dp[i][sum] = change(coins, sum, i-1, dp);
        }

        return dp[i][sum];
    }
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;

        int[][] dp = new int[coins.length+1][sum+1];

        for (int i = 0; i < coins.length+1; i++){
            dp[i][0] = 1;
        }

        System.out.println(change(coins, sum, coins.length, dp));

        // for (int[] row : dp){
        //     for (int cell : row){
        //         System.out.print(cell + " ");
        //     }
        //     System.out.println();
        // }
    }
}