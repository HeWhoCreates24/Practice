
import java.util.Arrays;

public class EditDistance{
    public static int ed(String str1, String str2, int n, int m, int[][] dp){
        if (n == 0) return m;
        if (m == 0) return n;

        if (dp[n][m] != -1) return dp[n][m];

        if (str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = ed(str1, str2, n-1, m-1, dp);
        }else{
            dp[n][m] = 1 + Math.min(ed(str1, str2, n, m-1, dp), Math.min(ed(str1, str2, n-1, m-1, dp), ed(str1, str2, n-1, m, dp)));
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "intention", str2 = "execution";

        int n = str1.length(), m = str2.length();

        int[][] dp = new int[n+1][m+1];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        System.out.println(ed(str1, str2, n, m, dp));
    }
}