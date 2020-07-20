package jianzhi.order;

public class _47_礼物的最大价值 {

    // 二维动态规划
    // dp[i][j] 走到 i, j 位置礼物的最大价值
    // dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
    // 多开一行一列，让代码看上去更整洁
    public int maxValue1(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
            }
        }

        return dp[m][n];
    }

    // 一维动态规划
//    public int maxValue2(int[][] grid) {
//
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[] dp = new int[n + 1];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (i == 0) {
//                    dp[j] = grid[i][j - 1];
//                } else {
//                    dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j - 1];
//                }
//            }
//        }
//
//        return dp[n];
//    }

    // 在原数组上操作
    public int maxValue3(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // 初始化第一行第一列
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }



    public static void main(String[] args) {

        _47_礼物的最大价值 solution = new _47_礼物的最大价值();

        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        int res1 = solution.maxValue1(grid);
        System.out.println(res1);

//        int res2 = solution.maxValue2(grid);
//        System.out.println(res2);

        int res3 = solution.maxValue3(grid);
        System.out.println(res3);

    }
}
