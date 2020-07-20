package jianzhi.order;

public class _13_机器人的运动范围 {

    // 无需回溯，走过的就不能再走了
    public int movingCount(int m, int n, int k) {
        int[][] flag = new int[m][n];

        return help(m, n, 0, 0, k, flag);
    }

    private int help(int m, int n, int i, int j, int k, int[][] flag) {
        int res = 0;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        if (canwalk(m, n, i, j, k, flag)) {
            flag[i][j] = 1;
            res = 1;
            for (int[] direction : directions) {
                res += help(m, n, i + direction[0], j + direction[1], k, flag);
            }
        }
        return res;
    }

    private boolean canwalk(int m, int n, int i, int j, int k, int[][] flag) {
        if (i < 0 || i >= m || j < 0 || j >= m || num(i) + num(j) > k || flag[i][j] == 1) {
            return false;
        }
        return true;
    }

    private int num(int t) {
        int res = 0;
        while (t != 0) {
            res += t % 10;
            t = t / 10;
        }
        return res;
    }
}
