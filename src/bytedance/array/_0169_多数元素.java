package bytedance.array;

public class _0169_多数元素 {

    // 数字统计
    // 题目假定总是存在满足条件的数
    // 时间复杂度 O(n)
    public int majorityElement(int[] nums) {

        int cnt = 0;

        int cur = 0;

        for (int num : nums) {
            if (cnt == 0) {
                cur = num;
            }
            if (cur == num) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return cur;
    }

    // 快排划分
    // 时间复杂度 O(nlogn)
    public int majorityElement1(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        int curId = partition(nums, left, right);
        while (curId != mid) {
            if (curId < mid) {
                right = curId + 1;
                curId = partition(nums, left, right);
            } else {
                left = curId + 1;
                curId = partition(nums, left, right);
            }
        }
        return nums[curId];
    }

    private int partition(int[] nums, int left, int right) {

        int i = left;
        int j = right;
        int compId = left;

        while (i < j) {
            while (i < j && nums[j] > nums[compId]) j--;
            while (i < j && nums[i] <= nums[compId]) i++;

            if (i < j) {
                swap(nums, i, j);
            }
        }

        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {

        _0169_多数元素 solution = new _0169_多数元素();
        int[] nums = {2,2,1,1,1,2,2};
        int res = solution.majorityElement(nums);
        System.out.println(res);
    }
}
