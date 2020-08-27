package type.sort.base;

public class HeapSort {

    public void findTopN(int[] nums, int n) {

        // 构建 n个数的小顶堆
        buildHeap(nums, n);

        // n 往后的数进行调整
        for(int i = n; i < nums.length; i++) {
            adjust(nums, i, n);
        }
    }

    // 打印数组
    public void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 构建堆
    private void buildHeap(int[] nums, int n) {
        // 构造堆的时候
        for (int i = 1; i < n; i++) {
            int t = i;
            while (t != 0 && nums[parent(t)] > nums[t]) {
                swap(nums, t, parent(t));
                t = parent(t);
            }
        }
    }

    private void adjust(int[] nums, int i, int n) {

        if (nums[i] < nums[0]) return;

        swap(nums, 0, i);

        int t = 0;

        while ((leftChild(t) < n && nums[t] > nums[leftChild(t)])
                || (rightChild(t) < n && nums[t] > nums[rightChild(t)])) {

            if (rightChild(t) < n && nums[rightChild(t)] < nums[leftChild(t)]) {

                swap(nums, t, rightChild(t));
                t = rightChild(t);
            } else {
                swap(nums, t, leftChild(t));
                t = leftChild(t);
            }
        }

    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {

        HeapSort topN = new HeapSort();

        int[] arr1 = new int[] {56, 30, 71, 18, 29, 93, 44, 75, 20, 65, 68, 34};

        System.out.println("原数组：");
        topN.print(arr1);
        topN.findTopN(arr1, 12);
        System.out.println("调整后数组：");
        topN.print(arr1);

//        topN.buildHeap(arr1, 5);
//        topN.print(arr1);
    }
}
