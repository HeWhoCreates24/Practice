public class WildcardMatching{
    public static boolean match(String s, String p){
        int n = s.length(), m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for (int i = 1; i < m+1; i++){
            if (p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }

        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < m+1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "baaabab", p = "a****ab";
        // '?' can replace any single charecter
        // '*' can replace any sequence of charecters or empty space
        // return true if pattern can be converted to string

        System.out.println(match(s, p));
    }
}