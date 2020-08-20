package hot;

public class _nc_35_最小编辑代价 {

    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {

        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + ic;
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + dc;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
            }
        }

        return dp[m][n];
    }

}
