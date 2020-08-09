package yuanfudao.array;

public class _0048_旋转图像 {

    // 找到一个点，然后开始翻转
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int x = 0, y = n - 1; x < y; x++, y--) {
            for (int s = x, t = y; s < y; s++, t--) {
                int tmp = matrix[x][s];
                matrix[x][s] = matrix[t][x];
                matrix[t][x] = matrix[y][t];
                matrix[y][t] = matrix[s][y];
                matrix[s][y] = tmp;
            }
        }
    }
}
