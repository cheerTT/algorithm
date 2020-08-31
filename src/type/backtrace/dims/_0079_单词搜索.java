package type.backtrace.dims;

public class _0079_单词搜索 {

    private int m;
    private int n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y) {

        if (index == word.length()) {
            return true;
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        if (!isValid(x, y) || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = true;

        for (int[] direction : directions) {
            if (dfs(board, word, index + 1, x + direction[0], y + direction[1])) {
                return true;
            }
        }

        visited[x][y] = false;

        return false;
    }

    private boolean isValid(int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }

    public static void main(String[] args) {

        _0079_单词搜索 solution = new _0079_单词搜索();

        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCB";

        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}
