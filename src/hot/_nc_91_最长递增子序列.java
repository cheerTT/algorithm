package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _nc_91_最长递增子序列 {

    // dp[i] 表示以 i 结尾的最长递增子序列的长度
    // dp[i] =
    public int LIS(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    } else if (dp[j] + 1 == dp[i]) {
//                        list.add(nums[i]);
                    }
                }
            }
            res = Math.max(res, dp[i]);

            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }

        return res;
    }


    public static void main(String[] args) {

        _nc_91_最长递增子序列 solution = new _nc_91_最长递增子序列();

        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int res = solution.LIS(arr);
        System.out.println(res);



    }
}
