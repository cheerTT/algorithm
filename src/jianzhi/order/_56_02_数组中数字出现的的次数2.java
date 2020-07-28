package jianzhi.order;

import javax.swing.*;
import java.util.HashMap;

public class _56_02_数组中数字出现的的次数2 {

    // 除一个数字出现 1 次外，其余数字都出现 3 次
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0));
        }

        for (Integer val : map.keySet()) {
            if (map.get(val) == 1) {
                return val;
            }
        }
        return -1;
    }

}
