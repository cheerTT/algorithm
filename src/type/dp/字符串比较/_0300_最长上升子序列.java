package type.dp.字符串比较;

import java.util.Arrays;

public class _0300_最长上升子序列 {

    public int lengthOfLIS(int[] arr) {

        int n = arr.length;

        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[1] = arr[0];

        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > dp[k]) {
                dp[++k] = arr[i];
            } else {
                int tmpIdx = binarySearch(dp, k, arr[i]);
                dp[tmpIdx] = arr[i];
            }
        }

        for (int i = 1; i <= k; i++) {
            System.out.print(arr[i] + " ");
        }
        return k;
    }

    private int binarySearch(int[] dp, int n, int val) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] == val) right = mid;
            else if (dp[mid] < val) left = mid + 1;
            else if (dp[mid] > val) right = mid;
        }

        return left;
    }

    // dp[i] 表示 nums 前 i 个数字的最长子序列长度
    public int lengthOfLIS1(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
