package jianzhi.order;

public class _56_01_数组中数字出现的次数 {

    // 将两个不同的数分在不同组
    // 找到 mask, mask分组
    public int[] singleNumbers(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        int mask = 1;

        // 找到 mask 为 1 的那一位
        while ((res & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & nums[i]) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        return new int[] {a, b};
    }
}
