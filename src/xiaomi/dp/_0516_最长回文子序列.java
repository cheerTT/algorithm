package xiaomi.dp;

public class _0516_最长回文子序列 {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {

            dp[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        _0516_最长回文子序列 solution = new _0516_最长回文子序列();
        int res = solution.longestPalindromeSubseq("a");
        System.out.println(res);
    }

}
