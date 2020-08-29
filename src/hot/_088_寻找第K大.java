package hot;

public class _088_寻找第K大 {

    public int findKth(int[] a, int n, int K) {
        // write code here
        K = n - K;

        int left = 0;
        int right = n - 1;
        int idx = partition(a, left, right);

        while (idx != K) {
            if (idx < K) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
            idx = partition(a, left, right);
        }

        return a[idx];
    }

    private int partition(int[] a, int i, int j) {

        if (i > j) return 0;
        int flagIdx = i;

        while (i < j) {
            while (i < j && a[j] > a[flagIdx]) j--;
            while (i < j && a[i] < a[flagIdx]) i++;

            if (i < j) {
                swap(a, i, j);
            }
        }

        swap(a, i, flagIdx);

        return i;
    }

    private void swap(int[] a, int i ,int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
