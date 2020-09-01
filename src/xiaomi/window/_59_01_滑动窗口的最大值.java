package xiaomi.window;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Deque;
import java.util.LinkedList;

public class _59_01_滑动窗口的最大值 {


    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            // 左边界
            if (i > 0 && nums[deque.peekFirst()] == nums[i - 1]) {
                deque.removeFirst();
            }

            // 右边界
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);

            if (i >= 0) {
                res[i] = deque.peekLast();
            }
        }

        return res;
    }
}
