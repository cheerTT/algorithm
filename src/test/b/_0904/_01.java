package test.b._0904;

import test.meituan._0829._04;

public class _01 {

    public int GetMaxConsecutiveOnes (int[] arr, int k) {

        int res = 0;
        int tmp1 = 0; // 统计可容忍 0 的个数
        int tmp2 = 0; // 消耗 0 的个数

        int num0 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) num0++;
        }

        int len = 0;
        for (int j = 0; j < num0; j++) {
            tmp1 = j;
            tmp2 = k;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == 1) len++;
                else if (tmp1 > 0 && arr[i] == 0) {
                    tmp1--;
                    len = 0;
                    count = 0;
                } else if (tmp1 == 0 && tmp2 > 0 && arr[i] == 0) {
                    len++;
                    tmp2--;
                } else {
                    len = 0;
                }

                count = Math.max(count, len);
            }
            res = Math.max(res, count);
        }
        return res;

    }

    public static void main(String[] args) {

        _01 solution = new _01();

        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int res = solution.GetMaxConsecutiveOnes(arr, 2);
        System.out.println(res);
    }
}
