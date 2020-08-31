package type.backtrace;

import java.util.ArrayList;
import java.util.List;

public class _0077_组合 {

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        backtrace(n, k, 0, list);

        return res;
    }

    private void backtrace(int n, int k, int start, List<Integer> list) {

        // 终止条件
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 遍历
        for (int i = start; i <= n - k + 1; i++) {

            list.add(i);
            backtrace(n, k--, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
