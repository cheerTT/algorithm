package hot;

public class _nc_044_通配符匹配 {

    // dp[i][j] 表示 s字符串的前 i 个字符与 p 字符串的前 j 个字符是否匹配
    // 若当前匹配则 dp[i][j] = dp[i - 1][j - 1]
    // 若不匹配但是是 *: dp[i][j] = dp[i - 1][j] | dp[i][j - 1]
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        // 处理连续 * 情况
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) != '*') break;
            dp[0][j] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
