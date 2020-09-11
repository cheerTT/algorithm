package test._360._0911;

import java.util.*;

public class _01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] nums = new int[m][2];

        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < m; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();

            if (map.containsKey(nums[i][0])) {
                map.put(nums[i][0], -1);
            } else {
                map.put(nums[i][0], nums[i][1]);
            }
        }

        int[] comp = new int[n + 1];
        for (Integer key : map.keySet()) {
            if (map.get(key) != -1) {
                int tmp = map.get(key) == 0 ? -1 : 1;
                comp[key] = tmp;
            } else {
                comp[key] = 2;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (comp[i] == 0) {
                res.add(i);
            }
        }

        if (nums[0][0] == nums[m - 1][0]) {
            res.add(nums[0][0]);
        } else if (nums[0][1] == 1 && nums[m - 1][1] == 0) {
            res.add(nums[0][0]);
        }

        for (Integer re : res) {
            System.out.print(re + " ");
        }

    }
}
