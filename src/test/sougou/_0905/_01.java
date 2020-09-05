package test.sougou._0905;

import java.util.Arrays;

public class _01 {

    public int numberofprize (int a, int b, int c) {

        int[] nums = {a, b, c};

        Arrays.sort(nums);

        b = nums[1] - nums[0];
        c = nums[2] - nums[1];

        int ans = nums[0];
        int cb = c - b;

        if (b <= cb / 2) {
            ans += b;
        }

        return 0;
    }

    private int[] maxAndMin(int a, int b, int c) {

        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));

        return new int[] {max, min};
    }
}
