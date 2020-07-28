package jianzhi.order;

import java.util.ArrayList;
import java.util.List;

public class _62_圆圈中最后剩下的数字 {

    // 模拟链表超时
    // 时间复杂度 O(n2)
    public int lastRemaining(int n, int m) {

        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;

        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }

        return list.get(0);
    }

    // 时间复杂度 O(n)
    public int lastRemaining1(int n, int m) {
        int res = 0;

        // 最后一轮剩下2个人，从2开始反推
        for (int i = 2; i < n; i++) {
            res = (res + m) % 2;
        }

        return res;
    }
}
