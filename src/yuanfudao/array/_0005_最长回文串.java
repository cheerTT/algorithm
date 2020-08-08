package yuanfudao.array;

public class _0005_最长回文串 {

    // 动态规划方程
    // s[i] == s[j] ? j - i + 1 < 4 ? dp[i][j] = true : dp[i][j] = dp[i + 1][j - 1] : dp[i][j] = false
    public String longestPalindrome(String s) {

        int n = s.length();
        if (n < 2) return s;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int begin = 0;
        int maxLen = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i + 1 < 4) {
                        // 当前字符为3，首尾相等，肯定是回文串
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {

        _0005_最长回文串 solution = new _0005_最长回文串();
        String res = solution.longestPalindrome("cbbd");
        System.out.println(res);
    }

}
