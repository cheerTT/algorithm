package alibaba.str;

import java.util.Arrays;
import java.util.Scanner;

public class _笔试_最短距离 {

    // 直线上选一点使得到给出的N个直线上的点的距离之和最短。
    public static void main(String[] args) {

        long res = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        Arrays.sort(nums);

        int mid = (n - 1) / 2;

        for (int i = 0; i < mid; i++) {
            res += (nums[mid] - nums[i]);
        }

        for (int i = mid + 1; i < n; i++) {
            res += (nums[i] - nums[mid]);
        }

        System.out.println(res);
    }
}
