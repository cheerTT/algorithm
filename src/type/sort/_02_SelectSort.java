package type.sort;

public class _02_SelectSort {

    // 选择排序
    // 每次保证当前的数是排序后的最终位置与后面的所有数字都比较一下
    public void selectSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[tmp] > nums[j]) {
                    tmp =  j;
                }
            }
            // 交换
            swap(nums, i, tmp);
        }

    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {

        _02_SelectSort solution = new _02_SelectSort();
        int[] nums = new int[] {-1, 2, 9, 0, 6, 4, 8, 3, 2};
        solution.selectSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
