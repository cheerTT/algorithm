package type.binarysearch;

/**
 * [1,1,2,2,3,3,4,5,5,6,6,7,7......]有序数组中唯一的数，输出4。要求时间复杂度o(lgn)
 */
public class _540_有序数组中的单一元素 {

    // 位运算，时间复杂度 O(N)


    // 二分法
    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) /2;

            boolean has = mid % 2 == 0;

            // 当中间数和前面数相同时
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                // 若当前索引为偶数，则在左边
                if (has) {
                    right = mid - 2;
                } else {
                    left  = mid + 1;
                }
            } else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                // 若当前索引为偶数，则在右边
                if (has) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        _540_有序数组中的单一元素 solution = new _540_有序数组中的单一元素();

        int[] nums = {1,1,2,2,3,3,4,5,5,6,6,7,7};
        int res = solution.singleNonDuplicate(nums);
        System.out.println(res);
    }

}
