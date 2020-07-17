package jianzhi.order;

/**
 * 2,3,1,0,2,5,3
 *
 * 2 or 3
 */
public class _03_数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, nums[i], nums[nums[i]]);
            }

        }

        return -1;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {

        _03_数组中重复的数字 solution = new _03_数组中重复的数字();
        int res = solution.findRepeatNumber(new int[] {2,3,1,0,2,5,3});
        System.out.println(res);
    }
}
