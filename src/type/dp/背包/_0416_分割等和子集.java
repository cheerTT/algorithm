package type.dp.背包;

public class _0416_分割等和子集 {

    // dp[i] 和为 i 的时候，是否可以划分
    // dp[i][j] 把前 i 物品，当背包容量为 j 时，状态为 true
    public boolean canPartition(int[] nums) {

        int sum = sum(nums);
        if (sum % 2 != 0) return false;

        int W = sum / 2;
        int N = nums.length;
        boolean[][] dp = new boolean[N + 1][W + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= N; i++) { // 遍历背包
            for (int j = 1; j <= W; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] | dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][W];
    }

    private int sum(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res += num;
        }

        return res;
    }

    // 空间压缩
    public boolean canPartition1(int[] nums) {

        int sum = sum(nums);
        if (sum % 2 != 0) return false;
        int W = sum / 2;

        boolean[] dp = new boolean[W + 1];
        dp[0] = true;  // 没放物品时肯定是 true
        for (int num : nums) {
            for (int i = W; i >= num ; i--) {
                // 从后往前，先计算dp[i],再计算dp[i - num]
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {

    }
}
