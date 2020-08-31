package hot;

import java.util.ArrayList;
import java.util.List;

public class _nc_043_重复项数字的所有排列 {

    private ArrayList<ArrayList<Integer>> res;
    private boolean[] visited;

    public ArrayList<ArrayList<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrace(nums, list);

        return res;
    }

    private void backtrace(int[] nums, List<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;

            visited[i] = true;
            list.add(nums[i]);

            backtrace(nums, list);

            visited[i] = false;
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {

        _nc_043_重复项数字的所有排列 solution = new _nc_043_重复项数字的所有排列();
        int[] nums = new int[] {1, 2, 3};
        ArrayList<ArrayList<Integer>> res = solution.permute(nums);

        for (ArrayList<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }

            System.out.println();
        }
    }
}
