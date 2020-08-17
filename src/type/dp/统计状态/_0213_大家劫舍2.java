package type.dp.统计状态;

public class _0213_大家劫舍2 {

    // 环形打家劫舍，不能搞相邻
    // 包含第一与比包含第一的最大值
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(help(nums, 0, n - 2), help(nums, 1, n - 1));
    }

    private int help(int[] nums, int start, int end) {

        int pre1 = 0;
        int pre2 = 0;

        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre2, pre1 + nums[i]);
            pre1 = pre2;
            pre2 = cur;
        }

        return pre2;
    }
}
