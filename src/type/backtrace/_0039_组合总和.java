package type.backtrace;

import java.util.ArrayList;
import java.util.List;

public class _0039_组合总和 {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrace(candidates, target, 0, list);
        return res;
    }

    private void backtrace(int[] candidates, int target, int start, List<Integer> list) {

        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            list.add(candidates[i]);
            // 这个地方只能是 i 不能是 i + 1,因为本题目允许数字重复使用
            backtrace(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
