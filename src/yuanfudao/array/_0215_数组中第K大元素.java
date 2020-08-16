package yuanfudao.array;

import java.util.Random;

public class _0215_数组中第K大元素 {

    // 快排中划分 O(n)(随机) O(logn) 栈空间
    // 堆 O(nlogn)  O(logn)
    // [3,2,1,5,6,4] 和 k = 2
    public int findKthLargest(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;
        int mid = partition(nums, left, right);
        k = nums.length - k - 1;
        while (mid != k) {
            if (mid < k) {
                left = mid + 1;
                mid = partition(nums, left, right);
            } else {
                right = mid - 1;
                mid = partition(nums, left, right);
            }
        }
        return nums[mid];
    }

    private int partition(int[] nums, int left, int right) {

        Random random = new Random();
        int idx = random.nextInt(right - left + 1) + left;
        swap(nums, left, idx);
        int i = left;
        int j = right;
        int selected = left;

        while (i < j) {
            while (i < j && nums[i] > nums[selected]) j--;
            while (i < j && nums[j] <= nums[selected]) i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, selected, i);

        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {

        Random random = new Random();

        System.out.println(random.nextInt(100) % (100 - 10 + 1) + 10);
        System.out.println(random.nextInt(100) % (100 - 10 + 1) + 10);
        System.out.println(random.nextInt(100) % (100 - 10 + 1) + 10);
        System.out.println(random.nextInt(100) % (100 - 10 + 1) + 10);
        System.out.println(random.nextInt(100) % (100 - 10 + 1) + 10);
        System.out.println(random.nextInt(100) % (100 - 10 + 1) + 10);
        System.out.println(random.nextInt(100) % (100 - 10 + 1) + 10);
        System.out.println(random.nextInt(100) % (100 - 10 + 1) + 10);

        System.out.println(random.nextInt(1) + 0);
    }
}
