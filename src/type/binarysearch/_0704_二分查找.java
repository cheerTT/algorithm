package type.binarysearch;

public class _0704_二分查找 {

    // 二分查找
    public int search(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;
        int mid = (i + j) / 2;
        while (i <= j) { // 此处==的含义很重要，当只有一个数的时候，很有可能就是我们要找的数
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
                mid = (i + j) / 2;
            } else {
                i = mid + 1;
                mid = (i + j) / 2;
            }
        }
        return -1;
    }
}
