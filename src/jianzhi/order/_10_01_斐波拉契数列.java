package jianzhi.order;

import sun.misc.InnocuousThread;

public class _10_01_斐波拉契数列 {

    // 递归
    // F(0) = 0, F(1) = 1
    // F(n) = F(n - 1) + F(n - 2);
    // 时间复杂度 O(2^n)
    // 空间复杂度 O(n)
    public int fib1(int n) {

        if (n < 2 && n >= 0) return n;

        return fib1(n - 1) + fib1(n - 2);
    }

    int[] memo;
    // 记忆化搜索
    public int fib2(int n) {
        memo = new int[n + 1];
        return help(n);
    }

    private int help(int n) {

        if (n < 2 && n >= 0) return n;

        if (memo[n] != 0) return memo[n];

        memo[n] = help(n - 1) + help(n - 2);

        return memo[n];
    }

    // 动态规划
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public int fib3(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 动态规划 优化
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int fib4(int n) {

        int a = 0;
        int b = 1;
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return tmp;
    }

    public static void main(String[] args) {

        _10_01_斐波拉契数列 solution = new _10_01_斐波拉契数列();
        int res1 = solution.fib1(10);
        System.out.println(res1);
        int res2 = solution.fib2(10);
        System.out.println(res2);
        int res3 = solution.fib3(10);
        System.out.println(res3);
        int res4 = solution.fib4(10);
        System.out.println(res4);
    }
}
