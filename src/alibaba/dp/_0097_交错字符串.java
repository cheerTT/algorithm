package alibaba.dp;

public class _0097_交错字符串 {

    // dp[i][j] s1前 i 个字符和 s2 前 j 个字符，能否组成 s3 前 i + j 个字符
    public boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len3 != len1 + len2) return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= len1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= len2 && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));

            }
        }

        return dp[len1][len2];
    }
}
