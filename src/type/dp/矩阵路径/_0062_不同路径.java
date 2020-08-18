package type.dp.矩阵路径;

public class _0062_不同路径 {

    // dp[i][j] 代表走到位置 (i, j) 一共有多少种不同的走法
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // 初始化
        // 走到位置 (0, j) 和 (i, 0) 的走法均为 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
