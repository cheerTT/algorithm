package test.laohuzhengquan._0823;

import java.util.ArrayList;
import java.util.List;

public class _02 {

    // 花光 m 块钱的所有组合
    public static void compute(int[] nums, int m) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        help(nums, 0, m, list, res);

        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void help(int[] nums, int i, int m, List<Integer> list, List<List<Integer>> res) {

        if (i == nums.length) {
            if (m == 0) {
                res.add(new ArrayList<>(list));
            }
        } else if (m == 0) {
            res.add(new ArrayList<>(list));
        } else {
            // 加入
            list.add(nums[i]);
            help(nums, i + 1, m - nums[i], list, res);
            list.remove(nums[i]);

            // 不加入
            help(nums, i + 1, m, list, res);
        }

    }

    public static void main(String[] args) {


        compute(new int[] {3, 8, 6}, 14);
    }
}
