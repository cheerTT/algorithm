package jianzhi.order;

public class _51_数组中的逆序对 {

    // 归并排序变种
    // 时间复杂度 O(nlogn)
    // 空间复杂度 O(n)
    public int reversePairs(int[] nums) {

        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;

        return binarySearch(nums, left, mid) +
                binarySearch(nums, mid + 1, right) +
                merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;

        int[] help = new int[right - left + 1];
        int k = 0;
        int res = 0;

        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) { // 所谓逆序，就是前面比后面大
                res += (mid - i + 1);
            }

            help[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid) {
            help[k++] = nums[i++];
        }

        while (j <= right) {
            help[k++] = nums[j++];
        }

        for (int l = left; l <= right; l++) {
            nums[l] = help[l - left];
        }

        return res;
    }

    public static void main(String[] args) {

        _51_数组中的逆序对 solution = new _51_数组中的逆序对();
        int[] nums = {7, 5, 6, 4};
        int res = solution.reversePairs(nums);
        System.out.println(res);
    }
}
