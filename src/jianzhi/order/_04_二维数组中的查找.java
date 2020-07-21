package jianzhi.order;

public class _04_二维数组中的查找 {

    // 从左下角或右上角开始
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }
}
