package yuanfudao.array;

import com.sun.xml.internal.bind.v2.runtime.NameBuilder;

public class _0189_旋转数组 {

    // 至少有三种方法
    // 输入： 1,2,3,4,5,6,7 k = 3
    // 输出： 5,6,7,1,2,3,4
    // 时间复杂度 O(n) 空间复杂度 O(1)
    public void rotate(int[] nums, int k) {

        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int a, int b) {

        while (a < b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
            a++;
            b--;
        }
    }

}
