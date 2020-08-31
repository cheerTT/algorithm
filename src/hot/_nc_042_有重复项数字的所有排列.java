package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _nc_042_有重复项数字的所有排列 {

    private ArrayList<ArrayList<Integer>> res;
    private boolean[] visited;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        Arrays.sort(num);

        res = new ArrayList<>();
        visited = new boolean[num.length];
        List<Integer> list = new ArrayList<>();

        backtrace(num, list);

        return res;
    }

    private void backtrace(int[] num, List<Integer> list) {

        if (list.size() == num.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < num.length; i++) {

            if (i > 0 && num[i - 1] == num[i] && !visited[i - 1]) continue;

            if (visited[i]) continue;

            visited[i] = true;
            list.add(num[i]);

            backtrace(num, list);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
