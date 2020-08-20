package hot;

public class _nc_07_买股票的最佳时机 {

    // 只有买入之后才可以卖出，只有一次交易机会
    // dp[i][0] 买入 i 后的最大利润
    // dp[i][1] 卖出 i 后的最大利润
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

    // 对空间进行优化
    // 我们发现，当前结果仅仅依赖上一次的结果
    public int maxProfit1(int[] prices) {

        int n = prices.length;
        if (n == 0) return 0;

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }

        return dp[0];
    }
}
