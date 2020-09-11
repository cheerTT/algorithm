package test.youzan._0911;

import java.util.Arrays;

/**
 *
 * 一个数组，每次改变一个值，加一个步长，1 或 -1，是的每个值都相等，求至少相加的次数
 *
 * [1, 2, 4] -> 3
 * [1, 2, 4] -> [2, 2, 4] -> [2, 2, 3] -> [2, 2, 2]
 */
public class _02 {

    public int minMoves (int[] nums) {

        Arrays.sort(nums);

        int res = 0;
        int midValue = nums[nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(midValue - nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        _02 solution = new _02();

        int[] nums = {1, 2, 4};
        int res = solution.minMoves(nums);

        System.out.println(res);
    }
}
