package alibaba.str;

import java.util.Deque;
import java.util.LinkedList;

public class _笔试_滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {

            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }

            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
        }

        return  null;
    }
}
