package hot;

public class _nc_059_矩阵的最小路径和 {

    // dp[i][j] 表示从 (i, j) 到原点的最小和
    public int minPathSum (int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) matrix[i][j] += matrix[i][j - 1];
                else if (j == 0) matrix[i][j] += matrix[i - 1][j];
                else matrix[i][j] += Math.min(matrix[i][j - 1], matrix[i - 1][j]);
            }
        }

         return matrix[m - 1][n - 1];
    }

    public static void main(String[] args) {

        _nc_059_矩阵的最小路径和 solution = new _nc_059_矩阵的最小路径和();

        int[][] matric = {{1, 3, 5 ,9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int res = solution.minPathSum(matric);
        System.out.println(res);
    }
}
