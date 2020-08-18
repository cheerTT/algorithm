package type.dp.背包;

public class _0377_组合总和4 {

    // 和为 0 的时候，组合个数为 1
    // 顺序完全背包
    // dp[i] 和为 i 的时候，组合个数
    public int combinationSum4(int[] nums, int target) {

        if (nums.length == 0) return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
