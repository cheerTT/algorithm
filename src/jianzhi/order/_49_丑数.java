package jianzhi.order;

public class _49_丑数 {

    // 动态规划
    public int nthUglyNumber(int n) {

        int p2 = 0, p3 = 0, p5 = 0;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[p2] * 2 == dp[i]) p2++;
            if (dp[p3] * 3 == dp[i]) p3++;
            if (dp[p5] * 5 == dp[i]) p5++;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        _49_丑数 solution = new _49_丑数();

        int res = solution.nthUglyNumber(10);
        System.out.println(res);
    }
}
