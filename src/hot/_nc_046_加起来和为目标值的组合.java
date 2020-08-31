package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _nc_046_加起来和为目标值的组合 {

    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {

        Arrays.sort(num);

        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrace(num, 0, list, target);

        return res;
    }

    private void backtrace(int[] num, int k, List<Integer> list, int target) {

        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }

        for (int i = k; i < num.length; i++) {

            if (i > k && num[i - 1] == num[i]) continue;

            list.add(num[i]);
            backtrace(num, i + 1, list, target - num[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        _nc_046_加起来和为目标值的组合 solution = new _nc_046_加起来和为目标值的组合();

        int[] num = {10,1,2,7,6,1,5};
        ArrayList<ArrayList<Integer>> res = solution.combinationSum2(num, 8);

        for (ArrayList<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
