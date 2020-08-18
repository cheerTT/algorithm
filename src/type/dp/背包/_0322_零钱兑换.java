package type.dp.背包;

public class _0322_零钱兑换 {

    // 最少的硬币个数组合
    // dp[i] 表示价格为 i 时候的最少硬币数
    // 完全背包，物品数量可以重复
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            dp[i] = i == 0 ? 0 : amount + 1;
            for (int coin : coins) { // 完全背包的时候元素放里面
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
