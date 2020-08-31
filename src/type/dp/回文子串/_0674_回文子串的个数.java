package type.dp.回文子串;

public class _0674_回文子串的个数 {

    // dp[i][j] 从位置 i 到 位置 j 是否是回文子串
    public int countSubstrings(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int res = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i + 1 < 4) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) res++;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {

        _0674_回文子串的个数 solution = new _0674_回文子串的个数();
        int res = solution.countSubstrings("aaaaa");
        System.out.println(res);
    }
}
