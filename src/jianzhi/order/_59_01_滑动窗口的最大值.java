package jianzhi.order;

public class _59_01_滑动窗口的最大值 {

    // 1,3,-1,-3,5,3,6,7
    // 每个区间分别求最大值
    // 滑动窗口为一个左开右闭区间
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];

        int i = 0;
        int j = k;
        int l = 0;
        while (j <= nums.length) {
            res[l++] = max(nums, i++, j++);
        }

        return res;
    }

    private int max(int[] nums, int a, int b) {
        int res = nums[a];
        for (int i = a + 1; i < b; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
