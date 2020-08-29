package type.dp.字符串比较;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Arrays;

public class _0673_最长递增子序列的个数 {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;

        int[] dp = new int[n];
        int[] counters = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(counters, 1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        counters[i] = counters[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counters[i] += counters[j];
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == res) {
                ans += counters[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        _0673_最长递增子序列的个数 solution = new _0673_最长递增子序列的个数();
        int[] nums = new int[] {1, 3, 5, 4, 7};
        int res = solution.findNumberOfLIS(nums);
        System.out.println(res);
    }

}
