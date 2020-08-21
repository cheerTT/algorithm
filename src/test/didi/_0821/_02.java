package test.didi._0821;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<int[]> res = new ArrayList<>();

        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (200 * a + 10 * b + 12 * c == n && a != b && b != c && a != c) {
                        res.add(new int[] {a, b, c});
                    }
                }
            }
        }

        System.out.println(res.size());
        for (int[] re : res) {
            int num1 = re[0] * 100 + re[1] * 10 + re[2];
            int num2 = re[0] * 100 + re[2] * 10 + re[2];
            System.out.println(num1 + " " + num2);
        }
    }
}
