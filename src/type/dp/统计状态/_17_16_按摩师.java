package type.dp.统计状态;

public class _17_16_按摩师 {

    // 带有状态的 dp
    // dp[i] 第 i个预约的最大时长
    // dp[i] = max(dp[i -1], dp[i - 2] + nums[i])
    public int massage(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i -2] + nums[i]);
        }

        return dp[n - 1];
    }

    // 一直更普遍的做法，记住状态:
    //      dp[i][0] : 第 i 天不接受邀请的最大利润
    //      dp[i][1] : 第 i 天接受邀请的最大利润
    // 动态规划状态转移方程：
    //      dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
    //      dp[i][1] = dp[i - 1][0] + nums[i];
    public int massage1(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
