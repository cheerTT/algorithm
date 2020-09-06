package test.zhaoyin._0906;

import java.util.*;

public class _03 {

    private Set<String> res;
    private boolean[] visited;
    private int start;

    public Set<String> compute(int[][] matrix, int start) {

        this.start = start;
        res = new HashSet<>();
        visited = new boolean[matrix.length];
        StringBuilder sb = new StringBuilder();

        backtrace(matrix, start, sb);

        return res;
    }

    private void backtrace(int[][] matrix, int k, StringBuilder sb) {

        if (visited[k] && k == start) {
            res.add(new String(sb.toString()));
            return;
        }

        for (int j = 0; j < matrix.length; j++) {

            if (matrix[k][j] == 1) {
                if (visited[j]) continue;

                sb.append(j);
                visited[j] = true;
                backtrace(matrix, j, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[j] = false;
            }

        }
    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int start = sc.nextInt();

        _03 solution = new _03();

        Set<String> res = solution.compute(matrix, start);

        for (String re : res) {
            System.out.println(re);
        }

    }

    // 0 1 0 0 0 0 0 1 1 0 1 0 0 0 0 0 0 0 0 1

    /**
     * 6
     * 0 1 1 1 0 1
     * 1 0 0 0 0 1
     * 0 0 0 1 1 1
     * 0 1 0 0 1 1
     * 0 0 0 0 0 0
     * 0 1 0 0 1 0
     * 3
     */
}
