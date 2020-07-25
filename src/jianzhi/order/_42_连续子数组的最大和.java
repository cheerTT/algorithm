package jianzhi.order;

public class _42_连续子数组的最大和 {

    // [-2,1,-3,4,-1,2,1,-5,4]
    // 动态规划
    // dp[i] 前 i 个数的最大值
    // dp[i] = nums[i] > 0 ? dp[i - 1] + nums[i] : dp[i - 1]
    public int maxSubArray(int[] nums) {

        int res = nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 遍历数组
    public int maxSubArray1(int[] nums) {

        int res = nums[0];
        int tmp = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果加了当前值却变小了的话，说明要将当前值置位新的起点
            tmp = Math.max(nums[i], tmp + nums[i]);
            res = Math.max(res, tmp);
        }

        return res;
    }
}
