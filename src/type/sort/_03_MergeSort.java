package type.sort;

public class _03_MergeSort {

    public static void mergeSort(int[] arr) {

        if (arr == null || arr.length < 2) return;

        mergeProcess(arr, 0, arr.length - 1);
    }

    private static void mergeProcess(int[] arr, int left, int right) {

        if (left == right) return;

        int mid = (left + right) / 2;
        mergeProcess(arr, left, mid);
        mergeProcess(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] help = new int[right - left + 1];

        int p1 = left;
        int p2 = mid + 1;

        int k = 0;
        while (p1 <= mid && p2 <= right) {
            help[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[k++] = arr[p1++];
        }

        while (p2 <= right) {
            help[k++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[i + left] = help[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = {9, 4, 2, 8, 5, 3, 5, 6};

        mergeSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
