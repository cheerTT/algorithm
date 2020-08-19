package test.alibaba._0819;

import java.util.Scanner;

public class _02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        long[] res = new long[n];

        for (int k = 0; k < n; k++) {

            long tmp = getMin(nums, 0, k);
            for (int i = 0; i < n - k; i++) {
                tmp = Math.max(tmp, getMin(nums, i, i+k));
            }

            res[k] = tmp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static long getMin(long[] nums, int a, int b) {
        long res = nums[a];
        for (int i = a; i <= b; i++) {
            res = Math.min(res, nums[i]);
        }
        return res;
    }
}
