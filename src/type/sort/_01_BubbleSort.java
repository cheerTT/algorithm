package type.sort;

public class _01_BubbleSort {

    public void bubbleSort(int[] nums) {

        // 每次交换相邻两个数
        //
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        _01_BubbleSort solution = new _01_BubbleSort();
        int[] nums = {2, 1, -1, 6, 7, 8, 4, 0, 2};
        solution.bubbleSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
