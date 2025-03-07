public class MinimumPartitioning{
    public static int minPart(int[] arr, int tSum){
        int n = arr.length;
        int sum = tSum/2;

        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < sum+1; i++){
            dp[0][i] = 0;
        }

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < sum+1; j++){
                if (arr[i-1] <= j){
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return tSum - (2*dp[n][sum]);
    }
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int sum = 0;
        for (int e : arr){
            sum += e;
        }

        System.out.println(minPart(arr, sum));
    }
}