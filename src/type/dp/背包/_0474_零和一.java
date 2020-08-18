package type.dp.背包;

public class _0474_零和一 {

    // 多维背包
    // dp[i][j] 表示 i 个 0, j 个 1能够组成的组最多字符串
    // dp[0][0] 表示 0 个 0， 0 个 1 能够组成 0 个字符串
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int[] cal = calString(str);
            for (int i = m; i >= cal[0]; i--) {
                for (int j = n; j >= cal[1]; j--) {
                    // 背包问题总是喜欢从后往前计算
                    dp[i][j] = Math.max(dp[i][j], dp[i - cal[0]][j - cal[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private int[] calString(String str) {

        int[] res = new int[2];

        for (char c : str.toCharArray()) {
            res[c - '0']++;
        }

        return res;
    }
}
