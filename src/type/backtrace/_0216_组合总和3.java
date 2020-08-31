package type.backtrace;

import java.util.ArrayList;
import java.util.List;

public class _0216_组合总和3 {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {

        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrace(k, n, 1, list);

        return res;
    }

    private void backtrace(int k, int n, int start, List<Integer> list) {

        if (k == 0 && n <= 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (k == 0 || n == 0) return;

        for (int i = start; i <= 9; i++) {

            list.add(i);
            backtrace(k - 1, n - i, i + 1, list);
            list.remove(list.size() - 1);
        }

    }
}
