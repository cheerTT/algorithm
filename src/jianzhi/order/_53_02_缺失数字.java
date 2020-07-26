package jianzhi.order;

public class _53_02_缺失数字 {

    // 二分查找
    public int missingNumber(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == mid) i = mid + 1; // 当前相等，说明 mid 之前都没有问题
            else j = mid - 1;
        }

        return i;
    }
}
