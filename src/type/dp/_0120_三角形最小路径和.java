package type.dp;

import java.util.ArrayList;
import java.util.List;

public class _0120_三角形最小路径和 {

    // 1 递归 O(n2) O(n2)
    public int minimumTotal1(List<List<Integer>> triangle) {

        return help1(triangle, 0, 0);
    }

    // f(i, j) = min(f(i + 1, j), f(i + 1, j + 1)) + t[i][j]
    private int help1(List<List<Integer>> triangle, int i, int j) {

        if (i == triangle.size()) return 0;

        return Math.min(help1(triangle, i + 1, j), help1(triangle,i + 1,j + 1)) + triangle.get(i).get(j);

    }

    Integer[][] memo;

    // 2 记忆化搜索 O(n2) O(n2)
    public int minimumTotal2(List<List<Integer>> triangle) {

        memo = new Integer[triangle.size()][triangle.size()];

        return help2(triangle, 0, 0);
    }

    public int help2(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) return 0;

        if (memo[i][j] != null) return memo[i][j];

        memo[i][j] = Math.min(help2(triangle, i + 1, j), help2(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        return memo[i][j];
    }

    // 动态规划 O(n2) O(n2)
    public int minimumTotal3(List<List<Integer>> triangle) {

        int n = triangle.size();

        // 从 dp[i][j] 到根节点的最小和
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    // 优化版动态规划 O(n2) O(n)
    public int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(3);
        list4.add(8);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        _0120_三角形最小路径和 solution = new _0120_三角形最小路径和();

        int res = solution.minimumTotal4(triangle);
        System.out.println(res);
    }
}
