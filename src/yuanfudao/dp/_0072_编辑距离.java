package yuanfudao.dp;


public class _0072_编辑距离 {

    // dp[i][j] 字符从前 i 变为前 j，需要的最少步数
    // 若当前字符相同，则 dp[i][j] = dp[i - 1][j - 1]
    // 否则 为增删改的最小 + 1
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i -1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
