package type.dp.字符串比较;

public class _0044_通配符比较 {

    // dp[i][j] s前i与p前j个元素的对应情况
    public boolean isMatch(String s, String p) {

        int len1 = s.length();
        int len2 = p.length();

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        // 初始化
        for (int j = 1; j <= len2; j++) {
            if (p.charAt(j - 1) != '*') break;
            dp[0][j] = true;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {

        _0044_通配符比较 solution = new _0044_通配符比较();

        boolean res = solution.isMatch("aa", "aa");
        System.out.println(res);
    }
}
