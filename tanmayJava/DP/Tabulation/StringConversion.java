import java.util.*;
public class StringConversion{
    public static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        for (int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < m+1; i++){
            dp[0][i] = 0;
        }

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
    public static int convert(String str1, String str2){
        int lcs = lcs(str1, str2);

        return str1.length() + str2.length() - 2*lcs;
    }
    public static void main(String[] args) {
        String str1 = "pear", str2 = "sea";

        System.out.println(convert(str1, str2));
    } 
}