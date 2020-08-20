package hot;

import sun.reflect.generics.tree.Tree;

public class _nc_17_最长回文子串 {

    // 计算最长回文子串的长度
    // dp[i][j] 从 i 到 j 是否为回文子串
    public int getLongestPalindrome(String A, int n) {

        if (n < 2) return n;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (A.charAt(i) != A.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 当相等时，小于 3 肯定是回文串
                    if (j - i + 1 < 4) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                }
            }
        }

        return maxLen;
    }
}
