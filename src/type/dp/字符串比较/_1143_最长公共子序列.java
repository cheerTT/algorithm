package type.dp.字符串比较;

public class _1143_最长公共子序列 {

    // 删除一些字符仍然保证原来的顺序
    // 输入：text1 = "abcde", text2 = "ace"
    // 输出：3
    // dp[i][j] 从 text1 的 i 到 text2 的 j 所需要匹配的值
    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
