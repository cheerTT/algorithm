package yuanfudao.dp;

public class _0562_矩阵中最长的连续1线段 {

    // dp[i][j][k] 从 (0, 0) 到 (i, j) 上 k 状态的最长连续1线程的个数
    public int longestLine(int[][] matrics) {

        int m = matrics.length;
        int n = matrics[0].length;

        int[][][] dp = new int[m][n][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrics[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = 1;
                }
                if (j > 0) dp[i][j][0] += dp[i][j - 1][0];
                if (i > 0) dp[i][j][1] += dp[i][j - 1][1];
                if (i > 0 && j < n - 1) dp[i][j][2] += dp[i + 1][j - 1][2];
                if (i > 0 && j > 0) dp[i][j][3] += dp[i - 1][j - 1][3];
            }
        }

        int res = -1;

        res = Math.max(res, Math.max(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1]));
        res = Math.max(res, Math.max(dp[m - 1][n - 1][2], dp[m - 1][n - 1][3]));

        return res;
    }

    public static void main(String[] args) {

        int[][] matrics = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};

        _0562_矩阵中最长的连续1线段 solution = new _0562_矩阵中最长的连续1线段();
        int res = solution.longestLine(matrics);
        System.out.println(res);  // 3
    }
}
