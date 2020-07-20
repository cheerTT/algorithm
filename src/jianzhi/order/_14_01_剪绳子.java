package jianzhi.order;

public class _14_01_剪绳子 {

    // 递归
    // 时间复杂度 O(2^n)
    public int cuttingRope1(int n) {

        if (n == 2) return 1;

        int res = 0;

        for (int i = 1; i < n; i++) {
            res = Math.max(res,i * Math.max(n - i, cuttingRope1(n - i)));
        }

        return res;

    }

    int[] memo;
    // 记忆化搜索
    // 时间复杂度O(2^n)
    public int cuttingRope2(int n) {
        memo = new int[n + 1];
        return help(n);
    }

    private int help(int n) {
        if (n == 2) return 1;

        if (memo[n] != 0) return memo[n];

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * help(n - i)));
        }
        memo[n] = res;
        return res;
    }

    // 动态规划
    // 时间复杂度 O(n2)
    public int cuttingRope3(int n) {

        // n段时的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {

                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    // 贪心
    // 时间复杂度 O(n)
    public int cuttingRope4(int n) {

        if (n < 4) return n - 1;

        int res = 1;

        while (n > 4) {
            res *= 3;
            n -= 3;
        }

        return res * n;
    }

    public static void main(String[] args) {

        _14_01_剪绳子 剪绳子 = new _14_01_剪绳子();

        long start = System.currentTimeMillis();
        int i = 剪绳子.cuttingRope1(3);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(i);  // 36


        long start1 = System.currentTimeMillis();
        int i1 = 剪绳子.cuttingRope2(1000);
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
        System.out.println(i1);  // 36

        long start2 = System.currentTimeMillis();
        int i2 = 剪绳子.cuttingRope3(1000);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
        System.out.println(i2);  // 36

        long start3 = System.currentTimeMillis();
        int i3 = 剪绳子.cuttingRope4(10);
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);
        System.out.println(i3);  // 36
    }



}
