package hot;

public class _nc_019_子数组的最大累加和问题 {

    // dp[i][j] 表示从位置 i 加到 j的最大和
    public int maxsumofSubarray(int[] arr) {

        int n = arr.length;

        int[] dp = new int[n];
        dp[0] = arr[0];

        int res = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);

            if (res < dp[i]) {
                res = dp[i];
            }

        }

        return dp[n - 1];
    }

    // 不用 dp
    public int maxsumofSubarray1(int[] arr) {

        int tmp = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            tmp = Math.max(tmp + arr[i], arr[i]);
            res = Math.max(res, tmp);
        }

        return res;
    }
}
