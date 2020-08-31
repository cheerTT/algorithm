package type.backtrace.dims;

public class _0130_被围绕的区域 {

    private int m;
    private int n;

    public void solve(char[][] board) {

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = '0';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {

        if (!isValid(x, y) || board[x][y] != 'O') return;

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        board[x][y] = 'A';

        for (int[] direction : directions) {
            dfs(board, x + direction[0], y + direction[1]);
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
