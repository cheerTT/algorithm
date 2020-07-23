package jianzhi.order;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _59_02_队列的最大值 {

    Queue<Integer> queue;
    Deque<Integer> max;  // 双端队列

    // 与最小栈不同，max队列里面只维护最大的值，queue和max里面的元素个数是不相等的
    public _59_02_队列的最大值() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.isEmpty() ? -1 : max.peek();
    }

     public void push_back(int value) {
        queue.offer(value);

        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.offerLast(value);
     }

     public int pop_front() {
        int tmp = queue.isEmpty() ? -1 : queue.poll();
        if (!max.isEmpty() && max.peek() == tmp) {
            max.poll();
        }
        return tmp;
     }
}
