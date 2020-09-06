package test.tencent._0906;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 通知
 */
public class _02 {

    public static int compute(List<List<Integer>> nums, int n) {

        int res = 0;
        boolean[] visited = new boolean[n];
        boolean[] hasView = new boolean[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).contains(0)) {

                for (Integer integer : nums.get(i)) {
                    visited[integer] = true;
                    for (int j = 0; j < nums.size(); j++) {
                        if (!hasView[j] && nums.get(j).contains(integer)) {
                            visited[integer] = true;
                        } else {

                        }
                    }
                }
                hasView[i] = true;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) res++;
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> nums = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int count = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                list.add(sc.nextInt());
            }
            nums.add(list);
        }
        int res = compute(nums, n);
        System.out.println(res);
    }
}

/**
 *
 *
 * 50 5
 * 2 1 2
 * 5 10 11 12 13 14
 * 2 0 1
 * 2 49 2
 * 4 6 7 8 2
 *
 */
