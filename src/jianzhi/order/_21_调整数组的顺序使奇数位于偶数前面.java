package jianzhi.order;

public class _21_调整数组的顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            while (i < j && nums[i] % 2 == 1) i++;
            while (i < j && nums[j] % 2 == 0) j--;

            if (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp;
        tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        _21_调整数组的顺序使奇数位于偶数前面 solution = new _21_调整数组的顺序使奇数位于偶数前面();
        int[] nums = {4, 2, 6, 8, 1,3, 5,7};
        int[] res = solution.exchange(nums);

        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
