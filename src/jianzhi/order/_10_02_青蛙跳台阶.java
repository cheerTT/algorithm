package jianzhi.order;

// 青蛙跳台阶，一次跳一步或者两步，一共有多少种跳法；
public class _10_02_青蛙跳台阶 {

    // 动态规划
    // dp[0] = 0, dp[1] = 1;
    // dp[n] = dp[n - 1] + dp[n - 2]
    public int numWays(int n) {
        int a = 0;
        int b = 1;
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
