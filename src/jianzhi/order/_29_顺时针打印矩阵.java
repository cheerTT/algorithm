package jianzhi.order;

public class _29_顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {

        int rs = 0;
        int re = matrix.length;
        int cs = 0;
        int ce = matrix[0].length;

        int[] res = new int[re * ce];
        int k = 0;
        while (rs < re && cs < ce) {

            if (rs == re - 1) { // 只有一行的情况
                for (int j = cs; j < ce; j++) {
                    res[k++] = matrix[rs][j];
                }
            } else if (cs == ce - 1) { // 只有一列的情况
                for (int i = rs; i < re; i++) {
                    res[k++] = matrix[i][cs];
                }
            } else { // 环形打印
                // 从左到右-上行
                for (int j = cs; j < ce - 1; j++) {
                    res[k++] = matrix[rs][j];
                }
                // 从上到下-右列
                for (int i = rs; i < re - 1; i++) {
                    res[k++] = matrix[i][ce - 1];
                }
                // 从右到左-下行
                for (int j = ce - 1; j > cs; j--) {
                    res[k++] = matrix[re - 1][j];
                }
                // 从下到上打印-左列
                for (int i = re - 1; i > rs; i--) {
                    res[k++] = matrix[i][cs];
                }
            }

            rs++;
            re--;
            cs++;
            ce--;
        }
        return res;
    }

    public static void main(String[] args) {

        _29_顺时针打印矩阵 solution = new _29_顺时针打印矩阵();
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        int[] res = solution.spiralOrder(matrix);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
