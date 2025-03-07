public class LongestCommonSubstring{
    public static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < m+1; i++){
            dp[0][i] = 0;
        }

        int ans = 0;

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if (dp[i][j] > ans) ans = dp[i][j];
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String str1 = "abcde", str2 = "abgce";
        System.out.println(lcs(str1, str2));
    }
}