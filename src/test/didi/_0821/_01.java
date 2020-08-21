package test.didi._0821;

public class _01 {

    public static void main(String[] args) {

        int[][]  a = new int[11][11];

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) a[i][j] = 1;
                else {
                    a[i][j] = a[i -1][j] + a[i - 1][j - 1];
                }
            }
        }

        System.out.println(a[8][3]);
    }
}
