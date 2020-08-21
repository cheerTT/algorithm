package test.didi._0821;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class _03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] nums = dfs(n * n);
        long[][] res = transfer(nums, n);

        for (int i = 0; i < n; i++) {
            System.out.print(res[i][0]);
            for (int j = 1; j < n; j++) {
                System.out.print(" " + res[i][j]);
            }
            System.out.println();
        }

    }

    public static long[][] transfer(long[] nums, int n) {

        int rs = 0;
        int re = n;
        int cs = 0;
        int ce = n;

        long[][] res = new long[n][n];

        int k = nums.length - 1;
        while (rs < re && cs < ce) {

            if (rs == re - 1) { // 只有一行的情况
                for (int j = cs; j < ce; j++) {
                    res[rs][j] = nums[k--];
                }
            } else if (cs == ce - 1) { // 只有一列的情况
                for (int i = rs; i < re; i++) {
                    res[i][cs] = nums[k--];
                }
            } else { // 环形打印
                // 从左到右-上行
                for (int j = cs; j < ce - 1; j++) {
                    res[rs][j] = nums[k--];
                }
                // 从上到下-右列
                for (int i = rs; i < re - 1; i++) {
                    res[i][ce - 1] = nums[k--];
                }
                // 从右到左-下行
                for (int j = ce - 1; j > cs; j--) {
                    res[re - 1][j] = nums[k--];
                }
                // 从下到上打印-左列
                for (int i = re - 1; i > rs; i--) {
                    res[i][cs] = nums[k--];
                }
            }

            rs++;
            re--;
            cs++;
            ce--;
        }
        return res;
    }

    private static long[] dfs(int num) {

        if (num == 0) return null;
        if (num < 2) return new long[]{1};

        long[] res = new long[num];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i < num; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        return res;
    }
}
