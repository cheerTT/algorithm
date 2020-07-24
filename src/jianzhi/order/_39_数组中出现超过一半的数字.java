package jianzhi.order;

public class _39_数组中出现超过一半的数字 {

    // 快排划分,判断元素是否占了一半以上才符合
    // hash表
    // [1, 2, 3, 2, 2, 2, 5, 4, 2]
    // 时间复杂度 O(nlogn)
    public int majorityElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        int idx = partition(nums, left, right);
        while (mid != idx) {
            if (idx > mid) {
                right = idx - 1;
                idx = partition(nums, left, right);
            } else {
                left = idx + 1;
                idx = partition(nums, left, right);
            }
        }
        return isHalf(nums, nums[idx]) ? nums[idx] : 0;
    }

    private int partition(int[] nums, int left, int right) {

        int i = left;
        int j = right;
        int comp = i;

        while (i < j) {
            while (i < j && nums[j] > nums[comp]) j--;
            while (i < j && nums[i] <= nums[comp]) i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, i, comp);
        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private boolean isHalf(int[] nums, int val) {
        int count = 0;
        for (int num : nums) {
            if (num == val) {
                count++;
            }
        }
        return 2 * count > nums.length;
    }

    // 投票法，当值为 0 时，选中当前数作为投票对象
    // 时间复杂度 O(n)
    // 若不确定是否包含众数的情况下，需要加一个判断
    public int majorityElement1(int[] nums) {

        int res = 0;
        int votes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res == 0) votes = nums[i];
            if (nums[i] == votes) {
                res++;
            } else {
                res--;
            }
        }

        return votes;
    }
}
