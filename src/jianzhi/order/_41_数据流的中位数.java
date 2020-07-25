package jianzhi.order;

import java.util.PriorityQueue;

public class _41_数据流的中位数 {

    private PriorityQueue<Integer> maxHeap; // 大根堆放前一半元素（较小）
    private PriorityQueue<Integer> minHeap; // 小根堆放后一半元素（较大）
    private int count; // 统计元素的个数

    public _41_数据流的中位数() {
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();
        count = 0;
    }

    public void addNum(int num) {

        count++;
        if (count % 2 == 0) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
         }

    }

    public double findMedian() {
        if (!maxHeap.isEmpty() && minHeap.isEmpty()) {
            if (count % 2 == 0) {
                return (maxHeap.peek() + minHeap.peek() ) / 2.0;
            } else {
                return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
            }
        } else {
            return 0.0;
        }

    }
}
