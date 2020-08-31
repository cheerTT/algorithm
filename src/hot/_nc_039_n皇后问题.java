package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _nc_039_n皇后问题 {

    private int n;
    private boolean[] colUsed;
    private boolean[] diaglog45;
    private boolean[] diaglog135;

    public int Nqueen(int n) {

        this.n = n;
        colUsed = new boolean[n];
        diaglog45 = new boolean[2 * n - 1];
        diaglog135 = new boolean[2 * n - 1];
        List<List<String>> res = new ArrayList<>();

        char[][] nQueue = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueue[i], '.');
        }

        backtrace1(nQueue, 0, res);

        return res.size();
    }

    private void backtrace(char[][] nQueue, int row, List<List<String>> res) {

        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(String.valueOf(nQueue[i]));
            }
            res.add(list);
        }

        for (int col = 0; col < n; col++) {

            if (!isValid(nQueue, row, col)) continue;

            nQueue[row][col] = 'Q';

            backtrace(nQueue, row + 1, res);

            nQueue[row][col] = '.';

        }
    }

    private boolean isValid(char[][] nQueue, int row, int col) {

        // 列
        for (int i = 0; i < n; i++) {
            if (nQueue[i][col] == 'Q') return false;
        }

        // 右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (nQueue[i][j] == 'Q') return false;
        }

        // 左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (nQueue[i][j] == 'Q') return false;
        }

        return true;
    }

    private void backtrace1(char[][] nQueue, int row, List<List<String>> res) {

        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(String.valueOf(nQueue[i]));
            }
            res.add(list);
        }

        for (int col = 0; col < n; col++) {

            int idx45 = row + col;
            int idx135 = n - 1 - (row - col);

            if (colUsed[col] || diaglog45[idx45] || diaglog135[idx135]) continue;

            colUsed[col] = true;
            diaglog45[idx45] = true;
            diaglog135[idx135] = true;

            nQueue[row][col] = 'Q';

            backtrace1(nQueue, row + 1, res);

            nQueue[row][col] = '.';

            colUsed[col] = false;
            diaglog45[idx45] = false;
            diaglog135[idx135] = false;
        }
    }

    public static void main(String[] args) {

        _nc_039_n皇后问题 solution = new _nc_039_n皇后问题();
        int res = solution.Nqueen(9);
        System.out.println(res);
    }
}
