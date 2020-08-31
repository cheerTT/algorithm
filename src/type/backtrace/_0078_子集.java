package type.backtrace;

import java.util.ArrayList;
import java.util.List;

public class _0078_子集 {

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {

        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrace(nums, 0, list);
        return res;
    }

    private void backtrace(int[] nums, int start, List<Integer> list) {

        // 终止条件，没有终止条件
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {

            list.add(i);
            backtrace(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
