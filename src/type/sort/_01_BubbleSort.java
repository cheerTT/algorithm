package type.sort;

public class _01_BubbleSort {

    public void bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
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
