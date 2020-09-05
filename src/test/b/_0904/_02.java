package test.b._0904;

public class _02 {

    public int[] SpiralMatrix(int[][] matrix) {

        int rs = 0;
        int re = matrix.length;
        int cs = 0;
        int ce = matrix[0].length;

        int[] res = new int[re * ce];
        int k = 0;
        while (rs < re && cs < ce) {

            if (rs == re - 1) {
                for (int j = cs; j < ce; j++) {
                    res[k++] = matrix[rs][j];
                }
            } else if (cs == ce - 1) {
                for (int i = rs; i < re; i++) {
                    res[k++] = matrix[i][cs];
                }
            } else {
                for (int j = cs; j < ce - 1; j++) {
                    res[k++] = matrix[rs][j];
                }
                for (int i = rs; i < re - 1; i++) {
                    res[k++] = matrix[i][ce - 1];
                }
                for (int j = ce - 1; j > cs; j--) {
                    res[k++] = matrix[re - 1][j];
                }
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

        _02 solution = new _02();

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] res = solution.SpiralMatrix(matrix);

        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
