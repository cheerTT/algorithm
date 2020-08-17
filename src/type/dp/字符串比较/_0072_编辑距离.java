package type.dp.字符串比较;

public class _0072_编辑距离 {

    // 通过插入、删除、替换把一个字符串转化为另一个字符串
    // dp[i][j] word1 的前 i 个字母转化为 word2 的前 j 个字母需要的步数
    // 若当前字母相同，为 dp[i][j] = dp[i-1][j-1]
    // 则为增删替最小+1，为 dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][i+1]) + 1
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
