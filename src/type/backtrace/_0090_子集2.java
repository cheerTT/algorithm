package type.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0090_子集2 {

    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrace(nums, 0, list);

        return res;
    }

    private void backtrace(int[] nums, int start, List<Integer> list) {

        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i - 1] == nums[i]) continue;

            list.add(nums[i]);
            backtrace(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
