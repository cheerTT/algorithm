package hot;

import java.sql.SQLOutput;

public class _nc_026_排序数组删除重复元素 {

    // 排序数组删除重复元素，最多只保留两个
    public int removeDuplicates(int[] A) {

        int res = 0;
        int i = 0;
        while (i < A.length) {
            int tmp = 1;
            while (i + 1 < A.length && A[i] == A[i+1]) {
                tmp++;
                i++;
            }
            res += (tmp >= 2 ? 2: tmp);
            i++;
        }
        return res;
    }

    public int removeDuplicates1(int[] A) {

        int n = A.length;
        if (n <= 2) return n;

        int cur = 2;
        for (int i = cur; i < n; i++) {
            if (A[i] > A[cur - 2]) {
                A[cur++] = A[i];
            }
        }

        return cur;
    }

    public static void main(String[] args) {

        _nc_026_排序数组删除重复元素 solution = new _nc_026_排序数组删除重复元素();
        int res = solution.removeDuplicates(new int[]{1, 1, 1, 2});
        System.out.println(res);
    }

}
