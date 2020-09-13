package test.vivo._0912;

import java.util.Scanner;

public class _01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int start_i = sc.nextInt();
        int start_j = sc.nextInt();
        int end_i = sc.nextInt();
        int end_j = sc.nextInt();

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();
            for (int j = 0; j < tmp.length(); j++) {
                matrix[i][j] = tmp.charAt(j);
            }
        }



        if (start_i >= n || start_j >= n || end_i >= n || end_j >= n) {
            System.out.println(-1);
        }

    }

//    private static void dfs(char[][] matrix, int i, int j, )
}

/**
 *
 * # @表示障碍物，最短路径
 *
 */