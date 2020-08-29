package test.meituan._0829;

import java.util.Scanner;

public class _06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // 序列的最大值
        int n = sc.nextInt(); // 序列的长度

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    if (isOrder(nums, 0, j - 1, m)
                            && isOrder(nums, i + 1, n - 1, m)) {
                        res++;
                    }
                    System.out.println(i + " " + j + " | " + nums[i] + " " + nums[j]);
                }
            }
        }

        System.out.println(res);
    }

    private static boolean isOrder(int[] nums, int start, int end, int m) {
        if (start >= end) return true;

        for (int i = start + 1; i <= end; i++) {
            if (nums[i - 1] > nums[i] || nums[i] > m) return false;
        }

        return true;
    }

}
