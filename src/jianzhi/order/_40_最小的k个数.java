package jianzhi.order;

import java.util.PriorityQueue;

public class _40_最小的k个数 {

    // 堆排序
    public int[] getLeastNumbers(int[] arr, int k) {

        // 默认是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < arr.length; i++) {
            if (heap.size() < k) {
                heap.offer(arr[i]);
            }
            if (!heap.isEmpty() && heap.peek() > arr[i]) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }

        int[] res = new int[heap.size()];

        int i = 0;

        while (!heap.isEmpty()) {
            res[i++] = heap.poll();
        }
        return res;
    }

    // 快排划分，最小的 k 个数，但是不需要这 k 个数有序；
    // 快排能够保证当前数就是排序好后的最终位置，该位置之前的数均小于该数，该位置之后的数均大于该数；
    public int[] getLeastNumbers1(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int idx = partition(arr, left, right);
        while (idx != k - 1) {
            if (idx < k - 1) {
                left = idx + 1;
                idx = partition(arr, left, right);
            } else {
                right = idx + 1;
                idx = partition(arr, left, right);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;

        int flag = i;

        while (i < j) {
            while (i < j && arr[right] > arr[flag]) j--;
            while (i < j && arr[left] <= arr[flag]) i++;
            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, i, flag);
        return i;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
