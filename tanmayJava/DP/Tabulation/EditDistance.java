
import java.util.Arrays;

public class EditDistance{
    public static int ed(String str1, String str2){
        int n = str1.length(), m = str2.length();

        int[][] dp = new int[n+1][m+1];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        for (int i = 0; i < n+1; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i < m+1; i++){
            dp[0][i] = i;
        }

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "intention", str2 = "execution";
        System.out.println(ed(str1, str2));
    }
}