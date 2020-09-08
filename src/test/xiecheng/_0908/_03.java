package test.xiecheng._0908;

import java.util.Scanner;

public class _03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int e0 = sc.nextInt();
        int times = sc.nextInt();
        int l = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        _03 solution = new _03();

        int res = solution.compute(matrix, times, l, e0);

        System.out.println(res);
    }

    private int times;
    private int l;
    private int minPath = 0;
    private boolean[][] visited;

    private int compute(int[][] matrix, int times, int l, int e0) {

        this.times = times;
        this.l = l;
        visited = new boolean[matrix.length][matrix[0].length];

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return minPath;
        int m = matrix.length;
        int n = matrix[0].length;

        dfs(matrix, 0, 0, e0 + matrix[0][0]);

        return minPath;
    }

    private void dfs(int[][] matrix, int i, int j, int e0) {

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return;
        }

        if (e0 - matrix[i][j] < 0) {
            minPath--;
            return;
        }

        if (i == matrix.length - 1 && j == matrix[0].length - 1) return;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        visited[i][j] = true;
        minPath++;
        System.out.print(matrix[i][j] + " ");
        for (int[] direction : directions) {

            dfs(matrix, i + direction[0], j + direction[1], e0 - matrix[i][j]);
        }
//        visited[i][j] = false;
    }
}

// 6 8 15 0 45  10 1 30 10 1 10 1 1 20 1 1 30 1 1 10 1 10 50 1 1 1 1 1 100 20 10 20 20 1 1 1 100 20 10 10 10 1 1 100 1 30 30 30 20 100 1 1 0
// 16