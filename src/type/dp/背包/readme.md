#### 背包问题代码模板
有一个容量为 N 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。

dp[i][j] 存储物品的最大价值。
dp[i][j] 表示前i件物品体积不超过j能达到的最大价值。

分析：
第 i 件物品没有放到背包：dp[i][j] = dp[i - 1][j]
第 i 件 物品放到背包：dp[i][j] = dp[i - 1][j - w] + v
因此，0-1背包的状态转移方程是 dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w] + v)

```java 
// W 为背包总体积
// N 为物品数量
// weights 数组存储 N 个物品的重量
// values 数组存储 N 个物品的价值
public int knapsack(int W, int N, int[] weights, int[] values) {
    int[][] dp = new int[N + 1][W + 1];
    for (int i = 1; i <= N; i++) {
        int w = weights[i - 1], v = values[i - 1];
        for (int j = 1; j <= W; j++) {
            if (j >= w) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[N][W];
}
```

空间优化：前i件物品的状态仅与前i-1件物品的状态有关，因此可以将dp定义为一维数组，其中dp[j]
既可以表示dp[i-1][j]也可以表示dp[i][j],此时状态转移方程变化为：
dp[j] = max(dp[j], dp[j - w] + v)
```java 
public int knapsack(int W, int N, int[] weights, int[] values) {
    int[] dp = new int[W + 1];
    for (int i = 1; i <= N; i++) {
        int w = weights[i - 1], v = values[i - 1];
        for (int j = W; j >= 1; j--) {
            if (j >= w) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
    }
    return dp[W];
}
```