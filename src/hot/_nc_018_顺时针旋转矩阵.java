package hot;

public class _nc_018_顺时针旋转矩阵 {

    public int[][] rotateMatrix(int[][] mat, int n) {

        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - 1 - i] = mat[i][j];
            }
        }

        return tmp;
    }

    public int[][] rotateMatrix1(int[][] mat, int n) {

        for (int x = 0, y = n - 1; x < y; x++, y--) {
            for (int s = x, t = y; s < y; s++, t--) {
                int tmp = mat[x][s];
                mat[x][s] = mat[t][x];
                mat[t][x] = mat[y][t];
                mat[y][t] = mat[s][y];
                mat[s][y] = tmp;
            }
        }

        return mat;
    }
}
