package test.meituan._0829;

import java.util.Scanner;

public class _05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // 序列的最大值
        int n = sc.nextInt(); // 序列的长度

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = mergeSort(nums, 0, n - 1);

        System.out.println(res);
    }

    public static int mergeSort(int[] nums, int l, int r) {

        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        return mergeSort(nums, l, mid) + mergeSort(nums, mid+1, r) + merge(nums, l, mid, r);
    }

    public static int merge(int[] nums, int l, int m, int r) {

        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += nums[p1] <= nums[p2] ? (m - p1 + 1) : 0;

            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }

        while (p1 <= m) {
            help[i++] = nums[p1++];
        }

        while (p2 <= r) {
            help[i++] = nums[p2++];
        }

        for (i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }

        return res;
    }
}
