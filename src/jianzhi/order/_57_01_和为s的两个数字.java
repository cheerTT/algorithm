package jianzhi.order;

public class _57_01_和为s的两个数字 {

    // 排序数组指定和
    // 双指针解决
    public int[] twoSum(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                return new int[] {nums[i], nums[j]};
            }
        }
        return null;
    }
}
