package type.dp.字符串比较;

import java.util.Arrays;

public class _0674_最长连续递增序列 {

    // dp[i] 表示以 nums[i] 结尾，最长递增子序列的个数
    // 当 nums[i] > nums[i - 1] 时，dp[i] = dp[i - 1] + 1;
    // 用最后的 res 表示结果变量
    // 时间复杂度 O(n)
    public int findLengthOfLCIS(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }
}
