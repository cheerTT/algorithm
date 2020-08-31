package type.backtrace;

import java.util.ArrayList;
import java.util.List;

public class _0046_全排列 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(nums, visited, list, res);

        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {

        if (list.size() == nums.length) {
            // 存值
            res.add(new ArrayList<>(list));
            return;
        }

        // 为什么要这个 for 循环，因为每个值都有可能作为起始值
        for (int i = 0; i < nums.length; i++) {

            // 直接结束，因为这个点已经使用了
            if (visited[i]) continue;

            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, visited, list, res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {

        _0046_全排列 solution = new _0046_全排列();
        List<List<Integer>> res = solution.permute(new int[]{1, 2, 3});

        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
