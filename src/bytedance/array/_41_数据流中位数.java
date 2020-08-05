package bytedance.array;

import java.util.PriorityQueue;

// 利用最小堆和最大堆实现
public class _41_数据流中位数 {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    private int cnt;

    public _41_数据流中位数() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        cnt = 0;
    }

    // 前一半放最大堆
    // 后一半放最小堆
    public void addNum(int num) {
        cnt++;
        if (cnt % 2 == 0) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public double findMedian() {

        if (!minHeap.isEmpty() || !maxHeap.isEmpty()) {
            if (cnt % 2 == 0) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
            }
        } else {
            return 0.0;
        }

    }
}
