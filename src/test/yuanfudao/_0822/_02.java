package test.yuanfudao._0822;

import java.util.Scanner;

public class _02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        int p = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] < 0) continue;
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] < 0) {
                    continue;
                }

                res = Math.max(res, matrix[i][j]);
            }
        }
    }

    private void dfs(int[][] matrix, int i, int j, int res) {

        if (matrix[i][j] > 0) {
        }
    }
}
