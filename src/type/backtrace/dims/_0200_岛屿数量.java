package type.backtrace.dims;

public class _0200_岛屿数量 {

    private int m;
    private int n;

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int x, int y) {

        if (!isValid(x, y) || grid[x][y] != '1') return;

        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        grid[x][y] = '2';
        for (int[] direction : directions) {
            dfs(grid, x + direction[0], y + direction[1]);
        }
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }

    public static void main(String[] args) {

        _0200_岛屿数量 solution = new _0200_岛屿数量();

        char[][] grid = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};

        int res = solution.numIslands(grid);
        System.out.println(res);
    }
}
