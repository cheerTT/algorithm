package jianzhi.order;

import java.util.ArrayList;
import java.util.List;

public class _57_02_和为s的连续整数序列 {

    // 滑动窗口
    // 是一个左闭右开区间
    public int[][] findContinuousSequence(int target) {

        List<int[]> res = new ArrayList<>();

        int i = 1; // 左区间
        int j = 1; // 右区间
        int sum = 0; // 滑动窗口中的和
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] tmp = new int[j - i];
                for (int k = i; k < j; k++) {
                    tmp[k - i] = k;
                }
                res.add(tmp);
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
