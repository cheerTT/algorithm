package jianzhi.order;

import java.util.ArrayList;
import java.util.List;

public class _45_把数组排成最小的数 {

    // 自定义排序
    // 时间复杂度 O(nlogn)
    public String minNumber(int[] nums) {

        StringBuilder sb = new StringBuilder();

        List<String> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            res.add(String.valueOf(nums[i]));
        }

        res.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        for (String re : res) {
            sb.append(re);
        }

        return sb.toString();
    }
}
