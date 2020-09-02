package type.backtrace.dims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0417_太平洋大西洋水流问题 {

    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        m = matrix.length;
        n = matrix[0].length;

        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, canReachP);
            dfs(matrix, m - 1, j, canReachA);
        }

        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, canReachP);
            dfs(matrix, i, n - 1, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, int x, int y, boolean[][] canReach) {

        if (canReach[x][y]) return;

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        canReach[x][y] = true; // 不需要回溯
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            // 只有能走到更高的地方或等高的地方
            if (!isValid(newX, newY) || matrix[x][y] > matrix[newX][newY]) continue;
            dfs(matrix, newX, newY, canReach);
        }

    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
