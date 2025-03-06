public class LongestCommonSubsequence {
    public static int lcs(String str1, String str2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            dp[i][j] = 1 + lcs(str1, str2, i - 1, j - 1, dp);
        } else {
            dp[i][j] = Math.max(lcs(str1, str2, i - 1, j, dp), lcs(str1, str2, i, j - 1, dp));
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        String str1 = "abcde", str2 = "ace";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Length of LCS: " + lcs(str1, str2, str1.length(), str2.length(), dp));
    }
}
