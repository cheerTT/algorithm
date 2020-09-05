package test.tonghuashun._0905;

public class _01 {

    public int[] move(int[] nums) {

        int k = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] == 0 && k == i) {
                k--;
            } else if (nums[i] == 0) {
                swap(nums, i, k--);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int a, int b) {

        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {

        _01 solution = new _01();

        int[] res = solution.move(new int[]{1, 2, 0, 0, 1, 9, 0, 0});

        for (int re : res) {
            System.out.print(re + " ");
        }

    }
}
