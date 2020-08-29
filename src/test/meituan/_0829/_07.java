package test.meituan._0829;

import java.util.Arrays;
import java.util.Scanner;

public class _07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] A = new long[n];
        long[] B = new long[n];
        Arrays.fill(B, -1);


        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int times = sc.nextInt();

        while (--times >= 0) {
            int type = sc.nextInt();
            String value = sc.nextLine();

            String[] strs = value.trim().split(" ");

            if (type == 2) {
                if (Integer.parseInt(strs[0]) <= n)
                    System.out.println(B[Integer.parseInt(strs[0]) - 1]);
                else
                    System.out.println(-1);
            }


            if (type == 1) {
                int[] ints = new int[4];
                int k = 0;
                for (String str : strs) {
                    ints[k++] = Integer.parseInt(str);
                }
                int idx = ints[0];
                System.out.println();
                for (int i = ints[2] - 1; i < ints[2] + ints[1]; i++) {
                    if (i < n && idx < n)
                        B[i] = A[idx++];
                }
            }

            System.out.println();
            for (int i = 0; i < n; i++) {

                System.out.print(B[i] + ",");
            }
            System.out.println();
        }
    }
}
