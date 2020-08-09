package yuanfudao.backtracking;

public class _0200_岛屿数量 {


    // 当前元素若是 1，则进行深度遍历，遍历过得元素标记为 2
    public int numIslands(char[][] grid) {

        int res = 0;

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        grid[i][j] = '2';
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
        }
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
