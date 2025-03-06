public class LongestCommonSubstring {
    public static int lcs(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1]; // DP table
        int maxLength = 0; // Track max substring length

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Extend substring
                    maxLength = Math.max(maxLength, dp[i][j]); // Track max length
                } else {
                    dp[i][j] = 0; // Reset if characters don't match
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str1 = "abcde", str2 = "abgce";
        System.out.println("Length of Longest Common Substring: " + lcs(str1, str2));
    }
}
