package hot;

public class _nc_036_在两个长度相等的排序数组找中位数 {

    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        // write code here
        int len1 = arr1.length;
        int len2 = arr2.length;

        if (len1 == 0 || len2 == 0 || len1 != len2) return 0;

        int i = 0;
        int j = 0;

        int res = 0;
        while (len1 > 0) {
            if (arr1[i] < arr2[j]) {
                res = arr1[i];
                i++;
            } else {
                res = arr2[j];
                j++;
            }
            len1--;
        }

        return res;
    }

    public static void main(String[] args) {


    }
}
