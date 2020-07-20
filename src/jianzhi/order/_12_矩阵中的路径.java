package jianzhi.order;

// 矩阵中是否存在这样一条路径
public class _12_矩阵中的路径 {

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        int[][] flag = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (help(board, i, j, word, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean help(char[][] board, int i, int j, String word, int k, int[][] flag) {

        if (i < 0 || i > board.length || j < 0 || j > board.length || board[i][j] != word.charAt(k) || flag[i][j] == 1) {
            return false;
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


        if (k == word.length() - 1) return true;

        flag[i][j] = 1;
        for (int[] direction : directions) {
            if (help(board, i + direction[0], j + direction[1], word, k + 1, flag)) {
                return true;
            }
        }
        flag[i][j] = 0;

        return false;
    }
}
