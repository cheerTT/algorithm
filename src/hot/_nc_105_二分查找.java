package hot;

public class _nc_105_二分查找 {

    public int upper_bound_ (int n, int v, int[] a) {

        return binSearch(a, v);
    }

    private int help(int[] a, int i, int j, int v) {

        if (i > j) return a.length;

        int mid = (i + j) / 2;

        if (a[mid] == v) return mid;

        if (a[mid] > v) {
            j = mid - 1;
            return help(a, i, j, v);
        } else {
            i = mid + 1;
            return help(a, i, j, v);
        }
    }
    private static int binSearch(int[] a, int key) {
        int mid = a.length / 2;
        if (key == a[mid]) {
            return mid;
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        _nc_105_二分查找 solution = new _nc_105_二分查找();

        int res = solution.upper_bound_(12, 97, new int[]{91,92,93,94,94,94,95,97,97,98,98,99});
        System.out.println(res);
    }
}


