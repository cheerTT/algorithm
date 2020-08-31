package hot;

import java.util.ArrayList;
import java.util.List;

public class _nc_027_集合的所有子集 {

    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {

        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrace(S, 0, list);

        return res;
    }

    private void backtrace(int[] S, int k, List<Integer> list) {

        res.add(new ArrayList<>(list));

        for (int i = k; i < S.length; i++) {
            list.add(S[i]);
            backtrace(S, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
