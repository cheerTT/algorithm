package xiaomi.dp;

import java.util.Arrays;

public class _1312_让字符串成为回文串的最少插入次数 {

    // dp[i][j] 从 i 到 j 的最长回文串的长度
    public int minInsertions(String s) {

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

        return n - dp[0][n - 1];
    }

    public static void main(String[] args) {

        _1312_让字符串成为回文串的最少插入次数 solution = new _1312_让字符串成为回文串的最少插入次数();

        int res = solution.minInsertions("leetcode");

        System.out.println(res);
    }
}
