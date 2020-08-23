package test.qushikeji._0823;

import java.util.Scanner;

public class _02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n < 1 || n > 20) {
            System.out.println("error");
            System.exit(0);
        }

        int[][] res = transfer(n);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.printf("%4d", res[i][j]);
            }
            if (i != res.length - 1)
                System.out.println();
        }

    }

    public static int[][] transfer(int n) {

        int rs = 0;
        int re = n;
        int cs = n;
        int ce = 0;

        int[][] res = new int[n][n];

        int num = 1;
        while (rs < re && cs > ce) {

            if (rs == re - 1) { // 只有一行的情况
                for (int j = ce; j < cs; j++) {
                    res[rs][j] = num++;
                }
            } else if (ce == cs - 1) { // 只有一列的情况
                for (int i = rs; i < re; i++) {
                    res[i][ce] = num++;
                }
            } else { // 环形打印

                // 从上到下-右列
                for (int i = rs; i < re - 1; i++) {
                    res[i][cs - 1] = num++;
                }

                // 从右到左-下行
                for (int j = cs - 1; j > ce; j--) {
                    res[re - 1][j] = num++;
                }

                // 从下到上打印-左列
                for (int i = re - 1; i > rs; i--) {
                    res[i][ce] = num++;
                }

                // 从左到右-上行
                for (int j = ce; j < cs - 1; j++) {
                    res[rs][j] = num++;
                }
            }

            rs++;
            re--;
            cs--;
            ce++;
        }
        return res;
    }
}
