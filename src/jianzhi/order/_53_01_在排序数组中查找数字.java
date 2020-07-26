package jianzhi.order;


public class _53_01_在排序数组中查找数字 {

    // 统计一个数字在排序数组中出现的次数
    // [5,7,7,8,8,10], target = 8
    // 二分查找，寻找左右边界；
    public int search(int[] nums, int target) {

        // 分别寻找左右边界
        return bs(nums, target + 1) - bs(nums, target);
    }

    // 二分查找
    private int bs(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {

        _53_01_在排序数组中查找数字 solution = new _53_01_在排序数组中查找数字();
        int[] nums = {5,7,7,8,8,10};
        int res = solution.bs(nums, 8);
        System.out.println(res);
    }
}
