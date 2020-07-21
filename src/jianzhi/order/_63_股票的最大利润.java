package jianzhi.order;

public class _63_股票的最大利润 {

    // 7 1 5 3 6 4
    // 遍历
    public int maxProfit1(int[] prices) {

        int res = 0;
        int m = prices[0];

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - m);
            m = Math.min(m, prices[i]);
        }

        return res;
    }

    // 动态规划
    public int maxProfit2(int[] prices) {

        int n = prices.length;
        //  dp[0] 买
        //  dp[1] 卖
        int[] dp = new int[2];

        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }

        return dp[0];
    }

    public static void main(String[] args) {

        _63_股票的最大利润 solution = new _63_股票的最大利润();
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
        int res1 = solution.maxProfit1(prices);
        System.out.println(res1);

        int res2 = solution.maxProfit2(prices);
        System.out.println(res2);
    }

}
